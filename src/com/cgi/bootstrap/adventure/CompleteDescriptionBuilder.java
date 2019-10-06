package com.cgi.bootstrap.adventure;

public interface CompleteDescriptionBuilder {
    public static String getCompleteDescription(Navigation navigation, GamePlace place) {
        StringBuffer buf = new StringBuffer();
        if(!navigation.isSeen()) {
            buf.append("Du befindest Dich in eine(r/m) ");
            buf.append(place.getClass().getSimpleName());
            buf.append('\n');
            buf.append(place.getDescription());
        }else{
            buf.append("Du warst hier schon mal.");
        }
        buf.append("\nDu kannst gehen nach:");
        if(navigation.getExitDirections().size() == 0){
            buf.append("\nKein Ausweg.");
        }else {
            place.getExitDirections().forEach(direction -> {
                buf.append("\n- ");
                buf.append(direction);
            });
        }
        return buf.toString();
    }
}
