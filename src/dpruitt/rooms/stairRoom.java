package dpruitt.rooms;

import dpruitt.Game;

import java.util.Scanner;

public class stairRoom extends Room {
    public stairRoom () {
        setName ("Stair Room");
    }

    @Override
    public void event (Game game) {
        System.out.println ("You have reached the stairs. Do you want to go to the next floor?\n[1] Yes\n[2] No");

        Scanner input = new Scanner (System.in);
        int choice = input.nextInt ();

        if (choice == 1) {
            game.setPlayerPosition (2, 2);
            game.modifyFloor (1);
            System.out.println ("You have moved to the next floor.");
            game.generateFloor ();
            eventHasBeenTriggered = true;
        }

    }
}
