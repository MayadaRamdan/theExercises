package org.example.exercises;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupWordsByLength {

    public static Map<Integer, List<String>> getTheMap(List<String> list) {
        // toMap -> in case  (1 key) -> (1 value)  return type is map
        //groupingBy->  in case  (1 key) -> (multiple value)  return type is map too

        return list.stream().collect(Collectors.groupingBy(String::length));
    }


}
