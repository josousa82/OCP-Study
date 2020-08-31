package annotations.ocp_book_annotations.custom;

import java.lang.annotation.Annotation;

/**
 * Created by sousaJ on 25/08/2020
 * in package - annotations
 **/
public class ZooAnimalImpl implements ZooAnimal{
    public String habitat = " ";
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    public String habitat() {
        return null;
    }

}
