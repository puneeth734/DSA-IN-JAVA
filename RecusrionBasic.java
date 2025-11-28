public class RecusrionBasic {
    public static void printDec(int n){
        if(n == 1){
            System.out.print(1);
            return;
        }
        System.out.print(n +" ");
        printDec(n-1);
    }

    public static void printInc(int n){
        if(n == 1){
            System.out.println(1);
            return;
        }
        printInc(n-1);
        System.out.println(n +" ");
    }

    public static int factorial(int n){
        if(n == 0){
            return 1;
        }
        int fnm1 = factorial(n-1);
        int fn = n * factorial(n-1);
        return fn;
    }
    public static boolean isSorted(int arr[], int i){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i] > arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }  
    
    public static int firstOccurance(int arr[], int key, int i){
        if(i == arr.length){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
         
        return firstOccurance(arr, key, i+1);
    }

    public static int lastOccurance(int arr[], int key, int i){
        if(i == arr.length){
            return -1;
        }
        int isFound = lastOccurance(arr, key, i+1);
        if(isFound == -1 && arr[i] == key){
            return i;
        }
        return isFound;
    }

    public static int power(int x, int n){
        if(n == 0){
            return 1;
        }
        // int xnm1 = power(x, n-1);
        // int xn = x * xnm1;
        // return xn;

        return x* power(x, n-1);
    }

    public static int optimizedPower(int a, int n){
        if(n == 0){
            return 1;
        }

        // int halfPowerSq = optimizedPower(a, n/2) * optimizedPower(a, n/2);  // O(n)
        int halfPOwer = optimizedPower(a, n/2);
        int halfPowerSq = halfPOwer * halfPOwer;  // O(logn)
        
        // n is odd
        if(n%2 != 0){
            halfPowerSq = a * halfPowerSq;
        }
        return halfPowerSq;
    }

    public static int tilingPrblm(int n){
        //basecase
        if(n==0 || n == 1){
            return 1;
        }
        //choices
        //vertically
        int verticalTile = tilingPrblm(n-1);
        
        //horizontal
        int horizontalTile = tilingPrblm(n-2);
        int totalWays = verticalTile + horizontalTile;
        return totalWays;
    }


    public static void removeDuplicate(String str, int idx, StringBuilder newStr, boolean map[]){
        if(idx == str.length()){
            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(idx);
        if(map[currChar-'a'] == true){
            //duplicate
            removeDuplicate(str, idx+1, newStr, map);
        }else{
            map[currChar - 'a'] = true;
            removeDuplicate(str, idx+1, newStr.append(currChar), map);
        }
    }

    public static int frdPairing(int n){
        if(n == 1 || n == 2){
            return n;
        }
        // // single
        // int fnm1 = frdPairing(n-1);

        // // pair
        // int fnm2 = frdPairing(n-2);
        // int pairWays = (n-1) * fnm2;

        // int totWays = fnm1 + pairWays;
        // return totWays;

        // single line code 
        return frdPairing(n-1) + (n-1) * frdPairing(n-2);
    }

    public static void printBinStrings(int n, int lastPlace, String str){
        if(n == 0){
            System.out.println(str);
            return;
        }
        printBinStrings(n-1,0, str+"0");
        if(lastPlace == 0){
            printBinStrings(n-1, 1, str+"1");
        }
    }
    public static void main(String[] args) {
        int n= 5;
        // printDec(n);
        // printInc(n);
        // System.out.println(factorial(n));
        int arr[] = {1,23,5,6,7,8,5, 8 ,9};
        // System.out.println(isSorted(arr, 0));  //O(n)
        // System.out.println(firstOccurance(arr, 5, 0));  // O(n) 
        // System.out.println(lastOccurance(arr, 5, 0));  // O(n) 
        // System.out.println(power(5, 2));

        int a =2;
        // System.out.println(optimizedPower(a, n));

        // System.out.println(tilingPrblm(n));
        // String str = "appnnacollege";
        // removeDuplicate(str, 0, new StringBuilder(), new boolean[26]);

        // System.out.println(frdPairing(4));

        printBinStrings(3, 0, "");
    }
}
