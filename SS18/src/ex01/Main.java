package ex01;

import java.io.*;
import java.nio.charset.StandardCharsets;


public class Main {
    public static void main(String[] args) {
        String tenFile = "bai01.text";
        String content = Main.readFile(tenFile);
        String[] arr = content.split(" ");
        System.out.println("Co "+ arr.length +" tu trong file");
    }
    public static String readFile(String fileName) {
        String input ="When executing Java code, different errors can occur: coding errors made by the programmer, " +
                "errors due to wrong input, or other unforeseeable things.";
        try(FileOutputStream out = new FileOutputStream(fileName)) {
            out.write(input.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
//            --------------------
        StringBuilder output = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            return "File reading err: " + e.getMessage();
        }
        return output.toString();
    }
}
