package com.Mustafa;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dialog {
    public static Scanner scanner = new Scanner(System.in);

    public static void startDialog() {

        System.out.println("What do you want to do?" + "\n" +
                "1-Create new .txt file and write in it." + "\n" +
                "2-Read the contents of a file." + "\n" +
                "3-Copy the contents of one file to another." + "\n" +
                "4-Copy the contents of two files to One file" + "\n" +
                "your choice:");

        try {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Please write the file name to write in it:");
                    String fileName1 = scanner.nextLine();
                    OneToOne cal1 = new OneToOne();
                    cal1.writeData(fileName1);
                case 2:
                    scanner.nextLine();
                    System.out.println("Please write the file name to read :");
                    String fileName2 = scanner.nextLine();
                    OneToOne cal2 = new OneToOne();
                    cal2.readData(fileName2);
                case 3:
                    System.out.println("Copy from (file name):");
                    scanner.nextLine();
                    String from = scanner.nextLine();
                    System.out.println("Copy to (file name):");
                    String to = scanner.nextLine();
                    OneToOne.oneToOne(from, to);
                case 4:
                    System.out.println("First file to copy from (file name):");
                    scanner.nextLine();
                    String from1 = scanner.nextLine();
                    System.out.println("Second file to copy from (file name):");
                    String from2 = scanner.nextLine();
                    System.out.println("Destination,third file to copy to (file name):");
                    String DestinationFile = scanner.nextLine();

                    System.out.println(from1 + from2 + DestinationFile);

                    TwoToOne TTO = new TwoToOne();
                    TTO.copyTwoToOne(from1, from2, DestinationFile);

            }
        } catch (InputMismatchException e) {
            System.out.println("Please try again. Your choices must be only (1,2,3,or 4) " + e);
        }


    }

}
