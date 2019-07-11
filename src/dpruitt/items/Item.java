package dpruitt.items;

import dpruitt.entities.Entity;

public class Item {
    private String name;

    public String getName () { return name; }
    public void setName (String newName) { name = newName; }

    public void use (Entity target) { }
}
