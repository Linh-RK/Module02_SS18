package ex02;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReadWriteBinaryFile {
    public static void main(String[] args) {
        String sourceFile = "bai01.text";
        String targetFile = "bai01_clone.text";
        StringBuilder output = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(sourceFile))){
            String line ;
            while((line = br.readLine()) != null){
                output.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        -------------
        String input = output.toString();
        try(FileOutputStream out = new FileOutputStream(targetFile)){
            out.write(input.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
