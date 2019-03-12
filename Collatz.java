import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Collatz {

  public Collatz(){
    this.results.put(0, 0);
    this.results.put(1, 1);
    this.callCounts.put(0, 1);
    this.callCounts.put(1, 1);
  }


  public static void main(String[] args) {
    Collatz c = new Collatz();
    System.out.println(c.collatz(5));
    System.out.println(c.collatz(4000));

    System.out.println(c.collatzCallCount(3));
    System.out.println(c.collatzCallCount(5));
  }
  /**
   * @param n
   * @return
   */
  HashMap<Integer, Integer> results = new HashMap<>();

  public int collatz(int n) {
    if(results.get(n) != null) {
      return results.get(n);
    }
    else {
      if ((n & 1) == 0) {
        results.put(n, collatz(n / 2));
        return results.get(n);
      } else {
        results.put(n, collatz(1 + (n * 3)));
        return results.get(n);
      }
    }
  }

  /**
   * Non-recursive so it uses less stack, but also lost dynamic programming speed.
   * @param num the target number
   * @return the number of calls
   */
  public int collatzCallsLessSpace(int num) {
    long n = num;
    int count = 1;
    while(!((n == 0) || (n == 1))) {
      if(callCounts.get(n) != null) {
        count += callCounts.get(n);
        break;
      }
      else {
        if((n & 1) == 0) {
          count++;
          n = (n/2);
        }
        else {
          count++;
          n = (1 + (n * 3));
        }
      }
    }
    this.callCounts.put(num, count);
    return count;
  }


  //EXAMPLE: 3 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1 count = 8
  //ANOTHER: 5 -> 16 -> 8 -> 4 -> 2 -> 1 count = 6
  HashMap<Integer, Integer> callCounts = new HashMap<>();

  /**
   * Counts the number of recursive calls while computing a collatz number.
   * @param n
   * @return
   */
  public int collatzCallCount(int n) {
    if(callCounts.get(n) != null) {
      return callCounts.get(n);
    }
    else {
      if ((n & 1) == 0) {
        callCounts.put(n, 1 + collatzCallCount(n / 2));
        return callCounts.get(n);
      } else {
        callCounts.put(n, 1 + collatzCallCount(1 + (n * 3)));
        return callCounts.get(n);
      }
    }
  }
}
