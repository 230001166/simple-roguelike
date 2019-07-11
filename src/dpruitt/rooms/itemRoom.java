package dpruitt.rooms;

import dpruitt.Game;
import dpruitt.items.Potion;

public class itemRoom extends Room {
    public itemRoom () {
        setName ("Item Room ");
    }

    @Override
    public void event (Game game) {
        eventHasBeenTriggered = true;
        game.getPlayer ().inventory.add (new Potion ());

        System.out.println ("You find a chest with a potion in it!");
    }
}
