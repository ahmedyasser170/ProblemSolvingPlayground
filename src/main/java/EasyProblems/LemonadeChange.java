package EasyProblems;

public class LemonadeChange {

  public static void main(String[] args) {
    int[] bills = {5,5,10,10,20};

    System.out.println(lemonadeChange(bills));
  }
  public static boolean lemonadeChange(int[] bills) {
    int[] currencyCount = new int[3];
    for (int i = 0; i < bills.length; i++) {
      if (bills[i] == 5) {
        currencyCount[0]++;
      } else if (bills[i] == 10) {
        if (currencyCount[0] == 0)
          return false;

        currencyCount[0]--;
        currencyCount[1]++;
      } else if (bills[i] == 20) {
        if ((currencyCount[1] == 0 && currencyCount[0] <= 2)
            || currencyCount[0] == 0)
          return false;
        else if (currencyCount[1]>0) {
          currencyCount[1]--;
          currencyCount[0]--;
          currencyCount[2]++;
        } else {
          currencyCount[0] -= 3;
          currencyCount[2]++;
        }
      }
    }
    return true;
  }

}
