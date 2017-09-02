package io.rmock;

/**
 * Keep it simple, stupid.
 * Created by liangw on 9/5/17.
 */
public class RMockApplication {
    public static void main(String[] args) {
        double a = 10.0;
        double b = 10.0;

        System.out.println(a == b);
        System.out.println(Double.compare(a, b));
    }
}
