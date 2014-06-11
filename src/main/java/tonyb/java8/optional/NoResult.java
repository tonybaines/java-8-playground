package tonyb.java8.optional;

import java.util.List;
import java.util.Optional;

public class NoResult {

    private static final List<Person> people = null;
    private static final List<BetterPerson> betterPeople = null;

    public static class Person {
        private Pet pet;
        public Pet getPet() { return pet; }
    }
    public class Pet {
        private String name;
        public String getName() { return name; }
    }

    public static void main(String[] args) {
            people.stream()
                    .map(person -> person.getPet().getName())
                    .forEach(System.out::println);

            betterPeople.stream()
                    .map(person -> person.getPet().map(Pet::getName))
                    .forEach(System.out::println);

    }


    public static class BetterPerson {
        private Pet pet;
        public Optional<Pet> getPet() { return Optional.ofNullable(pet); }
    }
}
