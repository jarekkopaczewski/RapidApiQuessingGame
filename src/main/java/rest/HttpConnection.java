package rest;

import data.CountryDetails;

import java.net.UnknownHostException;

public interface HttpConnection {
    CountryDetails getCountryDetail(String name);
}
