public class Hashing {
    int keys[];
    int values[];
    int capacity;
    Hashing(int size){
        this.capacity = size;
        keys = new int[capacity];
        values = new int[capacity];

        for (int i = 0; i<capacity; i++){
            keys[i] = -1;
            values[i] = -1;
        }
    }
    public void insert(int key, int value) {
        int temp = key % 10;
        int i = temp;
        if (keys[i] == -1) {
            keys[i] = key;
            values[i] = value;
        } else if (keys[i] == key) {
            values[i] = value;
        }
        else {
            do {
                i = (i+1)%10;
                if (keys[i] == -1){
                    keys[i] = key;
                    values[i] = value;
                    break;
                }
            }while (i!=temp);
        }
    }
    public int get(int key){
        int temp = key%10;
        while (keys[temp] != -1){
            if (keys[temp] == key){
                return values[temp];
            }
            temp = (temp+1)%10;
        }
        return -1;
    }
}
