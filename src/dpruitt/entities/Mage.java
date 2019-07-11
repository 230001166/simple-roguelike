package dpruitt.entities;

import dpruitt.skills.Attack;
import dpruitt.skills.Fireball;

public class Mage extends Enemy {
    public Mage () {
        setName ("Mage");
        setHealth (26);
        setMaxHealth (26);
        setAttack (10);
        setDefense (5);
        setSpeed (6);
        setExperience (3);
        skills.add (new Attack ());
        skills.add (new Fireball ());
    }

    @Override
    public void AI (Entity player) {
        final int ATTACK = 0, FIREBALL = 1;

        if (getAiLastAction ().equals ("none") || getAiLastAction().equals ("fireball")) {
            skills.get (ATTACK).use (this, player);
            setAiLastAction ("attack");
        } else if (getAiLastAction ().equals ("attack")) {
            System.out.println ("The mage is charging up a spell!");
            setAiLastAction ("rest");
        } else {
            skills.get (FIREBALL).use (this, player);
            setAiLastAction ("fireball");
        }
    }
}
