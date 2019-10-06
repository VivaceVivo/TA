package com.cgi.bootstrap.adventure;

import java.util.Set;

public class Room extends GamePlace {

    public static final String description = "Wie jeder Raum hat er vier Wände, einen Fußboden und eine Decke.";
    private String detail;

    public Room(String name, String detail){
        super(name);
        this.detail = detail;
    }

    public String getDescription(){
        return detail +"\n"+description;
    }
}
