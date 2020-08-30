package annotations.reference_book_annotations_reflection;

/**
 * Created by sousaJ on 30/08/2020
 * in package - annotations.reference_book_annotations_reflection
 **/
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        Class<?> c = m.getClass();
        System.out.println("c = " + c.getSimpleName());
    }
}
