package com.bestinvestments.consult;

public class ResearchManager {
    private String name;
    private String researchManagerID;

    public String getName(){
        return name;
    };
    public String getResearchManagerID(){
        return researchManagerID;
    };

    public void setName(String name){
        this.name = name;
    };
    public void setResearchManagerID(String researchManagerID){
        this.researchManagerID = researchManagerID;
    };

    public ResearchManager(String name, String researchManagerID ){
        this.name = name;
        this.researchManagerID = researchManagerID;
    }
}
