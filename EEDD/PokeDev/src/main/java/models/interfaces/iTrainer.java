package models.interfaces;

import models.Trainer;
import models.enumerations.Item;

public interface iTrainer {

    void addPokemon();

    boolean combatTrainer(Trainer rival, Trainer principal);

    boolean capture(Item item);
}
