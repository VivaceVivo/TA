package com.cgi.bootstrap.adventure;

import java.util.Scanner;
import java.io.PrintStream;

public class TextAdventure {

    private Place currentPlace;
    private boolean alive;
    private PrintStream out;
    private StringNormalizer normalizer;


    public static void main(String [] args){
        TextAdventure adventure = new TextAdventure();
        try {
            adventure.initialize();
            int result = adventure.play();
            System.exit(result);
        }catch(RuntimeException re){
            System.out.println("We have a problem:");
            re.printStackTrace();
            System.exit(5);
        }
    }

    private TextAdventure(){
        alive = true;
        out = System.out;
        normalizer = new StringNormalizer();
    }

    private int play(){
        while(alive){
            playerMove();
        }
        return 0;
    }

    private void initialize(){
        Room start = new Room("Start", "Es ist ein durchaus gruslig aussehenden Raum.");
        Path path = new Path("Le Pfad");
        Room room = new Room("Langweiliger Raum", "Ein beeindruckend langweiliger Raum.");
        BottomlessPit pit = new BottomlessPit("Endloses Loch");

        room.addExit(Direction.SOUTH, pit);
        path.addExit(Direction.WEST, room);
        start.addExit(Direction.NORTH, path);
        currentPlace = start;
    }

    private void playerMove(){
        displayInfo();
        currentPlace.markAsSeen();
        currentPlace = processInput();
        if(currentPlace.getExitDirections().isEmpty()){
            displayInfo();
            alive = false;
            System.out.println("you die!");
        }
    }

    private Place processInput() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String command = normalizer.normalize(line);
        Direction dir = Direction.valueOf(command);
        if (dir != null){
            Place next = currentPlace.getExitInDirection(dir);
            if(next != null) {
                out.println("Gehe in Richtung "+dir+" nach "+next.getName()+".");
                return next;
            }else{
                out.println("Da ist kein Weg.");
                return currentPlace;
            }
        }else{
            out.println("Ich weiß nicht, wie ich das tun soll.");
            return currentPlace;
        }
    }

    private void displayInfo() {
        out.println(currentPlace.getCompleteDescription());
    }
}
