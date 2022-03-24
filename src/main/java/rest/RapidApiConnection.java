package rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import data.CountryDetails;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.util.*;

public class RapidApiConnection implements HttpConnection {

    private static final Gson gson = new Gson();

    @Override
    public CountryDetails getCountryDetail(String name) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://wft-geo-db.p.rapidapi.com/v1/geo/countries/" + name).get()
                .addHeader("x-rapidapi-host", "wft-geo-db.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "7ec0b44dd5mshc3473b6cc15ed3bp1d65eajsn3ffe929aba30").build();
        String response = null;
        try { response = Objects.requireNonNull(client.newCall(request).execute().body()).string(); }
        catch (IOException e) { e.printStackTrace(); }
        return gson.fromJson(gson.fromJson(response, JsonObject.class).get("data"), CountryDetails.class);
    }
}
