package com.cgi.bootstrap.adventure;

import java.util.Set;

public interface Navigation {
    Place goInDirection(Direction direction);
    Set<Direction> getExitDirections();
    boolean isSeen();
}
