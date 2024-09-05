package ex04;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String sourceFile = "bai01.text";
        String targetFile = "bai04_clone.txt";
        StringBuilder output = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {
            String line ;
            while((line = br.readLine()) != null) {
                output.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        ----------------
        String input = output.toString();
        String[] words = input.split(" ");
        int first = 0;
        int last =  words.length-1;
        for (int i = 0; i < words.length/2; i++) {
                String temp = words[first];
                words[first] = words[last];
                words[last] = temp;
        }
        System.out.println(Arrays.toString(words));
//        ----------------
        StringBuilder result = new StringBuilder();
        for(String word : words) {
            result.append(word).append(" ");
        }
        try(FileOutputStream out = new FileOutputStream(targetFile)) {
            out.write(result.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
