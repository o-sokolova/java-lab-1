package lab5_Person;

import java.util.*;

public class Person implements Comparable<Person>{
    private final String name;
    private final String surname;
    private final int age;


    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
        int compareSurname = this.getSurname().compareTo(person.getSurname());
        return compareSurname == 0 ? this.getName().compareTo(person.getName()) : compareSurname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        List <Person> people = new ArrayList<>();
        people.add(new Person("m", "2", 300));
        people.add(new Person("a", "4", 16));
        people.add(new Person("s", "mm", 3));
        people.add(new Person("c", "aa", 1));
        people.add(new Person("a", "aa", 10));

        Comparator.comparing(Person::getName);
        System.out.println("Sort by name");
        for (Person person: people)
            System.out.println(person.toString());

        Comparator.comparing(Person::getSurname);
        System.out.println("Sort by surname");
        for (Person person: people)
            System.out.println(person.toString());

        Comparator.comparing(Person::getAge);
        System.out.println("Sort by age");
        for (Person person: people)
            System.out.println(person.toString());


        System.out.println("Without sorting");
        for (Person person: people)
            System.out.println(person.toString());

        Collections.sort(people);
        System.out.println("Sort by name and surname");
        for (Person person: people)
            System.out.println(person.toString());
    }
}
