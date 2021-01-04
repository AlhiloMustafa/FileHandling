package com.Mustafa;

import java.io.*;

public class TwoToOne extends OneToOne {

    // Add this method to copy the contents of two files to one file
    public void copyTwoToOne(String from1, String from2 , String to){

        try {
            System.out.println("first");
            FileInputStream fis= new FileInputStream("C:/Files/"+from1);

            System.out.println("second");
            FileInputStream fis2=new FileInputStream("C:/Files/"+from2);


            FileOutputStream fos=new FileOutputStream("C:/Files/"+to);

            SequenceInputStream sis =new SequenceInputStream(fis,fis2);

            int oneByte;
            while ((oneByte=sis.read())!=-1){
                fos.write(oneByte);
            }

            fis.close();
            fis2.close();
            fos.close();
            sis.close();
            System.out.println("Successfully copied the contents from "+from1+ " and "+from2+", to "+to+".");


        }catch (IOException e){
            System.out.println("Try again, Please make sure you have a correct path or file name"+"\n"+e);

        }catch (NullPointerException ee){
            System.out.println("Try again, Please Make Sure You Wrote Something in the file "+ee);
        }finally {
            Dialog.startDialog();
        }


    }






}
