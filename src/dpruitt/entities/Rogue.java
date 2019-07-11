package dpruitt.entities;

import dpruitt.skills.Attack;

public class Rogue extends Enemy {
    public Rogue () {
        setName ("Rogue");
        setHealth (11);
        setMaxHealth (11);
        setAttack (4);
        setDefense (4);
        setSpeed (10);
        setExperience (2);
        skills.add (new Attack ());
    }

    @Override
    public void AI (Entity player) {
        final int ATTACK = 0;
        skills.get (ATTACK).use (this, player);
    }
}
