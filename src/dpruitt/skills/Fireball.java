package dpruitt.skills;

import dpruitt.entities.Entity;

public class Fireball extends Skill {
    public Fireball () {
        setName ("Fireball");
        setDescription ("A magical spell. Deals 5 base damage.");
    }

    @Override
    public void use (Entity user, Entity target) {
        final int BASE_DAMAGE = 5;
        int damage = (int) (BASE_DAMAGE * ((double) user.getAttack () / target.getDefense ()));

        System.out.println (user.getName () + " used Fireball!");

        target.dealDamage (damage);
    }
}
