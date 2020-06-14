package ru.sftqa.pft.hometask1;

public class DistanceCalculation {

  public static void main(String[] args) {
    Point p1 = new Point(-4, 4);
    Point p2 = new Point(0, 2.5);

    System.out.println("Paccтояние между двумя точками (" + p1.x + "," + p1.y + ") и (" + p2.x + "," + p2.y + ") равно " + p1.distance(p2));
  }


}
