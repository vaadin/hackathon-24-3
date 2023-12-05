package com.example.application.views;

import com.example.application.data.User;
import com.example.application.security.AuthenticatedUser;
import com.example.application.views.addressformjava.AddressFormJavaView;
import com.example.application.views.chatjava.ChatJavaView;
import com.example.application.views.checkoutformjava.CheckoutFormJavaView;
import com.example.application.views.collaborativemasterdetailjava.CollaborativeMasterDetailJavaView;
import com.example.application.views.collaborativemasterdetailsampleaddressjava.CollaborativeMasterDetailSampleAddressJavaView;
import com.example.application.views.collaborativemasterdetailsamplebookjava.CollaborativeMasterDetailSampleBookJavaView;
import com.example.application.views.creditcardformjava.CreditCardFormJavaView;
import com.example.application.views.dashboardjava.DashboardJavaView;
import com.example.application.views.datagridjava.DataGridJavaView;
import com.example.application.views.emptyjava.EmptyJavaView;
import com.example.application.views.feedjava.FeedJavaView;
import com.example.application.views.gridwithfiltersjava.GridwithFiltersJavaView;
import com.example.application.views.helloworldjava.HelloWorldJavaView;
import com.example.application.views.imagegalleryjava.ImageGalleryJavaView;
import com.example.application.views.mapjava.MapJavaView;
import com.example.application.views.masterdetailjava.MasterDetailJavaView;
import com.example.application.views.masterdetailsampleaddressjava.MasterDetailSampleAddressJavaView;
import com.example.application.views.masterdetailsamplebookjava.MasterDetailSampleBookJavaView;
import com.example.application.views.myviewjava.MyViewJavaView;
import com.example.application.views.pageeditorjava.PageEditorJavaView;
import com.example.application.views.personformjava.PersonFormJavaView;
import com.example.application.views.spreadsheetjava.SpreadsheetJavaView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.auth.AccessAnnotationChecker;
import com.vaadin.flow.theme.lumo.LumoUtility;
import java.io.ByteArrayInputStream;
import java.util.Optional;
import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H2 viewTitle;

    private AuthenticatedUser authenticatedUser;
    private AccessAnnotationChecker accessChecker;

    public MainLayout(AuthenticatedUser authenticatedUser, AccessAnnotationChecker accessChecker) {
        this.authenticatedUser = authenticatedUser;
        this.accessChecker = accessChecker;

        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        H1 appName = new H1("latest-java_partial-auth");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    private SideNav createNavigation() {
        SideNav nav = new SideNav();

        if (accessChecker.hasAccess(MyViewJavaView.class)) {
            nav.addItem(new SideNavItem("My View (Java)", MyViewJavaView.class,
                    LineAwesomeIcon.PENCIL_RULER_SOLID.create()));

        }
        if (accessChecker.hasAccess(EmptyJavaView.class)) {
            nav.addItem(new SideNavItem("Empty (Java)", EmptyJavaView.class, LineAwesomeIcon.FILE.create()));

        }
        if (accessChecker.hasAccess(HelloWorldJavaView.class)) {
            nav.addItem(new SideNavItem("Hello World (Java)", HelloWorldJavaView.class,
                    LineAwesomeIcon.GLOBE_SOLID.create()));

        }
        if (accessChecker.hasAccess(DashboardJavaView.class)) {
            nav.addItem(new SideNavItem("Dashboard (Java)", DashboardJavaView.class,
                    LineAwesomeIcon.CHART_AREA_SOLID.create()));

        }
        if (accessChecker.hasAccess(FeedJavaView.class)) {
            nav.addItem(new SideNavItem("Feed (Java)", FeedJavaView.class, LineAwesomeIcon.LIST_SOLID.create()));

        }
        if (accessChecker.hasAccess(DataGridJavaView.class)) {
            nav.addItem(new SideNavItem("Data Grid (Java)", DataGridJavaView.class, LineAwesomeIcon.TH_SOLID.create()));

        }
        if (accessChecker.hasAccess(MasterDetailJavaView.class)) {
            nav.addItem(new SideNavItem("Master-Detail (Java)", MasterDetailJavaView.class,
                    LineAwesomeIcon.COLUMNS_SOLID.create()));

        }
        if (accessChecker.hasAccess(MasterDetailSampleAddressJavaView.class)) {
            nav.addItem(new SideNavItem("Master-Detail SampleAddress (Java)", MasterDetailSampleAddressJavaView.class,
                    LineAwesomeIcon.COLUMNS_SOLID.create()));

        }
        if (accessChecker.hasAccess(MasterDetailSampleBookJavaView.class)) {
            nav.addItem(new SideNavItem("Master-Detail SampleBook (Java)", MasterDetailSampleBookJavaView.class,
                    LineAwesomeIcon.COLUMNS_SOLID.create()));

        }
        if (accessChecker.hasAccess(CollaborativeMasterDetailJavaView.class)) {
            nav.addItem(new SideNavItem("Collaborative Master-Detail (Java)", CollaborativeMasterDetailJavaView.class,
                    LineAwesomeIcon.COLUMNS_SOLID.create()));

        }
        if (accessChecker.hasAccess(CollaborativeMasterDetailSampleAddressJavaView.class)) {
            nav.addItem(new SideNavItem("Collaborative Master-Detail SampleAddress (Java)",
                    CollaborativeMasterDetailSampleAddressJavaView.class, LineAwesomeIcon.COLUMNS_SOLID.create()));

        }
        if (accessChecker.hasAccess(CollaborativeMasterDetailSampleBookJavaView.class)) {
            nav.addItem(new SideNavItem("Collaborative Master-Detail SampleBook (Java)",
                    CollaborativeMasterDetailSampleBookJavaView.class, LineAwesomeIcon.COLUMNS_SOLID.create()));

        }
        if (accessChecker.hasAccess(PersonFormJavaView.class)) {
            nav.addItem(new SideNavItem("Person Form (Java)", PersonFormJavaView.class, LineAwesomeIcon.USER.create()));

        }
        if (accessChecker.hasAccess(AddressFormJavaView.class)) {
            nav.addItem(new SideNavItem("Address Form (Java)", AddressFormJavaView.class,
                    LineAwesomeIcon.MAP_MARKER_SOLID.create()));

        }
        if (accessChecker.hasAccess(CreditCardFormJavaView.class)) {
            nav.addItem(new SideNavItem("Credit Card Form (Java)", CreditCardFormJavaView.class,
                    LineAwesomeIcon.CREDIT_CARD.create()));

        }
        if (accessChecker.hasAccess(MapJavaView.class)) {
            nav.addItem(new SideNavItem("Map (Java)", MapJavaView.class, LineAwesomeIcon.MAP.create()));

        }
        if (accessChecker.hasAccess(SpreadsheetJavaView.class)) {
            nav.addItem(new SideNavItem("Spreadsheet (Java)", SpreadsheetJavaView.class,
                    LineAwesomeIcon.FILE_EXCEL.create()));

        }
        if (accessChecker.hasAccess(ChatJavaView.class)) {
            nav.addItem(new SideNavItem("Chat (Java)", ChatJavaView.class, LineAwesomeIcon.COMMENTS.create()));

        }
        if (accessChecker.hasAccess(PageEditorJavaView.class)) {
            nav.addItem(new SideNavItem("Page Editor (Java)", PageEditorJavaView.class, LineAwesomeIcon.EDIT.create()));

        }
        if (accessChecker.hasAccess(ImageGalleryJavaView.class)) {
            nav.addItem(new SideNavItem("Image Gallery (Java)", ImageGalleryJavaView.class,
                    LineAwesomeIcon.TH_LIST_SOLID.create()));

        }
        if (accessChecker.hasAccess(CheckoutFormJavaView.class)) {
            nav.addItem(new SideNavItem("Checkout Form (Java)", CheckoutFormJavaView.class,
                    LineAwesomeIcon.CREDIT_CARD.create()));

        }
        if (accessChecker.hasAccess(GridwithFiltersJavaView.class)) {
            nav.addItem(new SideNavItem("Grid with Filters (Java)", GridwithFiltersJavaView.class,
                    LineAwesomeIcon.FILTER_SOLID.create()));

        }

        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();

        Optional<User> maybeUser = authenticatedUser.get();
        if (maybeUser.isPresent()) {
            User user = maybeUser.get();

            Avatar avatar = new Avatar(user.getName());
            StreamResource resource = new StreamResource("profile-pic",
                    () -> new ByteArrayInputStream(user.getProfilePicture()));
            avatar.setImageResource(resource);
            avatar.setThemeName("xsmall");
            avatar.getElement().setAttribute("tabindex", "-1");

            MenuBar userMenu = new MenuBar();
            userMenu.setThemeName("tertiary-inline contrast");

            MenuItem userName = userMenu.addItem("");
            Div div = new Div();
            div.add(avatar);
            div.add(user.getName());
            div.add(new Icon("lumo", "dropdown"));
            div.getElement().getStyle().set("display", "flex");
            div.getElement().getStyle().set("align-items", "center");
            div.getElement().getStyle().set("gap", "var(--lumo-space-s)");
            userName.add(div);
            userName.getSubMenu().addItem("Sign out", e -> {
                authenticatedUser.logout();
            });

            layout.add(userMenu);
        } else {
            Anchor loginLink = new Anchor("login", "Sign in");
            layout.add(loginLink);
        }

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
