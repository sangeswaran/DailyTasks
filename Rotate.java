import java.util.Scanner;


class Rotate{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("original matrix: ");
        printMatrix(arr);
        System.out.println("Rotated matrix: ");
        rotate(arr);
        printMatrix(arr);
        sc.close();
    }
    public static void printMatrix(int[][] arr){
        for(int[] a : arr){
            for(int n : a){
                System.out.print(n+" ");
            }
            System.out.println();
        }
    }
    public static void rotate(int[][] arr){
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        for(int i=0; i<n; i++){
            int left = 0;
            int right = n-1;
            while(left < right){
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}