package rvt.Person_and_subclasses;

/**
 * Student klase manto Person un papildus uzglabā kredītu skaitu.
 */
public class Student extends Person {
    // Studenta uzkrāto kredītu skaits.
    private int credits;

    /**
     * Izveido jaunu Student objektu ar sākotnējo kredītu skaitu 0.
     *
     * @param name_surname studenta vārds un uzvārds
     * @param adress studenta adrese
     * @param index studenta indekss
     */
    public Student(String name_surname, String adress, String index) {
        super(name_surname, adress, index);
        this.credits = 0;
    }

    /**
     * Atgriež pašreizējo studenta kredītu skaitu.
     */
    public int credits() {
        return credits;
    }

    /**
     * Palielina studenta kredītu skaitu par vienu, simulējot studēšanu.
     */
    public void study() {
        credits++;
    }

    /**
     * Atgriež studenta informāciju kā tekstu, iekļaujot kredītu skaitu.
     */
    @Override
    public String toString() {
        return super.toString() + " credits " + credits;
    }

    /**
     * Demonstrācija Student klases darbībai: izdrukā studentu un parāda kredītu skaita izmaiņas.
     */
    public static void main(String[] args) {
        Student ollie = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028", "90028");
        System.out.println(ollie);
        System.out.println("Study credits " + ollie.credits());
        ollie.study();
        System.out.println("Study credits " + ollie.credits());
    }
}