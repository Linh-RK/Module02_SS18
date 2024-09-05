package ex06;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //        GHI FILE
        String fileName = "bai06.txt";
        String input = "Sử dụng một HashMap hoặc Map để lưu trữ từng từ và tần suất xuất hiện của chúng trong tệp văn bản. " +
                "Với mỗi từ đọc được, tăng tần suất của từ đó trong Map.";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        DOC FILE
        StringBuilder output = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                output.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] arr = output.toString().split(" ");
//        Hash map
        Map<String,Integer> map = new HashMap<>();
        for(String s : arr) {
            if(map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            }else {
                map.put(s, 1);
            }
        }
        int maxRepeat = 0;
        String maxRepeatWord = "";
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            if(entry.getValue() > maxRepeat) {
                maxRepeat = entry.getValue();
                maxRepeatWord = entry.getKey();
            }
        }
        System.out.println("Word repeated max is \"" + maxRepeatWord + "\" with " + maxRepeat + " times");
    }
}