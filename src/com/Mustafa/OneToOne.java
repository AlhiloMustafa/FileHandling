package com.Mustafa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class OneToOne implements Read, Write {


    //  Get the text from the user to write it in the file
    public String setStrFromUser(String fileName) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("what do you want to write in " + fileName + ":");
        String strData = scanner.nextLine();
        return strData;
    }

    // Override the readData method to implement Read Interface
    @Override
    public void readData(String fileName) {

        try {
            FileInputStream fis = new FileInputStream("C:/Files/" + fileName);

            byte[] arrayOfBytes = new byte[fis.available()];
            fis.read(arrayOfBytes);
            String strData = new String(arrayOfBytes);
            System.out.println("The contents of " + fileName + " is:" + "\n" + strData);
            System.out.println("Done." + "\n");
            fis.close();


        } catch (IOException e) {
            System.out.println("Please Check the path, and make sure your file name is correct ");
        } finally {
            Dialog.startDialog();
        }

    }

// Override the writeData method to implement write Interface

    @Override
    public void writeData(String filename) {
        try {
            FileOutputStream fos = new FileOutputStream("C:/Files/" + filename);
            String strData = setStrFromUser(filename);
            byte[] stringBytes = strData.getBytes();
            fos.write(stringBytes);
            System.out.println("Done." + "\n");
            fos.close();


        } catch (NullPointerException E) {
            System.out.println("Please Make Sure You Wrote Something");
            Dialog.startDialog();

        } catch (IOException EE) {
            System.out.println("Check the path please. ");

        } finally {
            Dialog.startDialog();
        }
    }

    // Public class to Copy the contents of one file to another one.
    public static void oneToOne(String from, String to) {
        try {
            FileInputStream fis = new FileInputStream("C:/Files/" + from);
            FileOutputStream fos = new FileOutputStream("C:/Files/" + to);

            byte[] arrayBytes = new byte[fis.available()];
            fis.read(arrayBytes);
            fos.write(arrayBytes);
            fis.close();
            fos.close();
            System.out.println("Successful copied from " + from + ", to " + to + ". Done." + "\n");

        } catch (FileNotFoundException e) {
            System.out.println("Sorry Could not file a file or the path !");
        } catch (IOException e) {
            System.out.println("Input out put problem");
        } finally {
            Dialog.startDialog();
        }


    }


}
