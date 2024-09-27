import java.util.List;
import java.util.ArrayList;;
class MyCalendarTwo {
    private List<int[]> events = new ArrayList<>();
    public MyCalendarTwo() {}
    public boolean book(int start, int end) {
        int good = -1; int bad = events.size();
        while (bad-good>1) {
            int m = good + (bad-good)/2;
            int[] e = events.get(m);
            if (start <= e[0]) {
                bad = m;
            } else {
                good = m;
            }
        }
        int start_i = (bad < events.size() && events.get(bad)[0] == start) ? bad : good; 
        for (int i = start_i; i < events.size(); i++) {
            if (i == -1) {
                continue;
            }
            int[] e = events.get(i);
            if (e[0] >= end) {
                break;
            }
            if (e[1] >= 2) {
                return false;
            }
        }
        if (bad < events.size() && events.get(bad)[0] == start) {
            events.get(bad)[1]++;
        } else {
            events.add(bad, new int[]{start, good >= 0 ? events.get(good)[1]+1 : 1 });
        }
        int i = bad+1;
        for (;i < events.size(); i++) {
            int[] e = events.get(i);
            if (e[0] >= end) {
                break;
            }
            e[1]++;
        }
        if (i < events.size() && events.get(i)[0] == end) {
        } else {
            events.add(i, new int[]{end, events.get(i-1)[1]-1});
        }
        return true;
    }
    public static void main(String[] args) {
        test62();
        test12();
        test1();
    }
    public static void test1() {
        boolean passed = true;
        MyCalendarTwo sol = new MyCalendarTwo();
        int[][] bookings = {{10,20},{50,60},{10,40},{5,15},{5,10},{25,55}};
        boolean[] expOutput = {true,true,true,false,true,true};
        for (int i = 0; i < bookings.length; i++) {
            boolean output = sol.book(bookings[i][0], bookings[i][1]);
            passed = passed && (output == expOutput[i]);
            if (!passed) {
                System.out.println("test1 failed on event:" + i);
                break;
            }
        }
        if (passed) {
            System.out.println("test1 passed");
        }
    }
    public static void test12() {
        boolean passed = true;
        MyCalendarTwo sol = new MyCalendarTwo();
        int[][] bookings = {
            {24,40},{43,50},{27,43},
            {5,21},{30,40},{14,29},
            {3,19},{3,14},{25,39},
            {6,19}};
        boolean[] expOutput = {
            true,true,true,
            true,false,false,
            true,false,false,
            false};
        for (int i = 0; i < bookings.length; i++) {
            boolean output = sol.book(bookings[i][0], bookings[i][1]);
            passed = passed && (output == expOutput[i]);
            if (!passed) {
                System.out.println("test12 failed on event:" + i);
                break;
            }
        }
        if (passed) {
            System.out.println("test12 passed");
        }
    }
    public static void test62() {
        boolean passed = true;
        MyCalendarTwo sol = new MyCalendarTwo();
        int[][] bookings = {
            {36,41},{28,34},{40,46},
            {10,18},{4,11},{25,34},
            {36,44},{32,40},{34,39},
            {40,49}};
        boolean[] expOutput = {
            true,true,true,
            true,true,true,
            false,false,true,
            false
        };
        for (int i = 0; i < bookings.length; i++) {
            boolean output = sol.book(bookings[i][0], bookings[i][1]);
            passed = passed && (output == expOutput[i]);
            if (!passed) {
                System.out.println("test62 failed on event:" + i);
                break;
            }
        }
        if (passed) {
            System.out.println("test62 passed");
        }
    }
}
