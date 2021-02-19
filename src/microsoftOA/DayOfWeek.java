package microsoftOA;

import java.util.ArrayList;
import java.util.List;

/**
 * store the days of the week in an arrayList()
 * get the index of the given day+ K, use a mod operator to keep the range in 0-7 days;
 */
public class DayOfWeek {
    public static String dayOfWeek(String day, int k) {

        List<String> days = new ArrayList<String>() {
            {
                add("Monday");
                add("Tuesday");
                add("Wednesday");
                add("Thursday");
                add("Friday");
                add("Saturday");
                add("Sunday");
            }
        };
        int index = days.indexOf(day);
        return days.get((index + k) % 7);
    }
}
