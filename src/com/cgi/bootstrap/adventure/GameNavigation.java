package com.cgi.bootstrap.adventure;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GameNavigation implements Navigation{
    private Map<Direction, GamePlace> exits;
    private boolean seen;

    public GameNavigation(){
        this.exits = new HashMap<>();
         seen = false;
    }

    public boolean isSeen() {
        return seen;
    }

    public void markAsSeen() {
        seen = true;
    }

    public NavigationPlace goInDirection(Direction direction){
        return exits.get(direction);
    }

    public Set<Direction> getExitDirections(){
        return exits.keySet();
    }

    public void addExit(GamePlace here, Direction direction, GamePlace neighbour) {
        exits.put(direction, neighbour);
    }



}
