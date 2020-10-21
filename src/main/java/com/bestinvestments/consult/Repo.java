package com.bestinvestments.consult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Repo {
     public static void writeReadProject(Project prj) {
        try {


            File projectRepo = new File("c:\\temp\\"+prj.getReference()+".prj");
            projectRepo.createNewFile(); // if file already exists will do nothing
            FileOutputStream f = new FileOutputStream(projectRepo,true);
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            System.out.println("WRITING PROJECT TO FILE");
            o.writeObject(prj);
            o.close();
            f.close();

            FileInputStream fi = new FileInputStream(new File("c:\\temp\\"+prj.getReference()+".prj"));

            System.out.println("DEBUG 2");
            ObjectInputStream oi = new ObjectInputStream(fi);

            System.out.println("READING PROJECT FROM INPUTSTREAM");
            // Read objects
            Project p = (Project) oi.readObject();

            System.out.println("PROJECT REFERENCE: " + p.getReference());
            System.out.println("PROJECT NAME: " + p.getName());
            //System.out.println(p.toString());

            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
