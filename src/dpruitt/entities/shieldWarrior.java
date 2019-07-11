package dpruitt.entities;

import dpruitt.skills.Attack;
import dpruitt.skills.Block;

public class shieldWarrior extends Enemy {
    public shieldWarrior () {
        setName ("Shield Warrior");
        setHealth (13);
        setMaxHealth (13);
        setAttack (4);
        setDefense (3);
        setSpeed (4);
        setExperience (2);
        skills.add (new Attack ());
        skills.add (new Block ());
    }

    @Override
    public void AI (Entity player) {
        final int ATTACK = 0, BLOCK = 1;

        if (getAiLastAction ().equals ("attack")) {
            skills.get (BLOCK).use (this, player);
            setAiLastAction ("block");
        } else {
            skills.get (ATTACK).use (this, player);
            setAiLastAction ("attack");
        }
    }
}
