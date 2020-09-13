package generics;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(7);
        list.add(1);
        showList(list);
        System.out.println(sumListItems(list));

        // using class and its parent classes as a wildcard
        ArrayList<? super Number> list1 = new ArrayList<>();
    }

    // using wildcard to show list of any elements
    static void showList(List<?> list) {
        System.out.println(list);
    }

    public static double sumListItems(ArrayList<? extends Number> arrayList) {
        double sum = 0;
        for (Number n : arrayList) {
            sum += n.doubleValue();
        }
        return sum;
    }
}
