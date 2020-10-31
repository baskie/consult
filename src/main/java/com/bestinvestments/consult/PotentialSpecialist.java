package com.bestinvestments.consult;

import java.util.concurrent.atomic.AtomicInteger;

public class PotentialSpecialist {
    private static AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String name;
    private ContactDetails contactDetails;

    private PotentialSpecialist(String name,ContactDetails contactDetails){
        this.id=count.incrementAndGet();
        this.name=name;
        this.contactDetails = contactDetails;



// Event -  PotentialSpecialistPutOnListEvent(id, name, contact)


    };

    public static PotentialSpecialist putOnList(String name,ContactDetails contactDetails){
        PotentialSpecialist pSpec = new PotentialSpecialist(name, contactDetails);
        return pSpec;
    }

    public String register(){
        String specialistID = String.format ("S"+"%05d", this.id);
        Specialist specialist = new Specialist(specialistID);
        return specialist.getSpecialistID();
    }

}
