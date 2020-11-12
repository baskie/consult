package com.bestinvestments.invoicing;

import java.util.Date;

public class PackageReference {
    private String name;
    private Date startDate;
    public Package.PackageLength length;

    public PackageReference(String name, Date startDate, Package.PackageLength length) { }

    public String packageReference(String name,Date startDate,Package.PackageLength length){
            String packageReference = String.format ("%1_%2_%3",name,startDate,length);
            return packageReference;
    }

 //   private enum PackageLength{}

}
