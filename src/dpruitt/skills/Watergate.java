package dpruitt.skills;

import dpruitt.entities.Entity;

public class Watergate extends Skill {
    public Watergate () {
        setName ("Watergate");
        setDescription ("Richard Nixon's ultimate attack.");
    }

    @Override
    public void use (Entity user, Entity target) {
        final int damage = 5000;

        System.out.println (user.getName () + " used Watergate!");

        target.dealDamage (damage);
    }
}
