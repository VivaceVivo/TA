package com.cgi.bootstrap.adventure;

import java.util.Set;

public abstract class GamePlace implements NavigationPlace{

    private String name;
    private GameNavigation navigation;


    GamePlace(String name){

        this.navigation = new GameNavigation();

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getDescription();

    public String getCompleteDescription() {
        StringBuffer buf = new StringBuffer();
        if(!navigation.isSeen()) {
            buf.append("Du befindest Dich in eine(r/m) ");
            buf.append(getClass().getSimpleName());
            buf.append('\n');
            buf.append(getDescription());
        }else{
            buf.append("Du warst hier schon mal.");
        }
        buf.append("\nDu kannst gehen nach:");
        if(navigation.getExitDirections().size() == 0){
            buf.append("\nKein Ausweg.");
        }else {
            getExitDirections().forEach(direction -> {
                buf.append("\n- ");
                buf.append(direction);
            });
        }
        return buf.toString();
    }


    public String toString(){
        return getClass().getSimpleName()+":"+name;
    }

    public GameNavigation getNavigation() {
        return navigation;
    }

    public void addExit(Direction direction, GamePlace neighbour){
        getNavigation().addExit(this, direction, neighbour);
        addBack(direction, neighbour);
    }

    protected void addBack(Direction direction, GamePlace neighbour) {
        neighbour.getNavigation().addExit(neighbour, direction.back(), this);
    }

    // delegate methods:

    @Override
    public NavigationPlace goInDirection(final Direction direction) {
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
}
