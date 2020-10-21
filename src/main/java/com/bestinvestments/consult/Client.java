package com.bestinvestments.consult;

public class Client {
    private String name;
    private String clientID;

    public String getName(){
        return name;
    };
    public String getClientID(){
        return clientID;
    };

    public void setName(){
        this.name = name;
    };
    public void setClientID(){
        this.clientID = clientID;
    };

    public Client(String name, String clientID ){
        this.name = name;
        this.clientID = clientID;
    }
    public Client(String name ){
        this.name = name;
    }

}
