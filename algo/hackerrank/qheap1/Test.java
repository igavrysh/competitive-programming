import java.util.Arrays;

class Test {
    public static void main(String[] args) {
        Integer[][] a = {{1,2},{2,3},{3,4},{1,3}};
        Arrays.sort(a, (p1, p2) -> p1[0] == p2[0] ? -Integer.compare(p1[1], p2[1]) : Integer.compare(p1[0], p2[0]));

        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }
}