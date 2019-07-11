package dpruitt.skills;

import dpruitt.entities.Entity;

public class Skill {
    private String name = "default";
    private String description = "default";

    public void use (Entity user) { }

    public void use (Entity user, Entity target) { }

    public String getName () { return name; }
    public String getDescription () { return description; }
    public void setName (String newName) { name = newName; }
    public void setDescription (String newDescription) { description = newDescription; }


}
