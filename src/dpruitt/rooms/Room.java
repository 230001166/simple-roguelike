package dpruitt.rooms;

import dpruitt.Game;

public class Room {
    public Room () { }

    private String name = "   ????   ";

    public void setName (String newName) { name = newName; }
    public String getName () { return name; }

    protected boolean eventHasBeenTriggered = false;

    public boolean eventTriggered () { return eventHasBeenTriggered; }

    public void event (Game game) {

    }
}
