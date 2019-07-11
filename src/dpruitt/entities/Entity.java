package dpruitt.entities;

import dpruitt.items.Item;
import dpruitt.skills.*;
import dpruitt.utility.Input;

import java.util.ArrayList;

public class Entity {
    private String name = "Entity";
    private String faction = "player";

    private int health = 17;
    private int maxHealth = 17;

    private int block = 0;

    private int attack = 3;
    private int defense = 3;
    private int speed = 3;

    private int experience = 0;
    private int level = 1;

    private int cooldown = 36;

    public ArrayList <Skill> skills = new ArrayList <> ();
    public ArrayList <Item> inventory = new ArrayList <> ();

    public String getName () { return name; }
    public void setName (String newName) { name = newName; }

    public String getFaction () { return faction; }
    public void setFaction (String newName) { faction = newName; }

    public int getHealth () { return health; }
    public void setHealth (int newHealth) { health = newHealth; }
    public void modifyHealth (int amount) { health += amount; }

    public int getMaxHealth () { return maxHealth; }
    public void setMaxHealth (int newHealth) { maxHealth = newHealth; }
    public void modifyMaxHealth (int amount) { maxHealth += amount; }

    public int getBlock () { return block; }
    public void setBlock (int amount) { block = amount; }
    public void modifyBlock (int amount) { block += amount; }

    public int getAttack () { return attack; }
    public void setAttack (int amount) { attack = amount; }
    public void modifyAttack (int amount) { attack += amount; }

    public int getDefense () { return defense; }
    public void setDefense (int amount) { defense = amount; }
    public void modifyDefense (int amount) { defense += amount; }

    public int getSpeed () { return speed; }
    public void setSpeed (int amount) { speed = amount; }
    public void modifySpeed (int amount) { speed += amount; }

    public int getExperience () { return experience; }
    public void setExperience (int amount) { experience = amount; }
    public void modifyExperience (int amount) { experience += amount; }

    public int getLevel () { return level; }
    public void modifyLevel (int amount) { level += amount; }

    public int getCooldown () { return cooldown; }
    public void setCooldown (int amount) { cooldown = amount; }
    public void modifyCooldown (int amount) { cooldown += amount; }

    public void dealDamage (int amount) {

        int damage = amount - block;
        if (damage < 0) { damage = 0; }

        health -= damage;
        System.out.println (name + " took " + damage + " damage!");
    }

    public void displayStats () {
        System.out.println ("=== STATS ===");
        System.out.println (name);
        System.out.println ("LEVEL " + level + " : " + experience + " EXP");
        System.out.println ("HP " + health);
        System.out.println ("Attack " + attack);
        System.out.println ("Defense " + defense);
        System.out.println ("Speed " + speed);

    }

    public String getHealthBar () {
        final int TOTAL_BARS = 20;
        int barsToFill = (int) (TOTAL_BARS * ((double) health / maxHealth));

        String healthBarString = "[";
        healthBarString += health; healthBarString += "] [";
        for (int i = 0; i < barsToFill; i++) { healthBarString += '='; }
        for (int i = 0; i < (TOTAL_BARS - barsToFill); i++) { healthBarString += " "; }
        healthBarString += "]";

        return healthBarString;
    }

    public void promote () {
        level++; health += 3; maxHealth += 3;
        System.out.println ("[!] - Now level " + level + "!");

        int promotionPoints = 4; if (level == 10) { promotionPoints += 4; }

        while (promotionPoints > 0) {
            System.out.println ("Boost one of the following stats:\n[1] Attack\n[2] Defense\n[3] Speed\nPoints Left: " + promotionPoints);

            int choice = Input.getIntegerInputInRange (1, 3);

            switch (choice) {
                case 1:
                    attack++; promotionPoints--;
                    break;
                case 2:
                    defense++; promotionPoints--;
                    break;
                case 3:
                    speed++; promotionPoints--;
                    break;
                default:
                    System.out.println ("Invalid choice! Try again.");
                    break;
            }
        }

        if (level == 4) {
            System.out.println ("You can learn a magic spell! Choose between [1] Ice and [2] Fireball.");
            int choice = Input.getIntegerInputInRange (1, 2);

            switch (choice) {
                case 1:
                    skills.add (new Ice ());
                    break;
                case 2:
                    skills.add (new Fireball ());
                    break;
            }
        }
        if (level == 6) {
            skills.set (0, new attackPlus ());
        }
        if (level == 9) {
            System.out.println ("You can learn a magic spell! Choose between [1] Ice+ and [2] Fireball+.");
            int choice = Input.getIntegerInputInRange (1, 2);

            switch (choice) {
                case 1:
                    skills.add (new icePlus ());
                    break;
                case 2:
                    skills.add (new fireballPlus ());
                    break;
            }
        }
    }

}
