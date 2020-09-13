package generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class ParameterizedMethod {
    public static void main(String[] args) {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(5);
        integerList.add(7);

        int i = GenMethod.getSecondElement(integerList);

        System.out.println(i);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("Abd");
        strings.add("Htf");
        strings.add("xwax");

        System.out.println(GenMethod.getSecondElement(strings));

        System.out.println(GenMethod.getSecondNumber(integerList));
    }
}


class GenMethod {

    public static <T> T getSecondElement(ArrayList<T> list) {
        return list.get(1);
    }

    public static <T extends Number> T getSecondNumber(ArrayList<T> list) {
        return list.get(1);
    }

    // if we want generics to be of type that implements some interface, this is the signature
    public static <T extends Collections & Serializable> void getCollection(T collection) {
    }
    // ^^^ Generic type extends Collection, implements Serializable
}