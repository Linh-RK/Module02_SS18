package ex05;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        GHI FILE
        String fileName = "countries.csv";
        String input =
        "1,\"AU\",\"Australia\"\n" +
        "2,\"CN\",\"China\"\n"+
        "3,\"AU\",\"Australia\"\n"+
        "4,\"CN\",\"China\"\n"+
        "5,\"JP\",\"Japan\"\n"+
        "6,\"CN\",\"China\"\n"+
        "7,\"JP\",\"Japan\"\n"+
        "8,\"TH\",\"Thailand\"\n";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        DOC FILE
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            List<String[]> countries = new ArrayList<>();
            while((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                countries.add(data);
            }
            System.out.println(countries.size());
            System.out.println("----------------------------");
            System.out.printf("| %-3s | %-4s | %-12s |\n", "STT","Code", "Country");
            System.out.println("----------------------------");
            for(String[] country : countries) {
                System.out.printf("| %-3s | %-4s | %-12s |\n", country[0], country[1], country[2]);
                System.out.println("----------------------------");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
