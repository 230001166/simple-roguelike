package dpruitt.entities;

import dpruitt.skills.Attack;

public class Goblin extends Enemy {
    public Goblin () {
        setName ("Goblin");
        setHealth (6);
        setMaxHealth (6);
        setAttack (1);
        setDefense (1);
        setSpeed (1);
        setExperience (1);
        skills.add (new Attack());
    }

    @Override
    public void AI (Entity player) {
        final int ATTACK = 0;
        skills.get (ATTACK).use (this, player);
    }
}
