package com.vaadin.krisshk243.views.map;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.map.Map;
import com.vaadin.flow.component.map.configuration.Coordinate;
import com.vaadin.flow.component.map.configuration.Feature;
import com.vaadin.flow.component.map.configuration.View;
import com.vaadin.flow.component.map.configuration.feature.MarkerFeature;
import com.vaadin.flow.component.map.configuration.layer.FeatureLayer;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AccessDeniedErrorRouter;
import com.vaadin.krisshk243.services.NominatimService;
import com.vaadin.krisshk243.views.MainLayout;
import fr.dudie.nominatim.model.Element;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@PageTitle("Map")
@Route(value = "/map", layout = MainLayout.class)
@RolesAllowed("ROLE_ADMIN")
@AccessDeniedErrorRouter(rerouteToError = MapViewDeniedException.class)
public class MapView extends HorizontalLayout {

    private static final Location[] DEFAULT_LOCATIONS = new Location[]{
            new Location(1, "Netherlands", "Amsterdam", "Van Gogh Museum", 52.358438, 4.881063),
            new Location(2, "Andorra", "Andorra la Vella", "Casa de la Vall", 42.506563, 1.520563),
            new Location(3, "Greece", "Athens", "Acropolis of Athens", 37.971563, 23.725687),
            new Location(4, "Serbia", "Belgrade", "Belgrade Fortress", 44.823062, 20.450688),
            new Location(5, "Germany", "Berlin", "Brandenburg Gate", 52.516312, 13.377688),
            new Location(6, "Switzerland", "Bern", "Bern Old Town", 46.948187, 7.450188),
            new Location(7, "Slovakia", "Bratislava", "Bratislava Castle", 48.142063, 17.100187),
            new Location(8, "Belgium", "Brussels", "Grand Place", 50.846812, 4.352438),
            new Location(9, "Romania", "Bucharest", "Romanian Athenaeum", 44.441312, 26.097313),
            new Location(10, "Hungary", "Budapest", "Fisherman's Bastion", 47.502187, 19.034813),
            new Location(11, "Moldova", "Chisinau", "Dendrarium Park", 47.032688, 28.810187),
            new Location(12, "Denmark", "Copenhagen", "The Little Mermaid", 55.692812, 12.599312),
            new Location(13, "Ireland", "Dublin", "Kilmainham Gaol", 53.341812, -6.309812),
            new Location(14, "Finland", "Helsinki", "Helsinki Olympic Stadium", 60.187188, 24.926812),
            new Location(15, "Ukraine", "Kiev", "Ukrainian Motherland Monument", 50.426562, 30.563063),
            new Location(16, "Portugal", "Lisbon", "Oceanário de Lisboa", 38.763562, -9.093687),
            new Location(17, "Slovenia", "Ljubljana", "Prešeren Square", 46.051437, 14.506063),
            new Location(18, "United Kingdom", "London", "London Eye", 51.503312, -0.119562),
            new Location(19, "Luxembourg", "Luxembourg", "Cathédrale Notre-Dame", 49.609562, 6.131562),
            new Location(20, "Spain", "Madrid", "Museo Nacional del Prado", 40.413812, -3.692188),
            new Location(21, "Belarus", "Minsk", "National Library of Republic of Belarus", 53.931438, 27.646187),
            new Location(22, "Monaco", "Monaco", "Saint Martin Gardens", 43.729937, 7.424188),
            new Location(23, "Cyprus", "Nicosia", "Selimiye Camii", 35.176563, 33.364562),
            new Location(24, "Greenland", "Nuuk", "Katuaq - Cultural Center", 64.177312, -51.738813),
            new Location(25, "Norway", "Oslo", "The Vigeland Park", 59.927062, 10.700812),
            new Location(26, "France", "Paris", "Eiffel Tower", 48.858312, 2.294437),
            new Location(27, "Montenegro", "Podgorica", "Dajbabe Monastery", 42.403937, 19.232438),
            new Location(28, "Czech Republic", "Prague", "Prague Astronomical Clock", 50.087063, 14.420687),
            new Location(29, "Iceland", "Reykjavik", "Hallgrímskirkja", 64.142062, -21.926563),
            new Location(30, "Latvia", "Riga", "House of the Black Heads", 56.947312, 24.106813),
            new Location(31, "Italy", "Rome", "Colosseum", 41.890187, 12.492188),
            new Location(32, "San Marino", "San Marino", "Public Palace of the Republic of San Marino", 43.936688,
                    12.446562),
            new Location(33, "Bosnia & Herzegovina", "Sarajevo", "Baščaršija", 43.859813, 18.431312),
            new Location(34, "North Macedonia", "Skopje", "Stone Bridge", 41.996938, 21.433062),
            new Location(35, "Bulgaria", "Sofia", "Bulevar Vitosha", 42.693062, 23.320188),
            new Location(36, "Sweden", "Stockholm", "Vasa Museum", 59.328063, 18.091437),
            new Location(37, "Estonia", "Tallinn", "Kadriorg Art Museum", 59.438562, 24.790937),
            new Location(38, "Albania", "Tirana", "Grand Park of Tirana", 41.312313, 19.825187),
            new Location(39, "Liechtenstein", "Vaduz", "Vaduz Castle", 47.139562, 9.524313),
            new Location(40, "Malta", "Valletta", "Upper Barrakka Gardens", 35.894937, 14.512187),
            new Location(41, "Holy See", "Vatican City", "Obelisk of St Peter's Square", 41.902187, 12.457313),
            new Location(42, "Austria", "Vienna", "Schönbrunn Palace", 48.185812, 16.312812),
            new Location(43, "Lithuania", "Vilnius", "Palace of the Grand Dukes of Lithuania", 54.686187, 25.289063),
            new Location(44, "Poland", "Warsaw", "Old Town Market Square", 52.249688, 21.012188),
            new Location(45, "Croatia", "Zagreb", "Park Maksimir", 45.824313, 16.017688)};
    final MultiSelectComboBox<Location> locationMultiSelectComboBox = new MultiSelectComboBox<>("Location");
    private final Map map = new Map();
    private final java.util.Map<Feature, Location> featureToLocation = new HashMap<>();
    final List<Location> locations;

