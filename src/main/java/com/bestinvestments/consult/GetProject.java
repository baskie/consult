package com.bestinvestments.consult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class GetProject {
     public  static Project readProject(String projectRef) {
        Project p = null;

        try {

            FileInputStream fi = new FileInputStream(new File("c:\\temp\\"+projectRef+".prj"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            // Read objects
            p = (Project) oi.readObject();

            System.out.println("PROJECT REFERENCE: " + p.getReference());
            System.out.println("PROJECT NAME: " + p.getName());
            //System.out.println(p.toString());

            oi.close();
            fi.close();


        } catch (FileNotFoundException e) {
            System.out.println("File 'c:\\temp\\"+projectRef+".prj' not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

         return p;
    }
}
