package ru.sftqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sftqa.pft.hometask1.Point;

public class PointTests {
  @Test
  public void zeroValuesTest() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(0, 0);

    Assert.assertEquals(p1.distance(p2), 0);
  }

  @Test
  public void negativeValuesTest() {
    Point p1 = new Point(-3, 2);
    Point p2 = new Point(1, -1);

    Assert.assertEquals(p1.distance(p2), 5);

  }

  @Test
  public void zeroDistanceTest() {
    Point p1 = new Point(15.5, 20.7);
    Point p2 = new Point(15.5, 20.7);

    Assert.assertEquals(p1.distance(p2), 0);
  }

  @Test
  public void fractionalValuesTest() {
    Point p1 = new Point(-13.675, 45.768);
    Point p2 = new Point(8.134, -2.53);

    Assert.assertEquals(p1.distance(p2), 52.99367212224494);
  }
}
