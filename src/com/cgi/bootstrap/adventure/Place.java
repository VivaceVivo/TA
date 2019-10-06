package com.cgi.bootstrap.adventure;

import java.util.List;
import java.util.Set;

public interface Place {
    String getName();
    String getCompleteDescription();
    GameNavigation getNavigation();

    default void addBack(Direction direction, GamePlace neighbour) {
        this.getNavigation().addExit(direction.back(), neighbour);
    }
}
