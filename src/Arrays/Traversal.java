package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Traversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array");
        int size = scanner.nextInt();
        int arr[] = new int[size];
        for (int i =0; i<size; i++){
            System.out.println("Enter elements of Array at index "+i);
            int a = scanner.nextInt();
            arr[i] = a;
        }
        System.out.println(Arrays.toString(arr));
    }
}
