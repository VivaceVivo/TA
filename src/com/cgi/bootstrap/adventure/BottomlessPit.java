package com.cgi.bootstrap.adventure;

public class BottomlessPit extends GamePlace{
    BottomlessPit(final String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "Du fällst in ein endloses Loch!\n" +
                "Die helle Scheibe der Öffnung wird rasant kleiner, " +
                "bis sie zu einem einzigen Punkt schrumpft, der langsam verblasst...";
    }
    protected void addBack(Direction direction, GamePlace neighbour){}
}
