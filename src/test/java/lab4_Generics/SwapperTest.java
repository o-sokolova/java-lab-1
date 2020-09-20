package lab4_Generics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lab4_Generics.Swapper.*;

public class SwapperTest {

    @Test
    public void swap_test() {
        Integer [] intList = {0, 1, 3, 5, -1, -8, -9, 10};
        List<Integer> list = new ArrayList<>(Arrays.asList(intList));
        Integer [] intListExpected = {10, 1, 3, 5, -1, -8, -9, 0};
        List<Integer> listExpected = new ArrayList<>(Arrays.asList(intListExpected));
        swap(list, 0, 7);
        Assert.assertEquals(listExpected, list);
    }

    @Test
    public void my_get_min_test() {
        Integer [] intList = {0, 1, 3, 5, -1, -8, -9, 10};
        List<Integer> list = new ArrayList<>(Arrays.asList(intList));
        Assert.assertEquals(-9, myGetMin(list, 0, 7).intValue());
        Assert.assertEquals(-8, myGetMin(list, 0, 6).intValue());
        Assert.assertEquals(0, myGetMin(list, 0, 4).intValue());
    }
}