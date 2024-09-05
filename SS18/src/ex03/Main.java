package ex03;

import java.util.ArrayList;
import java.util.List;

import static ex01.Main.readFile;

public class Main {
    public static void main(String[] args) {
        String content = readFile("bai01.text");
        String[] words = content.split(" ");
        for (String word : words) {
            System.out.print(word +"    " +word.length());
            System.out.println();
        }
        List<String> arr = new ArrayList<>();
        int maxLength = 0;
    for (String word : words) {
        if (word.length() > maxLength) {
            maxLength = word.length();
            arr.clear();
            arr.add(word);
        } else if (word.length() == maxLength) {
            arr.add(word);
        }
    }
        System.out.println("Longest word ( with "+ maxLength+" characters): ");
    for (String word : arr) {
        System.out.println(word);
    }
    }
}
