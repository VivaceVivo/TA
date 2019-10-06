package com.cgi.bootstrap.adventure;

import java.util.Set;

public abstract class GamePlace implements NavigationPlace{

    private String name;
    private GameNavigation navigation;

    GamePlace(String name){
        this.name = name;
        this.navigation = new GameNavigation();
    }

    public abstract String getDescription();

    @Override
    public String getName() {
        return name;
    }

    @Override
    public GameNavigation getNavigation() {
        return navigation;
    }

    @Override
    public String getCompleteDescription() {
        return CompleteDescriptionBuilder.getCompleteDescription(navigation, this);
    }



    // delegate methods:
    @Override
    public Place goInDirection(final Direction direction) {
        return navigation.goInDirection(direction);
    }

    @Override
    public Set<Direction> getExitDirections() {
        return navigation.getExitDirections();
    }

    @Override
    public boolean isSeen() {
        return navigation.isSeen();
    }

    public void linkPlace(Direction direction, Place neighbour){
        getNavigation().addExit(direction, neighbour);
        neighbour.addBack(direction, this);
    }

    public String toString(){
        return getClass().getSimpleName()+":"+name;
    }
}
