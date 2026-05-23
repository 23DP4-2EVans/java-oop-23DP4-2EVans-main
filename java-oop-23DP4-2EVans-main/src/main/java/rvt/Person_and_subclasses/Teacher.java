package rvt.Person_and_subclasses;

/**
 * Teacher klase paplašina Person klasi un reprezentē skolotāju.
 */
public class Teacher extends Person {

    /**
     * Izveido jaunu Teacher objektu ar norādīto vārdu, adresi un indeksu.
     *
     * @param name_surname skolotāja vārds un uzvārds
     * @param adress skolotāja adrese
     * @param index skolotāja identifikators
     */
    public Teacher(String name_surname, String adress, String index) {
        super(name_surname, adress, index);
    }

    /**
     * Testa metode, kas demonstrē Teacher klases un Student klases darbību.
     */
    public static void main(String[] args) {
        Student ollie = new Student(
            "Ollie",
            "6381 Hollywood Blvd. Los Angeles 90028",
            "90028"
        );

        for (int i = 0; i < 25; i++) {
            ollie.study();
        }

        System.out.println(ollie);

        Teacher ada = new Teacher("Ada Lovelace", "24 Maddox St. London W1S 2QN", "12345");
        Teacher esko = new Teacher("Esko Ukkonen", "Mannerheimintie 15 00100 Helsinki", "54321");

        System.out.println(ada);
        System.out.println(esko);
    }
}