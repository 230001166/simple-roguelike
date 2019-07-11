package dpruitt.rooms;

import dpruitt.Game;
import dpruitt.entities.*;

public class enemyRoom extends Room {
    public enemyRoom () {
        setName ("Enemy Room");
    }

    @Override
    public void event (Game game) {
        eventHasBeenTriggered = true;

        switch (game.getFloor ()) {
            case 1:
                game.battle (new Goblin ());
                break;
            case 2:
                int randomNumber = Game.random (1, 16);

                if (randomNumber <= 9) {
                    game.battle (new Rogue ());
                } else {
                    game.battle (new shieldWarrior ());
                }
                break;
            case 3:
                game.battle (new Mage ());
                break;
            case 4:
                game.battle (new Chimera ());
                break;
            case 5:
                game.battle (new richardNixon ());
                break;
        }
    }
}
