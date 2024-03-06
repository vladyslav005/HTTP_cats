package org.example;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HttpStatusImageDownloader {


    public static void main(String[] args) throws IOException {
        HttpStatusImageDownloader http = new HttpStatusImageDownloader();
        http.downloadStatusImage(404);
    }

     public void downloadStatusImage(int code) throws IOException {
         HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
         URL url = new URL(httpStatusChecker.getStatusImage(code));

         InputStream in =  url.openStream();

         Files.deleteIfExists(Paths.get("./cat.jpg"));
         Files.copy(in, Paths.get("./cat.jpg"));
     }
}
