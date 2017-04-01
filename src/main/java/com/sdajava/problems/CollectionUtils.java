package com.sdajava.problems;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by lukas on 01.04.2017.
 */
public abstract class CollectionUtils {

    public static <T> LinkedList<T> linkedList(T... elements){
        return Stream.of(elements).collect(Collectors.toCollection(LinkedList::new));
    }
}
