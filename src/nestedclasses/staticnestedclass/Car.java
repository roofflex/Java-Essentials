package nestedclasses.staticnestedclass;


public class Car {
    String color;
    int doorcount;
    Engine engine;

    public Car(String color, int doorcount, Engine engine) {
        this.color = color;
        this.doorcount = doorcount;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "My Car{" +
            "color='" + color + '\'' +
            ", doorcount=" + doorcount +
            ", engine=" + engine +
            '}';
    }

    public static class Engine{
        int horsePower;

        public Engine(int horsePower) {
            this.horsePower = horsePower;
        }

        @Override
        public String toString() {
            return "My Engine{" +
                "horsePower=" + horsePower +
                '}';
        }
    }
}

class Test{
    public static void main(String[] args) {
        Car.Engine engine = new Car.Engine(256);

        System.out.println(engine);
        Car car = new Car("red", 5, engine);
        System.out.println(car);
    }
}
