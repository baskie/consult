package com.bestinvestments.consult;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootApplication
@RestController

public class ConsultApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsultApplication.class, args);

        Date date = StringToDate("01-01-2020");
        Client client = new Client("Client Name");

        System.out.println("DRAFT PROJECT:");
        Draft draftProject = new Draft(client.getName(), date);
        System.out.println(draftProject.getName());
        System.out.println(draftProject.getEndDate());


        System.out.println("NEW RESEARCH MANAGER:");
        ResearchManager researchManager = new ResearchManager("Research Mgr Name","RMIS1234" );
        System.out.println(researchManager.getName());


        draftProject.setClientID("12 3456");
        System.out.println("ASSIGN CLIENT ID TO DRAFT:");
        System.out.println(draftProject.getClientID());

        System.out.println("CREATE NEW PROJECT FROM DRAFT:");

        Project project = new Project(draftProject.getName(),draftProject.getEndDate(),draftProject.getClientID(),Project.Status.DRAFT,"REF100000002");
      //  Project project = new Project(draftProject.getName(),draftProject.getEndDate(),draftProject.getClientID(),Project.Status.CLOSED,"REF1234");

        System.out.println(project.getName());
        System.out.println(project.getEndDate());
        System.out.println(project.getClientID());
        System.out.println(project.getStatus());
        System.out.println(project.getReference());

     //   ProjectManager projectManager = new ProjectManager("PM12345");

        System.out.println("START PROJECT:");
        project.start("PM12345");

        System.out.println("ACTIVATE PROJECT:");
        System.out.println(project.getStatus());
  //      System.out.println(project.getReference());
        System.out.println(project.getProjectManager().getProjectManagerID());

        System.out.println("ADD SPECIALIST");
        project.addSpecialist("SPID9999999");
        System.out.println("ADD MORE SPECIALISTS");
        project.addSpecialist("SPID111111111");
        project.addSpecialist("SPID222222222");
        project.addSpecialist("SPID3333333333");

        for (Specialist s : project.getSpecialists()){
            System.out.println(s.getSpecialistID());
        }
        project.approveSpecialist("SPID222222222");

        SaveProject.writeProject(project);

        Project prevProj1 = GetProject.readProject("REF100000001");
        System.out.println("GOT PROJECT: "  + prevProj1.getReference());
        Project prevProj2 = GetProject.readProject("REF100000002");
        System.out.println("GOT PROJECT: "  + prevProj2.getReference());
        Project noPrevProj = GetProject.readProject("BADREF");

    }

    @GetMapping("/printDraft")
    public String printDraft() {
        Date date = StringToDate("01-01-2020");
        Draft draft = new Draft("My Name", date, "12 3456");

        return String.format("Name: %s <br/>End Date: %s <br/>Client ID %s", draft.getName(),draft.getEndDate(),draft.getClientID());
    }

    @GetMapping("/draft")
    public String draft(
            @RequestParam(value = "name", defaultValue = "Anon") String inputName,
            @RequestParam(value = "date", defaultValue = "01-01-2000") String dateString,
            @RequestParam(value = "clientID", defaultValue = "000 0000") String inputClientID
    ) {
        Date date = StringToDate(dateString);
        Draft draft = new Draft(inputName, date, inputClientID);
        return String.format("Name: %s <br/>End Date: %s <br/>Client ID: %s", draft.getName(),draft.getEndDate(),draft.getClientID());

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
