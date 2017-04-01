package list1;

import com.sdajava.problems.ArrayExec;
import com.sdajava.problems.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lukas on 01.04.2017.
 */

import java.util.*;
import java.util.stream.Stream;
import java.util.AbstractMap.SimpleEntry;

import static java.util.Arrays.asList;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

public class ArraysTest {

    @Test
    public void shouldFindLastElementFromAList(){
        assertThat(ArrayExec.last(asList("a", "b", "c")),
            is(equalTo("b")));
    }

    @Test
    public void shouldFindLastElementFromALinkedList(){
        LinkedList<String> list =
            CollectionUtils.linkedList("a", "b", "c", "c");

        assertThat(ArrayExec.last(list), is(equalTo("c")));

    }

    @Test
    public void shouldFindLastElementFromAlistUsingRecursion(){
        // assertThat(ArrayExec.lastRecursive(asList("a","b", "c")), is(equalTo("c")));
    }

    @Test
    public void listOfEmptyListShouldBe0(){
        long length = ArrayExec.length(Collections.emptyList());
        assertThat(length, is(equalTo(0L)));
    }

    @Test
    public void shouldFindListOfNonEmptyList(){
        assertThat(ArrayExec.length(asList(1,2,3,4,5,6)), is(equalTo(6L)));
    }

    @Test
    public void shouldReverseAList(){

        List<Integer> numbers = new ArrayList<>();
        List<Integer> reverseNumbers = new ArrayList<>();

        for (int i=10000000; i>=0; i--){
            reverseNumbers.add(i);
        }

        for(int i=0; i<=10000000; i++){
            numbers.add(i);
        }
        final long startTime = System.currentTimeMillis();
        assertThat(ArrayExec.reverse(numbers), is(equalTo(reverseNumbers)));
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) );

    }

    @Test
    public void shouldReturTrueWhenListIsPalindrome(){
        assertTrue(ArrayExec.isPalindrome(asList("a", "l", "a")));
    }

    @Test
    public void shouldRemoveConsecutiveDuplicatesInAList(){
        List<String> compressedList
            = ArrayExec.compress(asList("a", "a", "a", "a", "b", "c", "c", "d", "e", "e", "e", "e"));
        assertThat(compressedList, contains("a","b"));
    }

    @Test
    public void shouldDuplicateElementsInAList() {
        List<String> duplicates = ArrayExec.duplicate(Arrays.asList("a", "b", "c"), 3);
        assertThat(duplicates, contains("a", "a", "a", "b", "b", "b", "c", "c", "c"));
    }

    @Test
    public void shouldDropEveryNthElement() {
        List<String> result =
            ArrayExec.dropEveryNth(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"), 3);
        assertThat(result, contains("a", "b", "d", "e", "g", "h", "j", "k"));
    }

    @Test
    public void shouldInsertElementAtSecondPosition() throws Exception {
        List<String> input = Stream.of("a", "b", "c", "d").collect(toList());
        List<String> result = ArrayExec.insertAt(input, 2, "alfa");
        assertThat(result, contains("a", "alfa", "b", "c", "d"));

    }

    @Test
    //liczba elementow powtarzajacych sie
    public void shouldEncodeAList() throws Exception {
        List<SimpleEntry<Integer, String>> encodedList = ArrayExec.encode(Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"));
        assertThat(encodedList.get(0), is(equalTo(new SimpleEntry<>(4, "a"))));
        assertThat(encodedList.get(1), is(equalTo(new SimpleEntry<>(1, "b"))));
        assertThat(encodedList.get(2), is(equalTo(new SimpleEntry<>(2, "c"))));
        assertThat(encodedList.get(3), is(equalTo(new SimpleEntry<>(2, "a"))));
        assertThat(encodedList.get(4), is(equalTo(new SimpleEntry<>(1, "d"))));
        assertThat(encodedList.get(5), is(equalTo(new SimpleEntry<>(4, "e"))));
    }

    @Test
    //odwrotnosc poprzedniego
    public void shouldDecodeEncodedList() throws Exception {
        List<String> encoded = ArrayExec.decode(
            Arrays.asList(
                new SimpleEntry<>(4, "a"),
                "b",
                new SimpleEntry<>(2, "c"),
                new SimpleEntry<>(2, "a"),
                "d",
                new SimpleEntry<>(4, "e")));

        assertThat(encoded, hasSize(14));
    }

    @Test
    //duplikaty elementow
    public void shouldDuplicateElementsInAList() throws Exception {
        List<String> duplicates = ArrayExec.duplicate2(Arrays.asList("a", "b", "c", "d"));
        assertThat(duplicates, hasSize(8));
        assertThat(duplicates, contains("a", "a", "b", "b", "c", "c", "d", "d"));
    }

    @Test
    //podzial listy
    public void shouldSplitInTwoHalves() throws Exception {
        Map<Boolean, List<String>> result = ArrayExec.split(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "k"), 3);
        assertThat(result.get(true), contains("a", "b", "c"));
        assertThat(result.get(false), contains("d", "e", "f", "g", "h", "i", "k"));
    }

    @Test
    //stworzenie listy z podanego zakresu
    public void shouldCreateARangeBetween4And9() throws Exception {
        List<Integer> range = ArrayExec.range(4, 9);
        assertThat(range, hasSize(6));
        assertThat(range, contains(4, 5, 6, 7, 8, 9));

    }

    @Test
    public void shouldGive6RandomNumbersFromARangeStartingFrom1To49() throws Exception {
        List<Integer> randomList = ArrayExec.randomSelect(6, 1, 49);
        assertThat(randomList, hasSize(6));
        System.out.println(randomList); // One possible output [47, 30, 36, 38, 11, 1]
    }

}
