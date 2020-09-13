package generics;

public class ParameterizedClass {
    public static void main(String[] args) {


        Info<String> info1 = new Info<>("Hello");
        System.out.println(info1.toString());

        Info<Integer> info2 = new Info<>(22);
        Integer i1 = info2.getValue();
        System.out.println(info2.toString());
        System.out.println(info2.getValue());

    }

}

class Info<T> {
    private T value;

    public Info(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Info{" +
            "value=" + value +
            '}';
    }

    public T getValue() {
        return value;
    }
}
