package org.example;

import java.util.Scanner;

public class HttpImageStatusCli {


    public static void main(String[] args) {
        HttpImageStatusCli http = new HttpImageStatusCli();
        http.askStatus();
    }
   public void askStatus() {
       int input = 0;
       try (Scanner sc = new Scanner(System.in)){
           while (input == 0) {
               try {
                   System.out.println("Enter HTTP status code: ");
                   if (sc.hasNext())
                       input = sc.nextInt();
               } catch (Exception ignored) {
                   System.out.println("Wrong input");
                   sc.next();
               }
           }
           HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
           httpStatusImageDownloader.downloadStatusImage(input);


       } catch (Exception e) {
           System.out.println("Invalid code was entered");
       }
   }
}
