package dpruitt.items;

import dpruitt.entities.Entity;

public class Potion extends Item {
    public Potion () {
        setName ("Potion");
    }

    @Override
    public void use (Entity target) {
        target.modifyHealth (7);
        if (target.getHealth () > target.getMaxHealth ()) { target.setHealth (target.getMaxHealth ()); }
    }
}
