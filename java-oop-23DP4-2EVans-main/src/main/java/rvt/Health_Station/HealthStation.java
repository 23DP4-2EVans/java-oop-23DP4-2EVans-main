package rvt.Health_Station;

/**
 * HealthStation klase var izmērīt personas svaru, barot personu un uzskaitīt svēršanas reižu skaitu.
 * Person klase tiek definēta vienā failā ar HealthStation, lai nebūtu jāimportē Person no citas mapes.
 */
public class HealthStation {

    // Skaitītājs, kas reģistrē, cik reizes HealthStation ir veikusi svēršanu.
    private int weighings;

    public HealthStation() {
        this.weighings = 0;
    }

    /**
     * Svēr personu un palielina svēršanas skaitītāju.
     *
     * @param person persona, kuras svaru mēra
     * @return personas svars kilogramos
     */
    public int weigh(Person person) {
        this.weighings++;
        return person.getWeight();
    }

    /**
     * Baro personu, palielinot tās svaru par viena kilograma.
     *
     * @param person persona, kuras svars tiek palielināts
     */
    public void feed(Person person) {
        person.setWeight(person.getWeight() + 1);
    }

    /**
     * Atgriež kopējo svēršanu skaitu, ko veicis HealthStation objekts.
     *
     * @return svēršanu skaits
     */
    public int weighings() {
        return this.weighings;
    }

    public static void main(String[] args) {
        HealthStation childrensHospital = new HealthStation();

        Person ethan = new Person("Ethan", 1, 110, 7);
        Person peter = new Person("Peter", 33, 176, 85);

        System.out.println(ethan.getName() + " weight: " + childrensHospital.weigh(ethan) + " kilos");
        System.out.println(peter.getName() + " weight: " + childrensHospital.weigh(peter) + " kilos");

        childrensHospital.feed(ethan);
        childrensHospital.feed(ethan);
        childrensHospital.feed(ethan);

        System.out.println("");

        System.out.println(ethan.getName() + " weight: " + childrensHospital.weigh(ethan) + " kilos");
        System.out.println(peter.getName() + " weight: " + childrensHospital.weigh(peter) + " kilos");
    }
}

/**
 * Person klase glabā personas vārdu, vecumu, augumu un svaru.
 * Tā atrodas tajā pašā pakotnē kā HealthStation un nav nepieciešams imports.
 */
class Person {
    private String name;
    private int age;
    private int height;
    private int weight;

    public Person(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.age + " years, " + this.height + " cm, " + this.weight + " kg)";
    }
}
