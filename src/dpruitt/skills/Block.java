package dpruitt.skills;

import dpruitt.entities.Entity;

public class Block extends Skill {
    public Block () {
        setName ("Block");
        setDescription ("Take less damage from attacks for one turn.");
    }

    @Override
    public void use (Entity user, Entity target) {
        System.out.println (user.getName () + " uses Block!");
        user.modifyBlock (6);
    }
}
