package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class HttpStatusChecker {

    String site_url = "https://http.cat";


    public static void main(String[] args) throws IOException {
        HttpStatusChecker httpStatusChecket = new HttpStatusChecker();
        httpStatusChecket.getStatusImage(200);
    }
    public String getStatusImage(int code) throws IOException {

        URL url = new URL(site_url + "/" + code + ".jpg");

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();
        int status = urlConnection.getResponseCode();
        if (status == 404)
            throw new RuntimeException("Invalid status code");
        return url.toString();
    }
}
