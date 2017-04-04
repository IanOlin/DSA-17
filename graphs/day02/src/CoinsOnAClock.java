import java.util.ArrayList;
import java.util.List;

public class CoinsOnAClock {

    public static List<char[]> coinsOnAClock(int pennies, int nickels, int dimes, int hoursInDay) {
        return coinsHelper(pennies, nickels, dimes, hoursInDay, 0, new char[hoursInDay], new ArrayList<>());
    }

    public static List<char[]> coinsHelper(int pennies, int nickels, int dimes, int hoursInDay, int currentHour, char[] currentClock, List<char[]> history){
        if (pennies + nickels + dimes == 0){
            history.add(currentClock.clone());
            return history;
        }
        // if wrong
        else if (currentClock[currentHour] == 'p' || currentClock[currentHour] == 'n' || currentClock[currentHour] == 'd') {
            return history;
        }

        if (pennies > 0) {
            currentClock[currentHour] = 'p';
            coinsHelper(pennies-1, nickels, dimes, hoursInDay, (currentHour+1)%hoursInDay, currentClock, history);
            currentClock[currentHour] = ' ';
        }
        if (nickels > 0) {
            currentClock[currentHour] = 'n';
            coinsHelper(pennies, nickels-1, dimes, hoursInDay, (currentHour+5)%hoursInDay, currentClock, history);
            currentClock[currentHour] = ' ';
        }
        if (dimes > 0) {
            currentClock[currentHour] = 'd';
            coinsHelper(pennies, nickels, dimes-1, hoursInDay, (currentHour+10)%hoursInDay, currentClock, history);
            currentClock[currentHour] = ' ';
        }

        return history;
    }
}
