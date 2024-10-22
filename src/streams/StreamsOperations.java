package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsOperations {

    public static void main (String[] args){
        //Streams are used to manipulate data in collections
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //Streams have many operations, lets see the intermediaries first
        //This one make a filter in the array, making a new list with even numbers
        System.out.println(numbers.stream().filter(number -> number % 2 == 0).collect(Collectors.toList()));

        //Now have a small difference. The map function return the boolean result of all the numbers
        System.out.println(numbers.stream().map(number -> number % 2 == 0).collect(Collectors.toList()));

        //This function remove all the duplicate elements, the numbers array don't have, but ok...
        System.out.println(numbers.stream().distinct().collect(Collectors.toList()));
    }
}
