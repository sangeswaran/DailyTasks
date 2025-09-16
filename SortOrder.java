
import java.util.*;

class SortOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("original array: ");
        printarr(arr);
        System.out.println("Sorted Array: ");
        rearrange(arr);
        printarr(arr);
        sc.close();
    }

    public static void printarr(int[] arr){
        for(int n : arr){
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void rearrange(int[] arr){
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();
        for(int num : arr){
            if(num%2 == 0){
                evens.add(num);
            }
            else{
                odds.add(num);
            }
        }
        Collections.sort(evens);
        odds.sort(Collections.reverseOrder());
        int even = 0;
        int odd = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]%2 == 0){
                arr[i] = evens.get(even++);
            }
            else{
                arr[i] = odds.get(odd++);
            }
        }
    }
}
