package lambda;

import java.util.ArrayList;
import java.util.function.Supplier;

public class Test3 {
    public static void main(String[] args) {
        ArrayList<Car> cars = createThreeCars(() -> new Car("Nissan", "Red", 2.2 ));
        System.out.println(cars);
    }

    public static ArrayList<Car> createThreeCars(Supplier<Car> carSupplier){
        ArrayList<Car> cars = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            cars.add(carSupplier.get());
        }
        return cars;
    }

}

class Car{
    String model;
    String color;
    double engine;

    public Car(String model, String color, double engine) {
        this.model = model;
        this.color = color;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
            "model='" + model + '\'' +
            ", color='" + color + '\'' +
            ", engine=" + engine +
            '}';
    }
}