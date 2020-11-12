package nestedclasses.innerclass;


public class Car {
    String color;
    int doorcount;
    Engine engine;

    public Car(String color, int doorcount, int horsePower) {
        this.color = color;
        this.doorcount = doorcount;
        this.engine = this.new Engine(horsePower);
    }

    @Override
    public String toString() {
        return "My Car{" +
            "color='" + color + '\'' +
            ", doorcount=" + doorcount +
            ", engine=" + engine +
            '}';
    }

    public class Engine{
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
        Car car = new Car("black", 5, 300);
        System.out.println(car);
    }
}