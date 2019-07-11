package dpruitt.entities;

import dpruitt.skills.Attack;
import dpruitt.skills.Frenzy;

public class Chimera extends Enemy {
    public Chimera () {
        setName ("Chimera");
        setHealth (20);
        setMaxHealth (20);
        setAttack (14);
        setDefense (11);
        setSpeed (14);
        setExperience (5);
        skills.add (new Attack ());
        skills.add (new Frenzy ());
    }

    @Override
    public void AI (Entity player) {
        final int ATTACK = 0, FRENZY = 1;
        skills.get (FRENZY).use (this, player);
    }
}
