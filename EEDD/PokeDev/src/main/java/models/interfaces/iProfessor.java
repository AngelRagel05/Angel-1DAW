package models.interfaces;

import models.Pokemon;
import models.Trainer;

public interface iProfessor {

    void deliverStarterPokemon (Trainer trainer);

    void researchPokemon (Pokemon pokemon);
}
