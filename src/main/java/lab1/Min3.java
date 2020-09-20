package lab1;

public class Min3 {
    public static int min(int a, int b, int c) {
        if (b < a) {
            a = b;
        }
        if (c < a){
            a = c;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(min(-1, -2, -3));
    }
}
