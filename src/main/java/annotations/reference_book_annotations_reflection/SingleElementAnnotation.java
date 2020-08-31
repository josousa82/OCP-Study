package annotations.reference_book_annotations_reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by sousaJ on 31/08/2020
 * in package - annotations.reference_book_annotations_reflection
 **/
@Retention(RetentionPolicy.RUNTIME)
@interface MySingle{
    int value(); // this value name must be value
}
public class SingleElementAnnotation {

    @MySingle(100)
    public static void myMethod(){
        try{
            var annotation = SingleElementAnnotation.class.getMethod("myMethod").getAnnotation(MySingle.class);
            System.out.println("annotation = " + annotation.value());
        } catch (NoSuchMethodException exception) {
            exception.printStackTrace();
        }
    }
    public static void main(String[] args) {
        myMethod();
    }
}
