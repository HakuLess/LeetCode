package leetcode.contest.last.e00;

public class V2 {
    public static void main(String[] args) {
        V2 v2 = new V2();
        int[] a = {3, 2, 0, 2};
        v2.fraction(a);
    }

    public int[] fraction(int[] cont) {
        //Stack<Integer> s = new Stack<>();
        int n = cont.length;
        int[] r = {1, cont[n - 1]};
        for (int i = n - 2; i >= 0; i--) {
            int a = cont[i] * r[1] + r[0];
            int b = r[1];
            r[0] = b;
            r[1] = a;
        }
        int t = r[0];
        r[0] = r[1];
        r[1] = t;
        return r;
    }

//    public int[] fraction(int[] cont) {
//        for (int i : cont) {
//            System.out.print(i + ", ");
//        }
//        System.out.println();
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i : cont) {
//            list.add(i);
//        }
//
//        int a = list.get(list.size() - 1);
//        int b = list.get(list.size() - 2);
//
//        int bottom = b * a + 1;
//        int top = a;
//
//        for (int i = list.size() - 3; i >= 0; i--) {
//            System.out.println(bottom + " " + top);
//            int t = list.get(i);
//            int temp = bottom;
//            bottom = t * bottom + top;
//            top = temp;
//            System.out.println(bottom + " " + top);
//        }
//        int gcd = gcd(bottom, top);
//        int[] ans = {bottom / gcd, top / gcd};
//        return ans;
//    }
//
//    private int gcd(int p1, int p2) {
//        int n1 = p1;
//        int n2 = p2;
//        while (n1 != n2) {
//            if (n1 > n2)
//                n1 -= n2;
//            else
//                n2 -= n1;
//        }
//        return n1;
//    }
}
