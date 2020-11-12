package com.bestinvestments.invoicing;

import com.bestinvestments.consult.Consultation;

import java.util.Date;

public class Package {
    private ClientId clientId;
    private PackageReference reference ;
    private PackageLength length ;
    private Integer nominalHours;
    private PackageStatus status;
    private Integer transferredInHours;


    private Package(ClientId clientId, Date startDate, PackageLength length, Integer nominalHours, String name)
    {
        this.clientId = clientId;
        this.reference = new PackageReference(name,startDate,length);
        this.nominalHours = nominalHours;
        this.length = length;
        this.status = new PackageStatus(startDate,length);
    }

    public static Package purchase(ClientId clientId,Date startDate,PackageLength length,Integer nominalHours, String name){
        return new Package(clientId,startDate,length,nominalHours,name);
    }

    public void attachConsultation(ClientId clientId, Integer length) throws Exception{

        Integer availableHours = nominalHours + transferredInHours;
        Integer remainingHours = availableHours + 0;//attached Consultations.length

        if (!this.status.equals(PackageStatus.Status.ACTIVE)){
            throw new Exception("The package is not active.");
        }
        if (remainingHours < length){
            throw new Exception("There are not enough hours left on this Package to attach this Consultation.");
        }

        if (!clientId.equals(Consultation.getClientId())){
            throw new Exception("The client Id does not match the client Id on the consultation");
        }

    }

    private enum ClientId{

    }

    public enum PackageLength{

    }


}
