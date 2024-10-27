import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaStreams {
    public static void main(String[] args) {
        /* old way of dealing with interface that has only one function */
        // Walkable obj = new WalkFast();
        // obj.walk(6);

        /* anonymous object creation */
        // Walkable obj = new Walkable() {
        // public int walk(int steps) {
        // System.out.println("hello from inside anonymous");
        // return 0;
        // }
        // };
        // obj.walk(7);

        /* new way */
        /* lambda */
        // Walkable obj = (steps)->{
        // System.out.println("hey hey lambda here");
        // return 0;
        // };

        /* Streams */
        List<String> fruits = List.of("Apple", "kiwi", "mango");
        Stream<String> stream = fruits.stream();

        // List<Integer> fruitsLength = stream
        // .map(fruit -> fruit.length())
        // .collect(Collectors.toList());

        // fruitsLength.forEach(fruitLength -> System.out.println(fruitLength));

        Map<String, Integer> mp = stream.collect(Collectors.toMap(
                key -> key, // key mapper
                value -> value.length())); // value mapper

        // stream
        // .filter(fruit -> fruit.length() < 6)
        // .sorted()
        // // .map(fruitLength -> 2 * fruitLength)
        // .forEach(fruitLength -> System.out.println(fruitLength));

        stream
                .filter(fruit -> fruit.length() < 6)
                .sorted()
                // .map(fruitLength -> 2 * fruitLength)
                .forEach(System.out::println);// method inference

        /*
         * The advantage of streams is they can by once after that they will be removed
         * from the memory
         * As soon as we use filter() method a new stream is create and stream created
         * before is removed
         * similary when we use sorted() the filtered stream will be deleted that's how
         * it works
         */
    }
}

interface Walkable {
    int walk(int steps);
}

class WalkFast implements Walkable {

    @Override
    public int walk(int steps) {
        System.out.println("Walking very fast with steps " + steps);
        return 0;
    }

}