package annotations.reference_book_annotations_reflection;

import java.lang.reflect.Method;

/**
 * Created by sousaJ on 30/08/2020
 * in package - annotations.reference_book_annotations_reflection
 **/
public class MetaMethodWithParametersReflection {

    @MyAnno(str = "two parameters", val = 19)
    public static void myMethodWithParameters(String str, int val){
        try{

            Class<?> c = MetaMethodWithParametersReflection.class;

            // parameter classes passed has parameters to the method instance  String.class, int.class
            // this is because the method that we are getting has 2 parameters with those types
            Method method = c.getMethod("myMethodWithParameters", String.class, int.class);

            MyAnno annotationParameters = method.getAnnotation(MyAnno.class);
            System.out.println(annotationParameters.str() + " " + annotationParameters.val());

        }catch (NoSuchMethodException ex){
            ex.printStackTrace();
            System.out.println("ex = " + ex);
        }
    }

    public static void main(String[] args) {
        myMethodWithParameters("Method parameter", 0);
    }
}
