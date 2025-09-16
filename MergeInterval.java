
import java.util.*;

class MergeInterval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size: ");
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        int[][] result = mergeinterval(arr);
        System.out.print("Intervals: ");
        for(int[] b : result){
            System.out.print("[" + b[0] + " " +b[1] + "] ");
        }
    }

    public static int[][] mergeinterval(int[][] arr){
        if(arr.length <= 1){
            return arr;
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();
        int[] current = arr[0];
        merged.add(current);
        for(int[] arri : arr){
            if(current[1] >= arri[0]){
                current[1] = Math.max(current[1], arri[1]);
            }
            else{
                current = arri;
                merged.add(current);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
