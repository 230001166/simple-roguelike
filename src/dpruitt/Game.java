package dpruitt;

import dpruitt.entities.Enemy;
import dpruitt.entities.Entity;
import dpruitt.entities.Goblin;
import dpruitt.rooms.*;
import dpruitt.skills.Attack;
import dpruitt.skills.Block;
import dpruitt.skills.useItem;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Game {
    Game () {
        player = new Entity ();
        player.setName ("Morgan");
        player.setHealth (25);
        player.setMaxHealth (25);
        player.setAttack (1);
        player.setDefense (1);
        player.setSpeed (1);
        player.skills.add (new Attack ());
        player.skills.add (new Block ());
        player.skills.add (new useItem ());

        generateFloor ();
    }

    private Entity player;
    private int xPosition = 2;
    private int yPosition = 2;
    private int floor = 1;

    private final int DUNGEON_WIDTH = 5;

    private ArrayList <Room> dungeon = new ArrayList <> ();
    private ArrayList <Room> rooms = new ArrayList <> ();

    public Entity getPlayer () { return player; }

    public void setPlayerPosition (int x, int y) { xPosition = x; yPosition = y; }

    public int getFloor () { return floor; }
    public void modifyFloor (int amount) { floor += amount; }

    public void battle (Enemy enemy) {
        while (player.getHealth () > 0 && enemy.getHealth () > 0) {
            player.modifyCooldown (-1 * player.getSpeed ());
            enemy.modifyCooldown (-1 * enemy.getSpeed ());

            if (player.getCooldown () <= 0) {
                player.setCooldown (36);

                System.out.println (player.getName() + " " + player.getHealthBar ());
                System.out.println ("vs.");
                System.out.println (enemy.getName() + " " + enemy.getHealthBar ());

                for (int i = 0; i < player.skills.size (); i++) {
                    System.out.println (i + " - " + player.skills.get (i).getName ());
                }

                Scanner input = new Scanner (System.in);
                int skillIndex = input.nextInt ();

                if (skillIndex < 0 || skillIndex >= player.skills.size ()) { skillIndex = 0; }

                player.setBlock (0);
                player.skills.get (skillIndex).use (player, enemy);
            }

            if (enemy.getHealth () > 0 && enemy.getCooldown () <= 0) {
                enemy.setCooldown (36);
                enemy.setBlock (0);
                enemy.AI (player);
            }


        }

        if (player.getHealth () > 0) {
            System.out.println ("You won!");
            enemy.awardExperience (player);

            if (player.getExperience () >= player.getLevel () * player.getLevel ()) {
                player.promote ();
            }

        }
    }

    void loop () {
        while (player.getHealth () > 0) {
            renderMap ();
            System.out.println ("HP " + player.getHealthBar ());
            getPlayerInput ();
            dungeon.get (xPosition + (DUNGEON_WIDTH * yPosition)).event (this);
            if (!dungeon.get (xPosition + (DUNGEON_WIDTH * yPosition)).getName ().equals ("   ????   ")
                && dungeon.get (xPosition + (DUNGEON_WIDTH * yPosition)).eventTriggered ()) {
                dungeon.set (xPosition + (DUNGEON_WIDTH * yPosition), new emptyRoom ());
            }
        }

        String pattern = "MM-dd-yyyy HH-mm-ss";
        DateFormat dateFormat = new SimpleDateFormat (pattern);
        Date currentTime = Calendar.getInstance().getTime();
        String filename = "graveyard/graveyard-" + dateFormat.format (currentTime) + ".txt";
        try (PrintWriter out = new PrintWriter (filename)) {
            out.println ("Died at level " + player.getLevel () + " on floor " + floor);
            out.println (player.getExperience () + " EXP");
        } catch (FileNotFoundException error) {
            error.printStackTrace ();
        }

    }

    private void renderMap () {
        for (int i = 0; i < DUNGEON_WIDTH * DUNGEON_WIDTH; i++) {
            if (xPosition + (DUNGEON_WIDTH * yPosition) == i) {
                System.out.print ("  Player   | ");
            } else {
                System.out.print (dungeon.get (i).getName () + " | ");
            }
            if ((i + 1) % 5 == 0) { System.out.print ("\n"); }
        }
    }

    private void getPlayerInput () {
        System.out.println ("[1] Up [2] Left [3] Down [4] Right [5] Check stats");
        Scanner input = new Scanner (System.in);
        int choice = input.nextInt ();

        switch (choice) {
            case 1:
                if (yPosition > 0) {
                    yPosition--;
                    int playerPositionIndex = xPosition + (DUNGEON_WIDTH * yPosition);
                    if (dungeon.get (playerPositionIndex).getName ().equals ("   ????   ")) {
                        generateRoom (playerPositionIndex);
                    }
                }
                break;
            case 2:
                if (xPosition > 0) {
                    xPosition--;
                    int playerPositionIndex = xPosition + (DUNGEON_WIDTH * yPosition);
                    if (dungeon.get (playerPositionIndex).getName ().equals ("   ????   ")) {
                        generateRoom (playerPositionIndex);
                    }
                }
                break;
            case 3:
                if (yPosition < DUNGEON_WIDTH - 1) {
                    yPosition++;
                    int playerPositionIndex = xPosition + (DUNGEON_WIDTH * yPosition);
                    if (dungeon.get (playerPositionIndex).getName ().equals ("   ????   ")) {
                        generateRoom (playerPositionIndex);
                    }
                }
                break;
            case 4:
                if (xPosition < DUNGEON_WIDTH - 1) {
                    xPosition++;
                    int playerPositionIndex = xPosition + (DUNGEON_WIDTH * yPosition);
                    if (dungeon.get (playerPositionIndex).getName ().equals ("   ????   ")) {
                        generateRoom (playerPositionIndex);
                    }
                }
                break;
            case 5:
                player.displayStats ();
                break;
        }
    }

    public void generateFloor () {
        rooms.clear (); dungeon.clear ();

        if (floor < 5) {
            for (int i = 0; i < 9; i ++) {
                rooms.add (new emptyRoom ());
                rooms.add (new enemyRoom ());
            }
            for (int i = 0; i < 3; i ++) { rooms.add (new heartRoom()); }
            for (int i = 0; i < 2; i ++) { rooms.add (new itemRoom ()); }
            rooms.add (new stairRoom ());

        } else {
            for (int i = 0; i < 16; i ++) {
                rooms.add (new emptyRoom ());
            }
            for (int i = 0; i < 4; i ++) { rooms.add (new heartRoom ()); }
            for (int i = 0; i < 3; i ++) { rooms.add (new itemRoom ()); }
            rooms.add (new enemyRoom ());
        }

        for (int i = 0; i < 25; i++) {
            if (i == 12) {
                dungeon.add (new emptyRoom ());
            } else {
                dungeon.add (new Room ());
            }
        }

    }

    private void generateRoom (int index) {
        int randomIndex = random (0, rooms.size () - 1 );
        dungeon.set (index, rooms.get (randomIndex));
        rooms.remove (randomIndex);
    }

    public static int random (int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random () * range) + min;
    }
}
