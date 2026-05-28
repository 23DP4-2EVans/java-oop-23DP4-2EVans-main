package rvt.Person_and_subclasses;

import java.util.ArrayList;

/**
 * Galvenā klase, kas demonstra Person, Student un Teacher objektu izmantošanu.
 */
public class Main {

    /**
     * Izdrukā sarakstā esošos Person objektus.
     *
     * @param persons saraksts ar Person objektiem
     */
    public static void printPersons(ArrayList<Person> persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    /**
     * Programmas galvenā metode. Izveido dažādus Person tipus un izdrukā tos uz konsoles.
     */
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Teacher("Ada Lovelace", "24 Maddox St. London W1S 2QN", "1200"));
        persons.add(new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028", "90028"));

        printPersons(persons);
    }
}