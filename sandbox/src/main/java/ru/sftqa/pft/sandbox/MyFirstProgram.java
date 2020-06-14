package ru.sftqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        hello("world");
        hello ("Aleksei");

        double len = 5;
        System.out.println("Площадь квадрата со стороной " + len + " = " + area(len));

        double a = 4;
        double b = 6;
        System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " = " + area(a, b));
    }

    public static void hello(String who) {
        System.out.println("Hey " + who + "! I'm glad to start Java for Automated Testing course!");
    }

    public static double area(double l) {
        return l * l;
    }

    public static double area (double a, double b) {
        return a * b;
    }
}