import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

class MKAverage {

    Queue<Integer> q;
    TreeMap<Integer, Integer> top;
    TreeMap<Integer, Integer> bottom;
    TreeMap<Integer, Integer> middle;
    int topSize = 0;
    int bottomSize = 0;
    int middleSize = 0;
    int middleSum = 0;
    int m;
    int k;

    public MKAverage(int m, int k) {
        q = new LinkedList<>();
        top = new TreeMap<>();
        middle = new TreeMap<>();
        bottom = new TreeMap<>();
        this.m = m;
        this.k = k;
        middleSum = 0;
    }

    private void removeFromTreeMap(int num, TreeMap<Integer, Integer> tm) {
        int fq = tm.get(num);
        if (fq == 1) {
            tm.remove(num);
        } else {
            tm.put(num, fq-1);
        }
    }
    
    public void addElement(int num) {
        if (q.size() == m) {
            int rem = q.poll();
            if (top.containsKey(rem)) {
                removeFromTreeMap(rem, top);
                topSize--;
            } else if (middle.containsKey(rem)) {
                removeFromTreeMap(rem, middle);
                middleSum -= rem;
                middleSize--;
            } else if (bottom.containsKey(rem)) {
                removeFromTreeMap(rem, bottom);
                bottomSize--;
            }
        }

        q.offer(num);

        middle.put(num, middle.getOrDefault(num, 1));
        middleSize++;
        middleSum += num;
        if (middleSize > m-2*k) {
            if (topSize < k) {
                Integer carry = middle.firstKey();
                removeFromTreeMap(carry, middle);
                middleSize--;
                middleSum -= carry;

                top.put(carry, top.getOrDefault(carry, 1));
                topSize++;            
            } else if (bottomSize < k) {
                Integer carry = middle.lastKey();
                removeFromTreeMap(carry, middle);
                middleSize--;
                middleSum -= carry;

                bottom.put(carry, bottom.getOrDefault(carry, 1));
                bottomSize++;  
            }
            
        }
    }
    
    public int calculateMKAverage() {
        return q.size() == m ? middleSum / (m - 2*k) : -1;
    }

    public static void main(String[] args) {
        test2();
        test1();
    }

    public static void test1() {
        boolean passed = true;
        MKAverage mk = new MKAverage(3, 1);
        mk.addElement(3);
        mk.addElement(1);
        passed &= mk.calculateMKAverage() == -1;
        mk.addElement(10);
        passed &= mk.calculateMKAverage() == 3;
        mk.addElement(5);
        mk.addElement(5);
        passed &= mk.calculateMKAverage() == 5;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        boolean passed = true;
        MKAverage mk = new MKAverage(3, 1);
        mk.addElement(58378);
        mk.addElement(34909);
        passed &= mk.calculateMKAverage() == -1;
        mk.addElement(94574);
        mk.addElement(29985);
        passed &= mk.calculateMKAverage() == 34909;
        mk.addElement(77484);
        mk.addElement(13400);
        passed &= mk.calculateMKAverage() == 29985;
        mk.addElement(41607);
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }
}