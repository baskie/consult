package com.bestinvestments.prospecting;
import com.bestinvestments.consult.ContactDetails;

public class Prospect {

    public enum ProspectStatus{
        NEW,
        NOT_INTERESTED,
        REGISTERED
    }

    private String id;
    private String name;
    private ContactDetails contactDetails;
    private ProspectStatus status;

    public Prospect(String id, String name, ContactDetails contactDetails){

        this.id = id;
        this.name=name;
        this.contactDetails = contactDetails;
        this.status = ProspectStatus.NEW;

        //event


    }

    public void markNotInterested() throws Exception {
        if(!this.status.equals(ProspectStatus.NEW)){
            throw new Exception();
        }
        status = ProspectStatus.NOT_INTERESTED;
    }

    public void register() throws Exception {
        if(!this.status.equals(ProspectStatus.NEW)){
            throw new Exception();
        }
        status = ProspectStatus.REGISTERED;

        //Event ProspectRegisteredEvent(id)

        ProspectRegistered.sendProspect(id);


    }
}
