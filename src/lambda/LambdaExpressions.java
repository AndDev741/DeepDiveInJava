package lambda;

import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExpressions {
    public static void main(String[] args){
        //First, I'm going to use the Predicate class that receive a T value and return
        // a boolean
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(7)); //false

        //Now, the class Function receive a T value and return e R value;
        Function<String, Integer> length = s -> s.length();
        System.out.println(length.apply("Lambda")); //6

        //Java have many interfaces to use Lambda, but we can create our own Interfaces,
        //or use just to resolve some problems, like in Streams, lets see (in other package)
    }
}
