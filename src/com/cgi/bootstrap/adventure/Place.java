package com.cgi.bootstrap.adventure;

import java.util.List;
import java.util.Set;

public interface Place {
    String getName();
    String getCompleteDescription();
    Place getExitInDirection(Direction direction);
    Set<Direction> getExitDirections();
    void markAsSeen();

}
