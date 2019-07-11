package dpruitt.rooms;

import dpruitt.Game;
import dpruitt.utility.Input;


public class stairRoom extends Room {
    public stairRoom () {
        setName ("Stair Room");
    }

    @Override
    public void event (Game game) {
        System.out.println ("You have reached the stairs. Do you want to go to the next floor?\n[1] Yes\n[2] No");

        int choice = Input.getIntegerInputInRange (1, 2);

        if (choice == 1) {
            game.setPlayerPosition (2, 2);
            game.modifyFloor (1);
            System.out.println ("You have moved to the next floor.");
            game.generateFloor ();
            eventHasBeenTriggered = true;
        }

    }
}
