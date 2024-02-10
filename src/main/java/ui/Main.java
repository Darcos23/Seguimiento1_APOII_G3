package ui;

import java.io.File;
import java.util.Scanner;
import model.InfrastructureDepartment;

public class Main {
    static Scanner reader;
    static InfrastructureDepartment id;

    public static void main(String[] args) throws Exception {

        id = new InfrastructureDepartment();

        reader = new Scanner(System.in);

        menu();
    }

    public static void menu() {

        boolean flag = false;

        while (!flag) {
            System.out.println("MENU: \n");
            System.out.println("Select what you want to do:\n");
            System.out.println("[1] SHOW ALL BILLBOARDS...............");
            System.out.println("[2] SHOW AVERAGE WIDTH................");
            System.out.println("[3] SHOW AVERAGE HEIGHT...............");
            System.out.println("[4] SHOW AVERAGE AREA.................");
            System.out.println("[5] SHOW ALL BILLBOARDS IN USE........");
            System.out.println("[6] SHOW ALL BILLBOARDS BY BRAND......");
            System.out.println("[7] EXIT THE PROGRAM..................");

            int option = reader.nextInt();

            switch (option) {
                case 1:
                    System.out.println(id.toString());
                    break;
                case 2:
                    System.out.println("\n Average Width: " + id.averageWidth() + "\n");
                    break;
                case 3:
                    System.out.println("\n Average Height: " + id.averageHeight() + "\n");
                    break;
                case 4:
                    System.out.println("\n Average Area: " + id.averageArea() + "\n");
                    break;
                case 5:
                    System.out.println("\n Active Billboards: " + id.showActiveBillboards() + "\n");
                    break;
                case 6:
                    System.out.println("\n Billboards by brand: " + id.showBillboardsByBrand()  + "\n");
                    break;
                case 7:
                    System.out.println("\n Exiting the program...");
                    reader.close();
                    flag = true;
                    break;
                default:
                    System.out.println("\n Invalid option. Please, try again!");
                    break;
            }
        }

    }
}