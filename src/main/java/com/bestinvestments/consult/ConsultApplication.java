package com.bestinvestments.consult;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootApplication
@RestController

public class ConsultApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ConsultApplication.class, args);

// WEEK 1 FUNCTIONS
        Date date = StringToDate("01-01-2020");
        Client client = new Client("Client Name");

        System.out.println("DRAFT PROJECT:");
        Project project = Project.draft(client.getName(), date);
        System.out.println(project.getName());

        System.out.println("ASSIGN CLIENT ID TO DRAFT:");
        project.setClientID("12 3456");

        System.out.println("CREATE NEW PROJECT FROM DRAFT:");

        project.setReference("REF100000001");

        System.out.println(project.getReference());

        System.out.println("ACTIVATE PROJECT:");
        project.setStatus(Project.Status.DRAFT);

        System.out.println("START PROJECT:");
        project.start("PM12345");

        System.out.println("ACTIVATE PROJECT:");
        project.setStatus(Project.Status.ACTIVE);
        System.out.println(project.getStatus());
        System.out.println(project.getProjectManager().getProjectManagerID());

        System.out.println("ADD SPECIALIST");
        project.addSpecialist("SPID9999999");
        System.out.println("ADD MORE SPECIALISTS");
        project.addSpecialist("SPID111111111");
        project.addSpecialist("SPID222222222");
        project.addSpecialist("SPID3333333333");

  /*      for (Specialist s : project.getSpecialists()){
            System.out.println(s.getSpecialistID());
        }
  */
 // WEEK 2 FUNCTIONS
        project.approveSpecialist("SPID111111111");
        project.approveSpecialist("SPID222222222");
        project.discardSpecialist("SPID111111111");

        for (String pending : project.getPendingSpecialistIds()){
            System.out.println("Pending Specialist: "+ pending);
        }
        for (String approved : project.getApprovedSpecialistIds()){
            System.out.println("Approved Specialist: "+ approved);
        }
        for (String discarded : project.getDiscardedSpecialistIds()){
            System.out.println("DiscardedSpecialist: "+ discarded);
        }

        SaveProject.writeProject(project);

        Project prevProj1 = GetProject.readProject("REF100000001");
        System.out.println("GOT PROJECT: "  + prevProj1.getReference());
   //     Project prevProj2 = GetProject.readProject("REF100000002");
     //   System.out.println("GOT PROJECT: "  + prevProj2.getReference());
        Project noPrevProj = GetProject.readProject("BADREF");

//Add a consultation
        Date cDate = StringToDate("02-01-2020");
        Integer consultationId = project.scheduleConsultation("SPID222222222",cDate);
        Consultation consultation = project.getConsultation(consultationId);
        System.out.println("Consultation Id: "+ consultationId + " will be between Specialist ID " + consultation.getSpecialistId() + " and Client ID " + project.getClientID() + " on: " + consultation.getConsultationDate() );

//Add another consultation
        cDate = StringToDate("30-09-2021");
        consultationId = project.scheduleConsultation("SPID222222222",cDate);
        consultation = project.getConsultation(consultationId);
        System.out.println("Consultation Id: "+ consultationId + " will be between Specialist ID " + consultation.getSpecialistId() + " and Client ID " + project.getClientID()  + " on: " + consultation.getConsultationDate() );

        project.reportConsultation(consultationId,3);
        System.out.println("Consultation Id: " + consultationId + " was " + consultation.getDuration() + " Hours " );

//Discard the first consultation
///        project.close();

        project.discardConsultation(0);

        project.close();


    }



    public static Date StringToDate(String s){

        Date result = null;
        try{
    //        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            result  = dateFormat.parse(s);
        }

        catch(ParseException e){
            e.printStackTrace();

        }
        return result ;
    }
}
