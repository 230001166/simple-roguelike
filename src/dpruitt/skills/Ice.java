package dpruitt.skills;

import dpruitt.Game;
import dpruitt.entities.Entity;

public class Ice extends Skill {
    public Ice () {
        setName ("Ice");
        setDescription ("A magical spell. Deals 3 - 6 base damage.");
    }

    @Override
    public void use (Entity user, Entity target) {
        int baseDamage = Game.random (3, 6);
        int damage = (int) (baseDamage * ((double) user.getAttack () / target.getDefense ()));

        System.out.println (user.getName () + " used Ice!");

        target.dealDamage (damage);
    }
}
