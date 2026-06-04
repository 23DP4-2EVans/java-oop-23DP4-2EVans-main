package rvt.Cars;

import java.util.ArrayList;

class Car {
    String brand;
    String model;
    int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    public String toString() {
        return this.brand + ", " + this.model + ", " + this.year;
    }
}

class Garage {
    private int number;
    private ArrayList<Car> cars = new ArrayList<>();

    public Garage(int number) {
        this.number = number;
    }

    public void addCar(Car car) {
        cars.add(car);

    }

    public void showAll() {
        System.out.println(cars);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public static void main(String[] args) {
        Garage garage1 = new Garage(1);
        garage1.addCar(new Car("BMW", null, 0));
        garage1.addCar(new Car("Mazda", null, 0));
        garage1.addCar(new Car("Opel", null, 0));

        garage1.showAll();
    }
}
