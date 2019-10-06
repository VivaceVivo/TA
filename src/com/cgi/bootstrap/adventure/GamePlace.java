package com.cgi.bootstrap.adventure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class GamePlace implements Place{

    private String name;
    private Map<Direction, GamePlace> exits;
    private boolean seen;

    GamePlace(String name){
        seen = false;
        this.exits = new HashMap<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getDescription();

    public String getCompleteDescription() {
        StringBuffer buf = new StringBuffer();
        if(!isSeen()) {
            buf.append("Du befindest Dich in eine(r/m) ");
            buf.append(getClass().getSimpleName());
            buf.append('\n');
            buf.append(getDescription());
        }else{
            buf.append("Du warst hier schon mal.");
        }
        buf.append("\nDu kannst gehen nach:");
        if(exits.size() == 0){
            buf.append("\nKein Ausweg.");
        }else {
            getExitDirections().forEach(direction -> {
                buf.append("\n- ");
                buf.append(direction);
            });
        }
        return buf.toString();
    }

    private boolean isSeen() {
        return seen;
    }

    public void markAsSeen() {
        seen = true;
    }

    public Place getExitInDirection(Direction direction){
        return exits.getOrDefault(direction, this);
    }

    public Set<Direction> getExitDirections(){
        return exits.keySet();
    }

    void addExit(Direction direction, GamePlace neighbour) {
        exits.put(direction, neighbour);
        neighbour.addBack(direction.back(), this);
    }

    protected void addBack(Direction direction, GamePlace neighbour) {
        exits.put(direction, neighbour);
    }

    public String toString(){
        return getClass().getSimpleName()+":"+name;
    }
}
