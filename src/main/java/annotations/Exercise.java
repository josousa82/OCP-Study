package annotations;

/**
 * Created by sousaJ on 25/08/2020
 * in package - annotations
 **/
public @interface Exercise {
    int hoursPerDay();
    int startHour() default 6;
}
