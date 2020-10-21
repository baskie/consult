package com.bestinvestments.consult;

import java.io.Serializable;

public class Specialist implements Serializable {
    private String name;
    private String specialistID;
    private Boolean approved;

    public Boolean getApproved() {
        return approved;
    }

    public String getName(){
        return name;
    };
    public String getSpecialistID(){
        return specialistID;
    };

    public void setName(String name){
        this.name = name;
    };
    public void setSpecialistID(String specialistID){
        this.specialistID = specialistID;
    };

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Specialist(String specialistID ){
        this.specialistID = specialistID;
    }
    public Specialist(String name, String specialistID ){
        this.name = name;
        this.specialistID= specialistID;
    }


}
