package com.bestinvestments.invoicing;

import java.util.Calendar;
import java.util.Date;

public class PackageStatus {
    private Date startDate;
    private Integer length;


    public PackageStatus(Date startDate, Package.PackageLength length) {
    }

    public Status packageStatus(Date startDate, Integer length) {

        Calendar currentDate = Calendar.getInstance();

        Calendar packageStartDate = Calendar.getInstance();
        packageStartDate.setTime(startDate);

        Calendar packageExpiryDate = Calendar.getInstance();
        packageExpiryDate.setTime(startDate);
        packageExpiryDate.add(Calendar.MONTH, length);

        Status status = null;

        if (packageStartDate.after(currentDate)){
            status = Status.NEW;
        }else {
            if (packageExpiryDate.after(currentDate)){
                status = Status.ACTIVE;
            }else{
                status = Status.EXPIRED;
            }
        }

        return status;
   }

   public enum Status{
        NEW,
        ACTIVE,
        EXPIRED

    }

}
