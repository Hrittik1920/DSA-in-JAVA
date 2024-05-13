abstract class Shape {
    abstract double area();
    abstract double perimeter();
    abstract String colour();
    abstract void compareTo(Shape op);
}

class Triangle extends Shape {
    int b,p,h,ht;
    String colour;

    public Triangle(int base,int perpendicular,int hypotenuse,int height,String colour) {
        this.b = base;
        this.p = perpendicular;
        this.h = hypotenuse;
        this.ht = height;
        this.colour = colour;
    }

    public double area() {
        return (b*ht)/2;
    }

    double perimeter() {
        return (b + p + h);
    }

    String colour() {
        return this.colour;
    }

    void compareTo(Shape op) {
        if(this.area() == op.area()  &&  this.perimeter() == op.perimeter()) {
            System.out.println("Maching Triangles");
        } else {
            System.out.println("Not matching Triangles");
        }
    }
}
class Rectangle extends Shape {
    int l,w;
    String colour;

    public Rectangle(int lenght,int width,String colour) {
        this.l = lenght;
        this.w = width;
        this.colour = colour;
    }

    double area() {
        return l*w;
    }

    double perimeter() {
        return 2*(l + w);
    }

    String colour() {
        return this.colour;
    }

    void compareTo(Shape op) {
        if(this.area() == op.area()  &&  this.perimeter() == op.perimeter()) {
            System.out.println("Maching Rectangles");
        } else {
            System.out.println("Not matching Rectangles");
        }
    }
}
class Circle extends Shape {
    int r;
    String colour;

    public Circle(int radius,String colour) {
        this.r = radius;
        this.colour = colour;
    }

    double area() {
        return (1/2)*Math.PI*r;
    }

    double perimeter() {
        return 2*Math.PI*r;
    }

    String colour() {
        return this.colour;
    }

    void compareTo(Shape op) {
        if(this.area() == op.area()  &&  this.perimeter() == op.perimeter()) {
            System.out.println("Maching Circles");
        } else {
            System.out.println("Not matching Circles");
        }
    }
}

public class AbstarctionConcept {
    public static void main(String[] args) {
        Shape s1,s2;
        s1 = new Triangle(3, 3, 3, 4,"white");
        s2 = new Triangle(3, 3, 2, 4,"black");
        s1.compareTo(s2);
        s1 = new Rectangle(3, 4, "red");
        s2 = new Rectangle(3, 4, "green");
        s1.compareTo(s2);
        s1 = new Circle(5, "brown");
        s2 = new Circle(4, "pink");
        s1.compareTo(s2);
    }
}
