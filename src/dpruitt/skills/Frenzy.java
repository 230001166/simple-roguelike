package dpruitt.skills;

import dpruitt.entities.Entity;

public class Frenzy extends Skill {
    public Frenzy () {
        setName ("Frenzy");
        setDescription ("A physical attack. Deals 6 base damage, but the user will always take 4 damage.");
    }

    @Override
    public void use (Entity user, Entity target) {
        final int BASE_DAMAGE = 6;
        int damage = (int) (BASE_DAMAGE * ((double) user.getAttack () / target.getDefense ()));

        System.out.println (user.getName () + " used Frenzy!");

        target.dealDamage (damage);
        user.dealDamage (4);
    }
}
