package dpruitt.entities;

import dpruitt.skills.Watergate;
import dpruitt.skills.attackPlus;

public class richardNixon extends Enemy {
    public richardNixon () {
        setName ("Richard Milhouse Nixon");
        setHealth (36);
        setMaxHealth (36);
        setAttack (16);
        setDefense (16);
        setSpeed (16);

        skills.add (new attackPlus ());
        skills.add (new Watergate ());
    }

    @Override
    public void AI (Entity player) {
        final int ATTACK = 0, WATERGATE = 1;
        skills.get (ATTACK).use (this, player);

        if (getHealth () == 1) {
            skills.get (WATERGATE).use (this, player);
        }
    }
}
