package rvt.Meals;

import java.util.ArrayList;

/**
 * Menu klase nodrošina ēdienu saraksta pārvaldību.
 * Šī klase ļauj pievienot ēdienus, izdrukāt pašreizējo izvēli un notīrīt visu saturu.
 */
public class Menu {
    /**
     * Dinamisks saraksts, kas satur ēdienu nosaukumus.
     * ArrayList ļauj ēdienus pievienot un noņemt bez fiksēta izmēra ierobežojuma.
     */
    private ArrayList<String> meals;

    /**
     * Izveido jaunu Menu objektu ar tukšu ēdienu sarakstu.
     * Konstruktorā tiek inicializēta iekšējā kolekcija.
     */
    public Menu() {
        this.meals = new ArrayList<>();
    }

    /**
     * Pievieno jaunu ēdienu sarakstam.
     *
     * @param meal ēdiena nosaukums, kas jāiekļauj menu sarakstā
     */
    public void addMeal(String meal) {
        // Jauns ēdiens tiek pievienots saraksta beigās.
        this.meals.add(meal);
    }

    /**
     * Izdrukā pašreizējo ēdienu sarakstu uz konsoles.
     * Tiek izmantots ArrayList toString formāts.
     */
    public void printMeals() {
        System.out.println(meals);
    }

    /**
     * Notīra visu menu saturu, atstājot tukšu ēdienu sarakstu.
     */
    public void clearMenu() {
        this.meals.clear();
    }

    /**
     * Demonstrācijas programma, kas parāda Menu klases izmantošanu.
     * Tiek izveidots objekts, pievienoti ēdieni, izdrukāts saraksts, notīrīts un
     * pēc tam papildināts ar jaunu ēdienu.
     */
    /**
     * Demonstrācijas programma, kas parāda Menu klases izmantošanu.
     * Tiek izveidots objekts, pievienoti ēdieni, izdrukāts saraksts, notīrīts un
     * pēc tam papildināts ar jaunu ēdienu.
     */
    public static void main(String[] args) {
        // Izveido jaunu Menu objektu, kas saturēs ēdienu nosaukumus.
        Menu menu = new Menu();

        // Pievieno vairākus ēdienus sarakstam.
        menu.addMeal("Tofu ratatouille");
        menu.addMeal("Chilli coconut chicken");
        menu.addMeal("Chilli coconut chicken");
        menu.addMeal("Meatballs with mustard sauce");

        // Izdrukā pašreizējo ēdienu sarakstu uz konsoles.
        menu.printMeals();

        // Notīra visu sarakstu, atstājot tukšu menu.
        menu.clearMenu();

        // Atstāj tukšu rindiņu konsolē, lai mainīgo stāvokļu izdrukas būtu vieglāk saskatāmas.
        System.out.println();

        // Pievieno jaunu ēdienu pēc saraksta iztukšošanas.
        menu.addMeal("Tomato and mozzarella salad");

        // Izdrukā atjaunoto sarakstu, kurā tagad ir tikai viens ēdiens.
        menu.printMeals();
    }
}