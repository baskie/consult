package com.bestinvestments.consult;

import java.util.Date;

public class Consultation {

    private Integer id;
    private String  specialistId;

    //Added here to enable clientId matching when attaching Consultations to Packages
    private String clientId;
    public static String getClientId(){
        return clientId;
    }

    private Date consultationDate;
    private Consultation.Status status = Status.OPEN;

    private Integer duration;
    //TODO duration needs to be in HH:MM

    public Integer getDuration() {
        return duration;
    }


    private void setId(Integer id) {
        this.id = id;
    }
    private void setSpecialistId(String specialistId) {
        this.specialistId = specialistId;
    }

    private void setConsultationDate(Date consultationDate) {
        this.consultationDate = consultationDate;
    }


    private Consultation(Integer id,String specialistId, Date consultationDate ) {
        id = id;
        specialistId = specialistId;
        consultationDate = consultationDate;

    }

/*
    private Consultation(String specialistId, Date consultationDate ) {
        specialistId = specialistId;
        consultationDate = consultationDate;

    }

    private Consultation(Integer id, String specialistId, Date consultationDate ,Status status ) {
        id = id;
        specialistId = specialistId;
        consultationDate = consultationDate;
        status = Status.OPEN;

    }
*/

    public enum Status{
        OPEN,
        CONFIRMED,
        ACTIVE,
        DISCARDED
    }

    public String getSpecialistId() {
        return specialistId;
    }

    public Date getConsultationDate() {
        return consultationDate;
    }

    public static Consultation schedule(Integer id,String specialistId,Date consultationDate)
       {
           Consultation consultation = new Consultation(id, specialistId, consultationDate);
           consultation.setId(id);
           consultation.setConsultationDate(consultationDate);
           consultation.setSpecialistId(specialistId);

           return consultation;
       }

public void report(Integer duration) throws Exception
       {
            if (!status.equals(Status.OPEN)) {
                throw new Exception("Cannot Report a Consultation when it is not Open");
           }
           this.duration = duration;
           this.status = Status.CONFIRMED;
       }

public void discard() throws Exception

        {
            if (!status.equals(Status.OPEN)) {

                throw new Exception("Cannot Discard a Consultation when it is not Open");
            }
            this.status = Status.DISCARDED;
        }

public Boolean isOpen() {
    return status.equals(Status.OPEN);
}
}
