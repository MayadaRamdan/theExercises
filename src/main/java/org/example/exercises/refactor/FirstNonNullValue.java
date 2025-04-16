package org.example.exercises.refactor;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FirstNonNullValue {


//    List<String> values = Arrays.asList(null, "hello", null, "world");
//    String firstNonNull = null;
//    for (String s : values) {
//        if (s != null) {
//            firstNonNull = s;
//            break;
//        }
//    }
//    firstNonNull = firstNonNull != null ? firstNonNull : "default";

    public static String notNullValue(){
        List<String> values = Arrays.asList("ll", "hello", "ll", "world");
        return  values.stream()
                .filter(Objects::nonNull).findFirst().orElse("default");
    }



}
