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

    Project() {
    };

    private String name;
    private Date endDate;
    private String clientID;
    private Status status;
    private String reference;
    private ProjectManager projectManager;
    private List<Specialist> specialists = new ArrayList<>();

    public String getName()
    {
        return name;
    };

    public Date getEndDate(){

        return endDate;
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
    public List<Specialist> getSpecialists() {
        return specialists;
    }


    public void setName(String name){

        this.name = name;
    };

    public void setEndDate(Date endDate){

        this.endDate = endDate;
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

    public void setSpecialists(List<Specialist> specialists) {
        this.specialists = specialists;
    }


    public Project(String name, Date endDate, String clientID,Status status, String reference ){
        this.name = name;
        this.endDate = endDate;
        this.clientID = clientID;
        this.status = status;
        this.reference = reference;

    }


    public Status getStatus()
    {
        return status;
    }

    public void setStatus( Status status )
    {
        this.status = status;
    }

    public void start(String projectManagerId)
    {
        if (!this.status.equals(Status.DRAFT)){
            System.out.println("TODO EX HANDLER");
        }else
        {
            status = Status.ACTIVE;
            ProjectManager projectManager = new ProjectManager(projectManagerId);
            setProjectManager(projectManager);
            System.out.println(projectManager.getProjectManagerID());
        }

// event
    }


    public void addSpecialist(String specialistID){
        if (!this.status.equals(Status.ACTIVE)){
            System.out.println("TODO EX HANDLER");
        }else
        {
            Specialist specialist = new Specialist(specialistID);
             specialists.add(specialist);

        }
    }


    public void approveSpecialist(String specialistID){
        {
            for (Specialist s : this.getSpecialists()){

                if (specialistID.equals(s.getSpecialistID())){
                    s.setApproved(true);
                    System.out.println("APPROVING: " + s.getSpecialistID());
                }
            }

        }
    }



}
