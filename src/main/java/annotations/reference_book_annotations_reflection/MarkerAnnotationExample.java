package annotations.reference_book_annotations_reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by sousaJ on 31/08/2020
 * in package - annotations.reference_book_annotations_reflection
 **/
@Retention(RetentionPolicy.RUNTIME)
@interface MyMarker{}

public class MarkerAnnotationExample {

    @MyMarker
    public static void myMethod(){

        try {
            var m = MarkerAnnotationExample.class.getMethod("myMethod").isAnnotationPresent(MyMarker.class);

            if(m) System.out.println("Marker annotation is present");
            else System.out.println("Marker annotation is not present");

        } catch (NoSuchMethodException e) {
            System.out.println("e = " + e);
        }
    }

    public static void main(String[] args) {
        myMethod();
    }
}
