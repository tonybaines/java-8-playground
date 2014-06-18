package tonyb.java8.lambdas;

import java.util.Comparator;
import java.util.Random;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import static tonyb.java8.lambdas.FunctionInterfaces.Markings.Black;
import static tonyb.java8.lambdas.FunctionInterfaces.Markings.Tabby;
import static tonyb.java8.lambdas.FunctionInterfaces.Markings.TortoiseShell;
import static tonyb.java8.lambdas.FunctionInterfaces.Markings.White;

import java.util.ArrayList;
import java.util.List;

public class FunctionInterfaces {
    static final String[] NAME_POOL = new String[] {"Bob", "Dave", "Eric", "Alan"};

    enum Markings { Tabby, Black, White, TortoiseShell }

    class Cat {
        String name;
        Markings markings;
        Integer weightInKg;
        Cat(String name, Markings markings, Integer weightInKg) {
            this.name = name;
            this.markings = markings;
            this.weightInKg = weightInKg;
        }
    }

    List<Cat> clowder = new ArrayList<Cat>() {{
            add(new Cat("Charm", Tabby, 5));
            add(new Cat("Strange", Black, 3));
            add(new Cat("Down", TortoiseShell, 3));
            add(new Cat("Up", TortoiseShell, 3));
            add(new Cat("Bottom", White, 4));
            add(new Cat("Top", Black, 2));
        }};


//    @FunctionalInterface
//    public interface Comparator<T> {
//        int compare(T o1, T o2);
//    }

    static Comparator<Cat> byWeight = (c1, c2) -> c1.weightInKg.compareTo(c2.weightInKg);
    static Comparator<Cat> byMarkings = (c1, c2) -> c1.markings.compareTo(c2.markings);
    static Comparator<Cat> byName = (c1, c2) -> c1.name.compareTo(c2.name);

    public void sort() {
        clowder.sort(byWeight);
        clowder.sort(byMarkings);
        clowder.sort(byName);
    }


//    @FunctionalInterface
//    public interface Predicate<T> {
//        boolean test(T t);
//    }

    static Predicate<Cat> patterned = (c) -> c.markings.equals(Tabby) || c.markings.equals(TortoiseShell);
    static Predicate<Cat> heavy = (c) -> c.weightInKg >= 4;

    public void filter() {
        clowder.stream().filter(patterned);
        clowder.stream().filter(heavy);
    }

//    @FunctionalInterface
//    public interface Function<T, R> {
//        R apply(T t);
//    }

    static Function<? super Cat, String> toString = (c) -> c.name;
    static Function<? super Cat, String> toHtml = (c) -> String.format("<blink>%s</blink>", toString.apply(c));
    static Function<? super Cat, String> toJson = (c) -> String.format("{ 'name': %s, 'weightInKg': %d, 'markings': %s }", c.name, c.weightInKg, c.markings);

    public void transform() {
        clowder.stream().map(toString);
        clowder.stream().map(toHtml);
        clowder.stream().map(toJson);
    }


//    @FunctionalInterface
//    public interface Supplier<T> {
//        T get();
//    }

    Supplier<Cat> randomCats = () -> {
        int i = new Random().nextInt(5);
        return new Cat(NAME_POOL[i], Markings.values()[i], i);
    };

    public void customStream() {
        Stream.generate(randomCats)
                .limit(10) // enough for anyone
                .map(toJson)
                .forEach(json -> System.out.println(json));
    }



    Supplier<String> supplier = () -> "Hello";

    Predicate<Integer> predicate = (i) -> i == 42;

    Function<String, String> answer = (q) -> "forty-two";

    Function<Integer, Function<Integer, Integer>> multiply = (i) ->  (j) -> i*j;



}
