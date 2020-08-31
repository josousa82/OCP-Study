package annotations.reference_book_annotations_reflection;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.Arrays;
/**
 * Created by sousaJ on 31/08/2020
 * in package - annotations.reference_book_annotations_reflection
 **/


@Retention(RetentionPolicy.RUNTIME)
@interface What{
    String description();
}

@What(description = "An annotation test class")
@MyAnno(str = "metadata", val = 10)
public class GetAllAnnotationsExample {

    @What(description = "An annotation method test")
    @MyAnno(str = "method annotation", val = 34)
    public static void myMethod(){
        var classInstance = new GetAllAnnotationsExample();

        try{
            // print class annotations
            Annotation[] annos = classInstance.getClass().getAnnotations();
            Arrays.stream(annos)
                    .forEach(System.out::println);

            //print method annotations
            Method m = classInstance.getClass().getMethod("myMethod");
            annos = m.getAnnotations();
            Arrays.stream(annos)
                    .forEach(System.out::println);

        }catch (NoSuchMethodException ex){
            System.out.println("ex = " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        myMethod();
    }
}
