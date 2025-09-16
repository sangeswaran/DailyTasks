
import java.util.Scanner;

class CompareVersion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(comparever(s1, s2));
        sc.close();
    }
    static int comparever(String s1, String s2){
        String[] v1 = s1.split("\\.");
        String[] v2 = s2.split("\\.");
        int n = Math.max(v1.length, v2.length);
        for(int i=0; i<n; i++){
            int n1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int n2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if(n1 > n2){
                return 1;
            }
            if(n1 < n2){
                return -1;
            }
        }
        return 0;
    }
}
