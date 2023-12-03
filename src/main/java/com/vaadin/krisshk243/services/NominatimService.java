package com.vaadin.krisshk243.services;

import fr.dudie.nominatim.client.JsonNominatimClient;
import fr.dudie.nominatim.client.request.NominatimReverseRequest;
import fr.dudie.nominatim.model.Address;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class NominatimService {

    private final JsonNominatimClient nominatimClient;


    public NominatimService() {
        final SchemeRegistry registry = new SchemeRegistry();
        registry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        final ClientConnectionManager connexionManager = new SingleClientConnManager(null, registry);

        final HttpClient httpClient = new DefaultHttpClient(connexionManager, null);

        final String baseUrl = "https://nominatim.openstreetmap.org/";
        final String email = "noreplay@vaa.din";
        nominatimClient = new JsonNominatimClient(baseUrl, httpClient, email);
    }

    public Address getAddress(double latitude, double longitude) {
        try {
            NominatimReverseRequest reverseRequest = new NominatimReverseRequest();
            reverseRequest.setQuery(longitude, latitude);

            return nominatimClient.getAddress(reverseRequest);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
