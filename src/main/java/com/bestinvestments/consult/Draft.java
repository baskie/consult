package com.bestinvestments.consult;
import java.util.Date;

public class Draft{
    private String name;
    private Date endDate;
    private String clientID;

    public String getName(){
        return name;
    };
    public Date getEndDate(){
        return endDate;
    };
    public String getClientID(){
        return clientID;
    };

    public void setName(String name){
        this.name = name;
    };
    public void setEndDate(Date endDate){
        this.endDate = endDate;
    };
    public void setClientID(String clientID){
        this.clientID = clientID;
    };

    public Draft (String name, Date endDate ){
        this.name = name;
        this.endDate = endDate;
    }

    public Draft (String name, Date endDate, String clientID ){
        this.name = name;
        this.endDate = endDate;
        this.clientID = clientID;
    }
}
