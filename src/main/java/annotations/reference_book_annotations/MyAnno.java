package annotations.reference_book_annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by sousaJ on 30/08/2020
 * in package - annotations.reference_book_annotations
 **/
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str();
    int val();
}
