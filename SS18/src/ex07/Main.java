package ex07;

import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
    Product p1 = new Product(1,"cookie",30000);
    Product p2 = new Product(2,"bakery",20000);
    Product p3 = new Product(3,"choco",50000);
    list.add(p1);
    list.add(p2);
    list.add(p3);
    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("product.txt"))){
        oos.writeObject(list);
        System.out.println("Written list product to file");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    List<Product> listOut = new ArrayList<>();
    try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("product.txt"))){
        listOut = (List<Product>) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
    if(listOut.isEmpty()){
        System.out.println("List product is empty");
    }else{
        System.out.println("-----------------------------------");
        System.out.printf("| %-3s | %-10s | %-12s |\n", "ID","Name", "Price");
        System.out.println("-----------------------------------");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        for(Product e : listOut) {
            System.out.printf("| %-3s | %-10s | %-12s |\n", e.getId(), e.getName(), currencyFormatter.format(e.getPrice()));
            System.out.println("-----------------------------------");
        }
    }
    }
}
