// import java.util.LinkedList;
// import java.util.Queue;
import java.util.*;


public class Classroom {
    // public static boolean checkKthDuplicate(int arr[] , int k ){
    //     for(int i=0; i< arr.length; i++){
    //         for(int j=i+1; j< arr.length && j<= i+k ; j++){
    //             if(arr[i] == arr[j]){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    // public static void printNonRepeating(String str){
    //     int freq[] = new int[26];
    //     Queue<Character> q = new LinkedList<>();

    //     for(int i=0; i<str.length(); i++){
    //         char ch = str.charAt(i);
    //         q.add(ch);
    //         freq[ch-'a']++;

    //         while (!q.isEmpty() && freq[q.peek()-'a'] > 1) {
    //             q.remove();
    //         }

    //         if(q.isEmpty()){
    //             System.out.print(-1 +" ");
    //         }else{
    //             System.out.print(q.peek()+" ");
    //         }
    //     }
    //     System.out.println();
    // }

    //     public static void interLeave(Queue<Integer> q ) {
    //         Queue<Integer> firstHalf = new LinkedList<>();
    //         int size = q.size();

    //         for(int i=0; i<size/2; i++){
    //             firstHalf.add(q.remove());
    //         }

    //         while (!firstHalf.isEmpty()) {
    //             q.add(firstHalf.remove());
    //             q.add(q.remove());
    //         }
    //     }

    //     public static void queueReverse(Queue<Integer> q){
    //         Stack<Integer> s = new Stack<>();
    //         while (!q.isEmpty()) {
    //             s.push(q.remove());
    //         }

    //         while (!s.isEmpty()) {
    //             q.add(s.pop()); 
    //         }
    //     }

    public static boolean isAnagram(String s, String t){ //O(n)
        //base caase
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character , Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) +1);
        }

        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            if(map.get(ch) != null){
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch) -1);
                }
            }else{
                return false; 
            }
        }
        return map.isEmpty();
    }

    public static String getStart(HashMap<String, String> tickets){
        HashMap<String, String> revMap = new HashMap<>();

        for(String key : tickets.keySet()){
            revMap.put(tickets.get(key), key); 
        }

        for (String key : tickets.keySet()) {
            if(!revMap.containsKey(key)){
                return key;
            }
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        // int arr[] = {1, 2, 3, 6, 4, 5};
        // System.out.println(checkKthDuplicate(arr, 3 ));

        // String str =  "aabccxb";
        // printNonRepeating(str);
         
        // Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // q.add(6);
        // q.add(7);
        // q.add(8);
        // q.add(9);
        // q.add(10);

        // interLeave(q);

        // while (!q.isEmpty()) {
        //     System.out.print(q.remove() + " ");
        // }
        // System.out.println();

        // Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);

        // queueReverse(q);
        // while (!q.isEmpty()) {
        //     System.out.print(q.remove() + " ");
        // }
        // System.out.println();

        // int arr[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        // HashMap<Integer, Integer> map = new HashMap<>();


        // for(int i=0; i<arr.length; i++){
            // if(map.containsKey(arr[i])){
            //     map.put(arr[i], map.get(arr[i] +1));
            // }else{
            //     map.put(arr[i], 0);
            // }

            //optimized in code
        //     map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        // }

        // Set<Integer> keySet = map.keySet();
        //optimized code above code ke badle
        // for (Integer key : map.keySet()) {
        //     if (map.get(key) > arr.length / 3) {
        //         System.out.println(key);
        //     }
        // }

        // String s="tulip";
        // String t = "lipid";
        // System.out.println(isAnagram(s, t));

        // HashMap<String, String> tickets = new HashMap<>();
        // tickets.put("Chennai", "Bengalore");
        // tickets.put("Mumbai", "Delhi");
        // tickets.put("Gao", "Chennai");
        // tickets.put("Delhi", "Goa");

        // String start = getStart(tickets);
        // System.out.print(start);

        // for (String key : tickets.keySet()) {
        //     System.out.print(" -> " +tickets.get(start));
        //     start = tickets.get(start);
        // }

        // System.out.println();
        // int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};

        // HashMap<Integer, Integer> map = new HashMap<>();
        // int sum = 0;
        // int len = 0;

        // for(int j=0; j<arr.length; j++){
        //     sum += arr[j];
        //     if(map.containsKey(sum)){
        //         len = Math.max(len, j-map.get(sum));
        //     }else{
        //         map.put(sum, j);
        //     }
        // }
        // System.out.println("Largest subarray sum as 0 is: "+ len);

        int arr[] = {10, 2, -2, -20, 10};
        int k = -10;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int sum = 0;
        int ans = 0;
        for(int j=0; j<arr.length;j++){
            sum += arr[j]; //sum(j)
            if(map.containsKey(sum-k)){
                ans += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum, 0)+1);
        }
        System.out.println("Ans is: " + ans);
    }
}
