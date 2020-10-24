package com.bestinvestments.consult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project implements Serializable {

    public enum Status{
        DRAFT,
        ACTIVE,
        CLOSED
    }


    private String name;
    private Date endDate;
    private String clientID;
    private Status status;
    private String reference;
    private ProjectManager projectManager;
    private List<String> pendingSpecialistIds = new ArrayList<>();
    private List<String> approvedSpecialistIds = new ArrayList<>();
    private List<String> discardedSpecialistIds = new ArrayList<>();

    private List<Consultation> consultations = new ArrayList<>();

    public Consultation getConsultation(Integer consultationId) {
        Consultation consultation = this.consultations.get(consultationId);
        return consultation;
    }

    public String getName()
    {
        return name;
    };

    public String getClientID(){

        return clientID;
    };

    public String getReference(){

        return reference;
    };

    public ProjectManager getProjectManager(){

        return projectManager;
    };

    public void setClientID(String clientID){

        this.clientID = clientID;
    };

    public void setReference(String reference){

        this.reference = reference;
    };
    public void setProjectManager(ProjectManager projectManager){

        this.projectManager = projectManager;
    };

    public List<String> getPendingSpecialistIds() {
        return pendingSpecialistIds;
    }
    public List<String> getApprovedSpecialistIds() {
        return approvedSpecialistIds;
    }
    public List<String> getDiscardedSpecialistIds() {
        return discardedSpecialistIds;
    }

/*
    public Project(String name, Date endDate, String clientID,Status status, String reference ){
        this.name = name;
        this.endDate = endDate;
        this.clientID = clientID;
        this.status = status;
        this.reference = reference;

    }
        public Project(String name,String clientID,Date endDate ){
        this.name = name;
        this.clientID = clientID;
        this.endDate = endDate;
    }

*/
    public Project(String name,Date endDate ){
        this.name = name;
        this.endDate = endDate;
    }


    public Status getStatus()
    {
        return status;
    }

    public void setStatus( Status status )
    {
        this.status = status;
    }

    public static Project draft(String name, Date endDate)
    {
        Project project = new Project(name,endDate);
        return project;
    }

    public void start(String projectManagerId) throws Exception
    {
        if (!this.status.equals(Status.DRAFT)){
            throw new Exception("Cannot start a Project which is not in a DRAFT status");
        }

        status = Status.ACTIVE;
        ProjectManager projectManager = new ProjectManager(projectManagerId);
        setProjectManager(projectManager);
        System.out.println(projectManager.getProjectManagerID());


// event
    }

    public void addSpecialist(String specialistId) throws Exception {
        if (!this.status.equals(Status.ACTIVE)){
            throw new Exception("Cannot add a Specialist to a Project which is not ACTIVE");
        }
        pendingSpecialistIds.add(specialistId);
    }

    public void approveSpecialist(String specialistId) throws Exception {
        if (!this.status.equals(Status.ACTIVE)){
            throw new Exception("Cannot approve a Specialist if the Project is not ACTIVE");
        }

        if (!pendingSpecialistIds.contains(specialistId)) {
            throw new Exception("Specialist is not Pending in the Project");
        }
        approvedSpecialistIds.add(specialistId);
        pendingSpecialistIds.remove(specialistId);
    }

    public void discardSpecialist(String specialistId) throws Exception {
        if (!this.status.equals(Status.ACTIVE)){
            throw new Exception("Cannot modify Specialists if the Project is not ACTIVE");
        }

        if (!approvedSpecialistIds.contains(specialistId)) {
            throw new Exception("Specialist is not Approved in the Project");
        }
        discardedSpecialistIds.add(specialistId);
        approvedSpecialistIds.remove(specialistId);
    }

    public Integer scheduleConsultation(String specialistId, Date consultationDate)throws Exception {
        if (!approvedSpecialistIds.contains(specialistId)){
            throw new Exception("Specialist is not Approved in the Project");
        }
        if (!this.status.equals(Status.ACTIVE)){
            throw new Exception("Cannot schedule a Consultation as the Project is not ACTIVE");
        }
        Integer id = consultations.size();
        Consultation consultation = Consultation.schedule(id,specialistId,consultationDate);
        consultations.add(consultation);
        return id;
    }

    public void reportConsultation(Integer consultationId, Integer duration) throws Exception {
        if (!this.status.equals(Status.ACTIVE)){
            throw new Exception("Cannot report a Consultation as the Project is not ACTIVE");
        }
        Consultation consultation = consultations.get(consultationId);
        consultation.report(duration);
    }

    public void discardConsultation(Integer consultationId) throws Exception {
        if (!this.status.equals(Status.ACTIVE)){
            throw new Exception("Cannot discard Consultation as the Project is not ACTIVE");
        }
        Consultation consultation = consultations.get(consultationId);
        consultation.discard();
    }

    public void close() throws Exception {
        if (!this.status.equals(Status.ACTIVE)){
            throw new Exception("Cannot close the Project as it is not ACTIVE");
        }

        for (Consultation consultation : consultations) {
            System.out.println("Consultation is open = " + consultation.isOpen().toString());

            if (consultation.isOpen()) {
                throw new Exception("Cannot close the Project as consultation with Specialist " + consultation.getSpecialistId() + " is still open");
            }
        }
        status = Status.CLOSED;
    }

}
