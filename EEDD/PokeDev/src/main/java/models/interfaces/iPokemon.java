package models.interfaces;

import models.enumerations.Item;

public interface iPokemon {

    void cure (Item item);

    void levelUp (Item item);

    void revive (Item item);
}