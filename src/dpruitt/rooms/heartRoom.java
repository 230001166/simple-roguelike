package dpruitt.rooms;

import dpruitt.Game;
import dpruitt.utility.Input;

public class heartRoom extends Room {
    public heartRoom () {
        setName ("Heart Room");
    }

    @Override
    public void event (Game game) {
        eventHasBeenTriggered = true;

        System.out.println ("You see a heart statue. You can either heal or sacrifice your health to gain more max health.\n" +
                "[1] Heal 25% of Max HP\n" +
                "[2] Sacrifice half your health to gain 3 Max HP");
        int choice = Input.getIntegerInputInRange (1, 2);

        switch (choice) {
            case 1:
                game.getPlayer ().modifyHealth(game.getPlayer ().getMaxHealth() / 4);
                if (game.getPlayer ().getHealth () > game.getPlayer ().getMaxHealth ()) {
                    game.getPlayer ().setHealth (game.getPlayer ().getMaxHealth ());
                }
                break;
            case 2:
                game.getPlayer ().setHealth (game.getPlayer ().getHealth () / 2);
                game.getPlayer ().modifyMaxHealth (3);
                break;
        }
    }
}
