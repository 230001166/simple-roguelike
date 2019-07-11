package dpruitt.skills;

import dpruitt.Game;
import dpruitt.entities.Entity;

public class Corrode extends Skill {
    public Corrode () {
        setName ("Corrode");
        setDescription ("Removes 1 - 3 defense from the target.");
    }

    @Override
    public void use (Entity user, Entity target) {
        int baseDamage = Game.random (1, 3);
        target.modifyDefense (baseDamage * -1);

        if (target.getDefense () < 0) { target.setDefense (0); }
    }
}
