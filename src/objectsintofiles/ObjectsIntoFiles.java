/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectsintofiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ObjectsIntoFiles {

    public static String folderDirectory;
    public static ArrayList<cat> CatList = new ArrayList<>();

    public static void main(String[] args) {
        getDir();
        System.out.println("Your current file path is: " + folderDirectory);
        while (true) {
            AddCat();
            Scanner input = new Scanner(System.in);
            System.out.println("Would you like to add another cat? y or n");
            String answer = input.next();
            if (answer.equals("n")) {
                break;
            }
        }

        writeFile();
        readFile();
        printItems();

    }

    public static void getDir() {
        folderDirectory = System.getProperty("user.dir") + "\\CatList.txt";
    }

    public static void AddCat() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a name (no spaces)");
        String name = input.next();
        System.out.println("Enter colour");
        String colour = input.next();
        System.out.println("Enter age");
        int age = input.nextInt();
        cat a = new cat(name, colour, age);
        CatList.add(a);
    }

    public static void writeFile() {

        try {
            FileWriter writeToFile = new FileWriter(folderDirectory, true);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            for (int i = 0; i < CatList.size(); i++) {
                printToFile.println(CatList.get(i).toString());
            }
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void readFile() {
        String lineFromFile;
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while ((lineFromFile = read.readLine()) != null) {
                String[] CatDetails = lineFromFile.split(",");
                String name = CatDetails[0];
                String colour = CatDetails[1];
                int age = Integer.parseInt(CatDetails[2]);
                cat a = new cat(name, colour, age);
                CatList.add(a);
            }
            read.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void printItems() {
        for (int i = 0; i < CatList.size(); i++) {
            System.out.println(CatList.get(i).toString());
        }
    }
}
