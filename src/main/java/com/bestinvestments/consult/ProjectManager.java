package com.bestinvestments.consult;

import java.io.Serializable;

public class ProjectManager implements Serializable {
    private String name;
    private String projectManagerID;

    public String getName(){
        return name;
    };

    public String getProjectManagerID(){
        return projectManagerID;
    };

    public void setName(String name){
        this.name = name;
    };
    public void setProjectManagerID(String projectManagerID){
        this.projectManagerID = projectManagerID;
    };

    public ProjectManager(String projectManagerID ){
        this.projectManagerID = projectManagerID;
    }
    public ProjectManager(String name, String projectManagerID ){
        this.name = name;
        this.projectManagerID = projectManagerID;
    }
}
