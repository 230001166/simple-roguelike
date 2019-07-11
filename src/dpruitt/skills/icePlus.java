package dpruitt.skills;

import dpruitt.Game;
import dpruitt.entities.Entity;

public class icePlus extends Skill {
    public icePlus () {
        setName ("Ice+");
        setDescription ("A magical spell. Deals 5 - 13 base damage.");
    }

    @Override
    public void use (Entity user, Entity target) {
        int baseDamage = Game.random (5, 13);
        int damage = (int) (baseDamage * ((double) user.getAttack () / target.getDefense ()));

        System.out.println (user.getName () + " used Ice+!");

        target.dealDamage (damage);
    }
}
