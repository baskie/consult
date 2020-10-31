package com.bestinvestments.consult;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveProject {
     public static void writeProject(Project prj) {
        try {

            File projectRepo = new File("c:\\temp\\"+prj.getReference()+".prj");
            projectRepo.createNewFile(); // if file already exists will do nothing
            FileOutputStream f = new FileOutputStream(projectRepo,false);
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            System.out.println("WRITING PROJECT TO FILE");
            o.writeObject(prj);
            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
    //    } catch (ClassNotFoundException e) {

    //        e.printStackTrace();
        }
    }
}
