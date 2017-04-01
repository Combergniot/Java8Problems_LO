package list1;

import com.sdajava.problems.ArrayExec;
import com.sdajava.problems.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lukas on 01.04.2017.
 */

import java.util.*;

import static java.util.Arrays.asList;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
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
    public void shouldDuplicateElementsInAList() throws Exception {
        List<String> duplicates = ArrayExec.duplicate(Arrays.asList("a", "b", "c"), 3);
        assertThat(duplicates, contains("a", "a", "a", "b", "b", "b", "c", "c", "c"));
    }
}
