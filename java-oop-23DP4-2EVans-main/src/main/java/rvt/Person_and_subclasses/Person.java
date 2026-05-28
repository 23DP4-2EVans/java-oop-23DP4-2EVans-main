package rvt.Person_and_subclasses;

/**
 * Person klase glabā pamatinformāciju par personu.
 * Šis objekts satur vārdu, adresi un indeksu.
 */
public class Person {
    // Vārds un uzvārds, kas apraksta personu.
    private String name_surname;
    // Adrese, kur persona dzīvo vai strādā.
    private String adress;
    // Identifikators vai indekss personai.
    private String index;

    /**
     * Izveido Person objektu ar norādītajām īpašībām.
     *
     * @param name_surname personas vārds un uzvārds
     * @param adress personas adrese
     * @param index personas indekss vai identifikators
     */
    public Person(String name_surname, String adress, String index) {
        this.name_surname = name_surname;
        this.adress = adress;
        this.index = index;
    }

    @Override
    public String toString() {
        return name_surname + ", " + adress + ", " + index;
    }

    /**
     * Vienkārša testa metode, kas izveido divus Person objektus un izdrukā tos uz konsoles.
     */
    public static void main(String[] args) {
        Person ada = new Person("Ada Lovelace", "24 Maddox St. London W1S 2QN", "12345");
        Person esko = new Person("Esko Ukkonen", "Mannerheimintie 15 00100 Helsinki", "54321");

        System.out.println(ada);
        System.out.println(esko);
    }
}