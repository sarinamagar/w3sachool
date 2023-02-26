package DsaCoursework;

public class InsertionSorted {

    public static int[] insertion(int[] arr, int element, int size){
        int n = arr.length;
        if (size>n){
            System.out.println("Elements overflow");
        }
        int i;
        for ( i = size-1; (i>=0 && arr[i]>element); i--){
            arr[i+1] = arr[i];
        }
        arr[i+1] = element;
        size++;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        arr[0] = 3;
        arr[1] = 6;
        arr[2] = 9;
        arr[3] = 12;
        arr[4] = 18;
        int size = 5;
        int element = 22;
    }
}
