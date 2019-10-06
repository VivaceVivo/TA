package com.cgi.bootstrap.adventure;

public class Path extends GamePlace {

    private String detail;

    public Path(String name){
        super(name);
    }

    public String getDescription(){
        return "Der Pfad ist nur fast grade. Also eigentlich gar nicht.";
    }

}
