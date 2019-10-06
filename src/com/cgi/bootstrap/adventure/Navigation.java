package com.cgi.bootstrap.adventure;

import java.util.Set;

public interface Navigation {
    NavigationPlace goInDirection(Direction direction);
    Set<Direction> getExitDirections();
    boolean isSeen();


}
