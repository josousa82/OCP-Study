package annotations.reference_book_annotations_reflection.custom_annotations.advanced_type_annotations_target;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by sousaJ on 31/08/2020
 * in package - annotations.reference_book_annotations_reflection.custom_annotations.advanced_type_annotations_target
 **/

// make MyAnno repeatable
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyRepeatableAnnos.class)
@interface MyAnno{
    String str() default "Testing";
    int val() default 9000;
}

// Container annotation that allows the annotation to be repeated
@Retention(RetentionPolicy.RUNTIME)
@interface MyRepeatableAnnos{
    MyAnno[] value();
}

public class RepeatAnno {

    // Repeat Myanno in myMeth
    @MyAnno(str = "First Annotation", val = -1)
    @MyAnno(str = "Second Annotation", val = 100)
    public static void myMeth(String str, int i){
        RepeatAnno obj = new RepeatAnno();
        try{
            Class<?> cl = obj.getClass();

            // Obtain the annotations for myMeth
            Method method = cl.getMethod("myMeth", String.class, int.class);

            // display the repeated MyAnno annotations, note that the container
            // annotation is passed as the type to get
            Annotation anno = method.getAnnotation(MyRepeatableAnnos.class);
            System.out.println("anno = " + anno);

            // another way of getting all annotations
            // note that here is the annotation itself
            Annotation[] annos = method.getAnnotationsByType(MyAnno.class);
            Arrays.stream(annos)
                    .forEach(System.out::println);
        }catch (NoSuchMethodException ex){
            System.out.println("Method not found");
        }
    }

    public static void main(String[] args) {
        myMeth("test", 10);
    }
}

