public class Strings {
    public static boolean isPalindrome(String str) {
        int n = str.length();
        for(int i=0; i<n/2; i++){
            if(str.charAt(i) != str.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }

    public static float getShortestPath(String path){
        int x= 0 ,y = 0;
        for(int i=0 ; i<path.length(); i++){
            char direction = path.charAt(i);

            if(direction == 'S'){
                y--;
            }else if(direction == 'N'){
                y++;
            }else if(direction == 'W'){
                x--;
            }else{
                x++;
            }
        }
        int X2 = x*x;
        int Y2 = y*y;
        return (float)Math.sqrt(X2 + Y2);
    }

    public static String substring(String str, int si, int ei){ //startinIndex and ending index
        String subStr = "";
        for(int i=si ; i< ei; i++){
            subStr += str.charAt(i);
        }
        return subStr;

    }

    public static String toUpperCase(String str){
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i=1; i<str.length(); i++){
            if(str.charAt(i)== ' ' && i < str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String compressString(String str){
        String newStr = "";

        for(int i=0; i<str.length(); i++){
            Integer count = 1;
            while (i < str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }
            newStr += str.charAt(i);
            if(count > 1){
                newStr += count.toString();
            }
        }
        return newStr;
    }

    public static void main(String[] args){
        // String str = "racecar";
        // System.out.println(isPalindrome(str));

        // String path = "WNEENESENNN";
        // System.out.println(getShortestPath(path));

        // String str = "HelloWolrd";
        // System.out.println(substring(str, 0, 5));


        // String fruits[] = {"apple","mango", "banana", "Orange"};
        // String largest = fruits[0];
        // for(int i=1; i<fruits.length; i++){
        //     if(largest.compareTo(fruits[i]) < 0){
        //         largest = fruits[i];
        //     }
        // }
        // System.out.println(largest);

        // StringBuilder sb = new StringBuilder("");
        // for(char ch='a'; ch<='z'; ch++){
        //     sb.append(ch);
        // }
        // System.out.println(sb);


        // String str = "hi, i am puneeth";
        // System.out.println(toUpperCase(str));

        String str = "aaabbcccddrreer";
        System.out.println(compressString(str));
    }
}
