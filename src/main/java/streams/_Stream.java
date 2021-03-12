package streams;

import java.util.List;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;

public class _Stream {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE),
                new Person("Bob", PREFER_NOT_TO_SAY)
        );

//        people.stream()
//                .map(person -> person.gender)
//                .collect(Collectors.toSet())
//                .forEach(System.out::println);
//
//        people.stream()
//                .map(person -> person.name)
//                .collect(Collectors.toSet())
//                .forEach(System.out::println);
//
//        people.stream()
//                .map(person -> person.name)
//                .mapToInt(String::length)
//                .forEach(System.out::println);

        boolean containsOnlyFemales = people.stream()
                .allMatch(person -> FEMALE.equals(person.gender));

        System.out.println(containsOnlyFemales);

        boolean containsAnyFemales = people.stream()
                .anyMatch(person -> FEMALE.equals(person.gender));

        System.out.println(containsAnyFemales);

        boolean notContainsAnyFemales = people.stream().
                noneMatch(person -> FEMALE.equals(person.gender));

        System.out.println(notContainsAnyFemales);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY;
    }
}
