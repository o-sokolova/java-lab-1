public class Min3 {
    public static int min(int a, int b, int c) {
        int min;
        if (a < b) {
            min = a;
        } else {
            min = b;
        }
        if (c < min){
            min = c;
        }
        return min;
    }
}
