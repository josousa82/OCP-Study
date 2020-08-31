package annotations.reference_book_annotations_reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 * Created by sousaJ on 31/08/2020
 * in package - annotations.reference_book_annotations_reflection
 **/
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno2{
    String str() default "test default";
    int val() default 10;
}

public class AnnotationDefaultValuesExample {

    @MyAnno2
    public static void myMethod(){
        try{
            Class<?> c = AnnotationDefaultValuesExample.class;
            Method method = c.getMethod("myMethod");
            MyAnno2 annotation = method.getAnnotation(MyAnno2.class);
            System.out.println("annotation = " + annotation);
        }catch (NoSuchMethodException ex){
            System.out.println("ex = " + ex.getMessage());
        }
    }
    public static void main(String[] args) {
        myMethod();
    }
}
