package ru.sftqa.pft.hometask1;

public class DistanceCalculation {

  public static void main(String[] args) {
    Point p1 = new Point(-4, 4);
    Point p2 = new Point(0, 2.5);

    System.out.println("Paccтояние между двумя точками (" + p1.x + "," + p1.y + ") и (" + p2.x + "," + p2.y + ") равно " + distance(p1, p2));
  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt((Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2)));
  }

}
