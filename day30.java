import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {
    private HashMap<Integer,Integer> map;
    private ArrayList<Integer> arr;
    private Random random;
    public RandomizedSet() {
        map = new HashMap<>();
        arr = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        } 
        else{
            arr.add(val);
            map.put(val,arr.size()-1);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int idx = map.get(val);
        int lastElement = arr.get(arr.size() - 1);
        arr.set(idx, lastElement);
        map.put(lastElement, idx);
        arr.remove(arr.size() - 1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int idx = random.nextInt(arr.size());
        return arr.get(idx);
    }
}

public class day30 {
   public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(20);
    arr.add(30);
    arr.add(5);
    arr.remove(arr.size()-1);
    System.out.println(arr);
    arr.remove(0);
   } 
}
