package ex08;

import ex08.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static List<Product> list = new ArrayList<>();
  public static Product product = new Product();
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        do {
          System.out.println("--------------------------Menu--------------------------");
          System.out.println("                                                        ");
          System.out.println("      1. Add Product                                    ");
          System.out.println("      2. Display Product                                ");
          System.out.println("      3. Search Product                                 ");
          System.out.println("      4. Exit                                           ");
          System.out.println("                                                        ");
          System.out.println("--------------------------------------------------------");
          System.out.println("Enter your choice: ");
          String choice = sc.nextLine();
          switch (choice) {
            case "1": {
              addNew(sc);
              break;
            }
            case "2": {
              List<Product> listRead = readFile("ex08/bai08.txt");
              listRead.forEach(Product::display);
              break;
            }
            case "3": {
              System.out.println("Enter search keys: ");
              String search = sc.nextLine();
              List<Product> listRead = readFile("src/ex08/bai08.txt");
              listRead.stream().filter(e->e.getName().contains(search)).forEach(Product::display);
              break;
            }
            case "4": {
              System.exit(0);
              break;
            }
            default: {
              break;
            }
          }
        }while (true);

    }

  private static void addNew(Scanner sc) {
    System.out.println("Enter the number of products you want to add: ");
    int number = inputNum(sc);
    for (int i = 0; i < number; i++) {
      product.input(sc);
      writeFile("src/ex08/bai08.txt");
    }
  }

  private static int inputNum(Scanner sc) {
      do {
        String input = sc.nextLine();
        if(input.isBlank()){
          System.out.println("Data cannot be empty");
        }else{
          try{
            int number = Integer.parseInt(input);
            if(number <= 0){
              System.out.println("Data cannot be less than 0. Please try again");
            }else{
              return number;
            }
          }
          catch (NumberFormatException e){
            System.out.println("Please enter a positive integer");
          }
        }
      }while (true);
  }

  public static void writeFile(String filename) {
      try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/ex08/bai08.txt"))){
        oos.writeObject(list);
        System.out.println("Written list product to file");
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    public static List<Product> readFile(String filename) {
      List<Product> listOut = new ArrayList<>();
      try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/ex08/bai08.txt"))){
        listOut = (List<Product>) ois.readObject();
      } catch (IOException | ClassNotFoundException e) {
        throw new RuntimeException(e);
      }
      return  listOut;
    }


}
