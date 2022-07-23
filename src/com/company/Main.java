package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner bookScan = new Scanner(System.in);
    System.out.println("Select a book: ");
    String file = bookScan.nextLine();
    FileSummary bookSummary = new FileSummary(file);
    bookSummary.load_book();
    }
}
