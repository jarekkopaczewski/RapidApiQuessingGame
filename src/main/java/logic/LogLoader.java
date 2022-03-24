package logic;

import data.CountryDetails;
import rest.HttpConnection;
import rest.RapidApiConnection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class LogLoader {

    private static final HttpConnection httpConnection = new RapidApiConnection();
    private static Queue<String> countriesQueue;
    public static String currentCode;

    public LogLoader() {
    }

    public static void loadNamesFromFile(String path) {
        try {
            ArrayList<String> list = new ArrayList<>(Arrays.asList(new String(Files.readAllBytes(Paths.get(path))).split(";")));
            Collections.shuffle(list);
            countriesQueue = new LinkedList<>(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static CountryDetails getNextCountryDetails() throws NullPointerException {
        currentCode = countriesQueue.element();
        CountryDetails countryDetails = httpConnection.getCountryDetail(countriesQueue.element());
        countriesQueue.remove();
        return countryDetails;
    }

    public static int getQueueSize() {
        return countriesQueue.size();
    }
}
