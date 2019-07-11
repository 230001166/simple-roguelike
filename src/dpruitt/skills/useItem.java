package dpruitt.skills;

import dpruitt.entities.Entity;
import dpruitt.items.*;

import java.util.Scanner;

public class useItem extends Skill {
    public useItem () {
        setName ("Use Item");
        setDescription ("Use an item from your inventory.");
    }

    @Override
    public void use (Entity user, Entity target) {
        if (user.inventory.size () >= 1) {
            for (int i = 0; i < user.inventory.size (); i++) {
                System.out.println (i + " - " + user.inventory.get (i).getName ());
            }

            Scanner input = new Scanner (System.in);
            int itemIndex = input.nextInt ();

            if (itemIndex < 0 || itemIndex >= user.inventory.size ()) { itemIndex = 0; }

            user.inventory.get (itemIndex).use (user);
            user.inventory.remove (itemIndex);
        }
    }
}