    @Autowired
    public MapView(NominatimService nominatimService) {
        addClassName("map-view");
        setSizeFull();
        setPadding(false);
        setSpacing(false);
        map.getElement().setAttribute("theme", "borderless");
        map.getElement().setAttribute("class", "map");
        map.setHeightFull();

        final VerticalLayout sidebar = new VerticalLayout();
        sidebar.setSpacing(false);
        sidebar.setPadding(false);
        sidebar.setWidth("auto");
        sidebar.addClassNames("sidebar");

        locations = new ArrayList<>(Arrays.asList(DEFAULT_LOCATIONS));
        locationMultiSelectComboBox.setItems(locations);
        locationMultiSelectComboBox.getStyle().set("margin", "10px");
        locationMultiSelectComboBox.setMaxWidth("400px");
        locationMultiSelectComboBox.setAutoExpand(MultiSelectComboBox.AutoExpandMode.BOTH);
        locationMultiSelectComboBox.setItemLabelGenerator(Location::getPlace);
        locationMultiSelectComboBox.addValueChangeListener(e -> {
            if (e.getValue() == null && e.getValue().isEmpty()) {
                centerMapDefault();
            } else {
                final Location location = CollectionUtils.lastElement(e.getValue());
                assert location != null;
                centerMapOn(location);
                final MarkerFeature feature = new MarkerFeature(new Coordinate(location.getLongitude(), location.getLatitude()));
                featureToLocation.put(feature, location);
                final FeatureLayer featureLayer = this.map.getFeatureLayer();
                featureLayer.addFeature(feature);
            }
        });
        sidebar.add(locationMultiSelectComboBox);

        map.addClickEventListener(click -> {
            final Coordinate coordinate = click.getCoordinate();
            final MarkerFeature feature = new MarkerFeature(coordinate);
            final FeatureLayer featureLayer = this.map.getFeatureLayer();
            featureLayer.addFeature(feature);

            var address = nominatimService.getAddress(coordinate.getY(), coordinate.getX());
            String country = "Unknown";
            String city = "Unknown";
            Element[] addressElements = address.getAddressElements();
            if (addressElements != null) {
                for (Element element : addressElements) {
                    if (element.getKey().equals("country")) {
                        country = element.getValue();
                    } else if (element.getKey().equals("city")) {
                        city = element.getValue();
                    }
                }
            }
            final Location location = new Location(0, country, city, address.getDisplayName(), coordinate.getY(), coordinate.getX());
            featureToLocation.put(feature, location);
            locations.add(location);
            locationMultiSelectComboBox.select(location);
        });

        add(map, sidebar);
        configureMap();
    }

    private void centerMapOn(Location location) {
        final View view = map.getView();
        view.setCenter(new Coordinate(location.getLongitude(), location.getLatitude()));
        view.setZoom(14);
    }

    private void centerMapDefault() {
        final View view = new View();
        view.setCenter(new Coordinate(7, 55));
        view.setZoom(4.4f);
        map.setView(view);
    }

    private void configureMap() {

        this.centerMapDefault();

        this.map.addFeatureClickListener(e -> {
            Feature feature = e.getFeature();
            Location location = featureToLocation.get(feature);
            this.centerMapOn(location);
        });
    }
}
