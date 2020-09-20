package lab4_Generics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Swapper {
    public static <T> void swap(List<T> list, int index1, int index2) {
       T element = list.get(index2);
       list.add(index2, list.get(index1));
       list.remove(index2 + 1);
       list.add(index1, element);
       list.remove(index1 + 1);
    }

    public static <T extends Comparable<T>> T myGetMin(List<T> list, int begin, int end) {
        int indexOfMin = begin;
        for (int i = begin + 1; i < end; i++) {
            if (list.get(indexOfMin).compareTo(list.get(i)) > 0) {
                indexOfMin = i;
            }
        }
        return list.get(indexOfMin);
    }

    public static void main(String[] args) {
        Integer [] intList = {0, 1, 3, 5, -1, -8, -9, 10};
        List<Integer> list = new ArrayList<>(Arrays.asList(intList));
        swap(list, 1, 2);
        System.out.println(list.toString());
        System.out.println(myGetMin(list, 0, 7));
    }
}
