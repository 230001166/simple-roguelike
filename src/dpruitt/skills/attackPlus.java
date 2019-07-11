package dpruitt.skills;

import dpruitt.entities.Entity;

public class attackPlus extends Skill {
    public attackPlus () {
        setName ("Attack+");
        setDescription ("A basic attack. Deals 5 base damage.");
    }

    @Override
    public void use (Entity user, Entity target) {
        final int BASE_DAMAGE = 5;
        int damage = (int) (BASE_DAMAGE * ((double) user.getAttack () / target.getDefense ()));

        System.out.println (user.getName () + " used Attack+!");

        target.dealDamage (damage);
    }
}
