package com.sdajava.problems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.AbstractMap.SimpleEntry;

import static java.util.stream.Collectors.toList;

/**
 * Created by lukas on 01.04.2017.
 */
public class ArrayExec {


    public static <T> T last(List<T> elements){

        int numberOfElements = elements.size();
        return elements.get(numberOfElements - 1);

    }

    public static <T> T last(LinkedList<T> elements){
        return elements.getLast();
    }

    public static <T> long length(List<T> list){

        if(list == null){
            throw new IllegalArgumentException("lista nie moze byc null");
        }

        return list.stream().count();
    }

    public static <T> List<T> reverse(List<T> list){
        Collections.reverse(list);
        return list;
    }

    public static <T> List<T> reverseStream(List<T> list){
        int size = list.size();
        return IntStream.iterate(size - 1, el -> el - 1)
            .limit(size).mapToObj(list::get).collect(toList());
    }

    public static <T> boolean isPalindrome(List<T> list){
        List<T> original = new ArrayList<T>(list);
        ArrayExec.reverse(list);
        return Objects.equals(list, original);
    }

    public static <T> List<T> compress(List<T> list) {
        /*Objects.requireNonNull(list, "Lista nie moze byc nullem");
        List<T> result = new ArrayList<>();
        T lastElement = null;
        for (T e : list) {
            if (!Objects.equals(lastElement, e)) {
                result.add(e);
            }
            lastElement = e;
        }
        return result;
        */

        return list.stream().distinct().collect(Collectors.toList());
    }

    public static <T> List<T> duplicate(final List<T> list, final int times) {
        return list.stream().flatMap(e -> Collections.nCopies(times, e)
            .stream()).collect(toList());
    }

    public static <T> List<T> dropEveryNth(final List<T> list, final int times){
        return IntStream.range(0, list.size())
                        .filter(n -> (n+1) % times != 0)
                        .mapToObj(list::get)
                        .collect(Collectors.toList());
    }

    public static <T> List<T> insertAt(List<T> list, int pos, T t){
        list.add((pos-1), t);
        return list;
    }


}
