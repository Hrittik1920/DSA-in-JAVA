import java.util.*;
interface A {
    int eye = 2;
    public int man();
}

interface B {
    int legs = 4;
    public int name();
}

class C implements A, B {
    int legs = 3;
    @Override
    public int man() {
        System.out.println("Man");
        return -1;
    }

    @Override
    public int name() {
        System.out.println("Nmae");
        return -1;
    }
}

public class AATest {
    static int sum(int a, int b) {
        return a+b;
    }
    static int sum(int t, int y) {
        return t+y;
    }
    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.legs);
        System.out.println(c.eye);
        System.out.println(c.man());
        // System.out.println(c.name());
        System.out.println(sum(5, 6));
        sum(4, 5);
    }
}
    

