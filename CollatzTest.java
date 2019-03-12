import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CollatzTest {
  Collatz c1;

  public CollatzTest() {
    this.c1 = new Collatz();
  }

  private void initData() {
    this.c1 = new Collatz();
  }

  @Test
  public void testCollatz() {
    this.initData();
    assertEquals(1, c1.collatz(5));
    assertEquals(1, c1.collatz(3));
    assertEquals(1, c1.collatz(6));
    assertEquals(1, c1.collatz(13));
  }

  //EXAMPLE: 3 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1 count = 8
  //ANOTHER: 5 -> 16 -> 8 -> 4 -> 2 -> 1 count = 6
  @Test
  public void testCollatzCallCount() {
    this.initData();
    assertEquals(8, c1.collatzCallCount(3));
    assertEquals(3, c1.collatzCallCount(4));
    assertEquals(115 , c1.collatzCallCount(2000001));
    //assertEquals(557, c1.collatzCallCount(1723519));
  }

  @Test
  public void testLessSpace() {
    this.initData();
    assertEquals(8, c1.collatzCallsLessSpace(3));
    assertEquals(8, c1.collatzCallsLessSpace(3));
    assertEquals(115, c1.collatzCallsLessSpace(2000001));
    assertEquals(179, c1.collatzCallsLessSpace(871));
    assertEquals(557, c1.collatzCallsLessSpace(1723519));
  }

  @Test
  public void notATestJustAMethod() {
    int trigger = 0;
    int curMax = 0;
    // 113381 int overflow
    // 63728127 : 950 (0 -> 100,000,000)

    // For < 10 mil, 33 seconds run time
    // 8400511 : 686
    for(int i = 1500; i < 100000000; i++) {
      if(i % 1000000 == 0) {
        System.out.println("Computed up to " + i / 1000000 + " million");
      }
      if(c1.collatzCallsLessSpace(i) > curMax) {
        curMax = c1.collatzCallsLessSpace(i);
        trigger = i;
      }
    }
    System.out.println(trigger);
    System.out.println(curMax);
  }
}
