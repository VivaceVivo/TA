package com.cgi.bootstrap.adventure;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GameNavigation implements Navigation{
    private Map<Direction, Place> exits;
    private boolean seen;

    public GameNavigation(){
        this.exits = new HashMap<>();
         seen = false;
    }

    @Override
    public boolean isSeen() {
        return seen;
    }

    @Override
    public Place goInDirection(Direction direction){
        return exits.get(direction);
    }

    @Override
    public Set<Direction> getExitDirections(){
        return exits.keySet();
    }

    // additional "hidden" methods
    public void addExit(Direction direction, Place neighbour) {
        exits.put(direction, neighbour);
    }

    public void markAsSeen() {
        seen = true;
    }

}
