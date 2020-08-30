package annotations.reference_book_annotations;

import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * Created by sousaJ on 30/08/2020
 * in package - annotations.reference_book_annotations
 **/
public class Meta {

    @MyAnno(str = "Annotation Example", val = 100)
    public static void myMeth(){
        Meta ob = new Meta();

        // Obtain the annotation for this method
        // and display the values of the members

        try {
            // First, get a class object that represents this class
            Class<?> c = ob.getClass();
            Method m = c.getMethod("myMeth");
            MyAnno anno = m.getAnnotation(MyAnno.class);

            System.out.println("anno.str() = " + anno.str());
            System.out.println("anno.val() = " + anno.val());

        }catch (NoSuchMethodException exc){
            System.out.println("Method not found");
        }
    }

    @MyAnno(str = "Method field injection", val = 40)
    public static void testMethod(String str, int val){
        System.out.println("str = " + str);
        System.out.println("val = " + val);
    }

    public static void main(String[] args) {
        myMeth();
        annotationValues(new Meta());

    }
    public static <T> T annotationValues(T obj) {
        Class<?> cl = obj.getClass();
        try {
            Method method = cl.getMethod("testMethod");
            MyAnno annotation = method.getAnnotation(MyAnno.class);
            testMethod(annotation.str(), annotation.val());
        }catch (NoSuchMethodException exc){

        }
        return obj;
    }
}
