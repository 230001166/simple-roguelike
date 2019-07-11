package dpruitt.skills;

import dpruitt.entities.Entity;
import dpruitt.items.*;
import dpruitt.utility.Input;

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

            int itemIndex = Input.getIntegerInputInRange (0, user.inventory.size () - 1);

            user.inventory.get (itemIndex).use (user);
            user.inventory.remove (itemIndex);
        }
    }
}
