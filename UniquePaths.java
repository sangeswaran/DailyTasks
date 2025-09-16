import java.util.Scanner;

class UniquePaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println("Possible: " + uniquePath(m, n));
        sc.close();
    }

    public static int uniquePath(int m, int n){
        long res = 1;
        int a = m + n - 2;
        int b = Math.min(m-1, n-1);
        for(int i=1; i<=b; i++){
            res = res * (a - b + i) / i;
        }
        return (int)res;
    }
}
