package annotations;

/**
 * Created by sousaJ on 25/08/2020
 * in package - annotations
 **/
public class Veterinarian {

    @ZooAnimal(habitat = "Infirmary") private Lion lionSick;

    @ZooAnimal(habitat = "Safari") private Lion healthyLion;

    @ZooAnimal(habitat = "Special Enclosure") private Lion blindLion;
}
