package ex08;

import java.io.Serializable;
import java.util.Scanner;

import static ex08.Main.list;

public class Product implements Serializable {
    private int idProduct;
    private String name;
    private String producer;
    private double price;
    private String description;

    public Product() {
    }

    public Product( int idProduct, String name, double price, String producer,String description) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
    public void input(Scanner sc) {
        this.idProduct = autoId(sc);
        this.name = inputName(sc);
        this.price = inputPrice(sc);
        System.out.println("Enter producer name: ");
        this.producer = inputString(sc);
        System.out.println("Enter product description: ");
        this.description = inputString(sc);
    }

    public void display(){
        System.out.println("-----------------------------------------------------------");
        System.out.printf("| %-3d | %-10s | %-10f | %-10s | %-10s |\n", idProduct, name, price, producer, description);
    }
    private int autoId(Scanner sc) {
       return list.stream().map(Product::getIdProduct).max(Integer::compareTo).orElse(0)+1;
    }

    private String inputName(Scanner sc) {
        System.out.println("Enter product name: ");
        do {
            String name = sc.nextLine();
            if(name.isBlank()){
                System.out.println("Data cannot be empty. Please try again.");
            }else {
                if(list.stream().map(Product::getName).anyMatch(n->n.equals(name))){
                    System.out.println("Product already exists. Please try again.");
                }else {
                    return name;
                }
            }
        }while (true);
    }

    private double inputPrice(Scanner sc) {
        System.out.println("Enter product price: ");
        do{
            String p = sc.nextLine();
            if(p.isBlank()){
                System.out.println("Price cannot be empty. Please try again.");
            }else {
                try{
                    double price = Double.parseDouble(p);
                    if(price <= 0){
                        System.out.println("Price cannot be negative. Please try again.");
                    }else{
                        return price;
                    }
                }catch (NumberFormatException e){
                    System.out.println("Price must be positive number. Please try again.");
                }
            }
        }while(true);
    }

    private String inputString(Scanner sc) {
        do {
            String producer = sc.nextLine();
            if(producer.isBlank()){
                System.out.println("Data cannot be empty. Please try again.");
            }else {
                return producer;
            }
        }while (true);
    }


}
