import java.util.*;

public class Array {

    public static void update(int marks[],int nonChange){
        nonChange = 10;
        for(int i=0; i<marks.length; i++){
            marks[i] = marks[i] + 1;
        }
    }


    public static int linearSearch(int numbers[],int key){

        for(int i=0; i<numbers.length; i++){
            
            if(numbers[i] == key){
                return i;
            }
        }
        return -1;
    }

    public static int linearSearch2(String fruits[],String fKey){

        for(int i=0; i<fruits.length; i++){
            
            if(fruits[i] == fKey){
                return i;
            }
        }
        return -1;
    }


    public static  int getLargest(int numbers[]){
        int largest = Integer.MIN_VALUE;   // -infinity
        int smallest = Integer.MAX_VALUE;  // +infinity

        for(int i=0; i<numbers.length;i++){
            if(largest < numbers[i]){
                largest = numbers[i];
            }
            if(smallest > numbers[i]){
                smallest = numbers[i];
            }
        }
        System.out.println("Smallest value is: "+ smallest);
        return largest;
    }


    public static int binarySearch(int numbers[],int key){
        int start = 0;
        int end = numbers.length-1;

        while(start <= end){
            int mid = (start + end)/2;

            if(numbers[mid] == key){
                return mid;
            }
            if(numbers[mid] < key){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }

    public static int reverse(int numbers[]){
        int first = 0;
        int last = numbers.length-1;

        while(first < last){

            int temp = numbers[first];
            numbers[first] = numbers[last];
            numbers[last] = temp;

            first++;
            last--;
        }
        return 0;
    }


    public static void printPairs(int numbers[]){
        
        int total_pair = 0;
        for(int i=0; i<numbers.length; i++){
            int current = numbers[i];
            for(int j=i+1;j<numbers.length; j++){
                System.out.print("("+ current +","+ numbers[j]+") ");
                total_pair++;
            }
            System.out.println();
        }
        System.out.println("Total pairs:"+total_pair);
    }


    public static void printSubarray(int numbers[]){
        int total_SA = 0;
        for(int i=0;i<numbers.length; i++){
            int start = i;
            for(int j=i; j<numbers.length; j++){
                int end = j;
                for(int k=start; k<=end; k++){
                    System.out.print(numbers[k]+" ");
                }
                total_SA++;
            System.out.println();
            }
        System.out.println();
        }
        System.out.println("Total SubArray: " + total_SA);
    }

    public static void printSubArraySum(int numbers[]){
       
        for(int i=0; i<numbers.length; i++){
            int start = i;
            for(int j=i; j<numbers.length; j++){
                int end = j;
                int sum = 0; 
                for(int k=start; k<= end; k++){
                    sum = sum + numbers[k];
                } 
                System.out.print("sum:"+ sum);
                System.out.println();
            }
        System.out.println();
        }
    }


    public static void maxSubarraySum(int numbers[]){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0;i<numbers.length; i++){
            int start = i;
            for(int j=i; j<numbers.length; j++){
                int end = j;
                currSum = 0;
                for(int k=start; k<=end; k++){
                    currSum += numbers[k];
                }
                System.out.println(currSum);      // print the current sum values
                if(maxSum < currSum){
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Maximum sum of sub array is:"+ maxSum);
    }
    // TC = O(n^3)

    // 2nd Approch  :- prefix sum method
    public static void maxSubarrayPrifixSum(int numbers[]){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];

        prefix[0] = numbers[0];

        for(int i=1; i<prefix.length; i++){
            prefix[i] = prefix[i-1]+ numbers[i];
        }

        for(int i=0;i<numbers.length; i++){
            int start = i;
            for(int j=i; j<numbers.length; j++){
                int end = j;
                if(start == 0){
                   currSum =  prefix[end];            //2ndMethod: currSum = start==0? prefix[end]:prefix[end] - prefix[start-1]
                }else{
                currSum = prefix[end] - prefix[start-1];
                }

                if(maxSum < currSum){
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Maximum sum of sub array is:"+ maxSum);
    }
    //TC = O(n^2)


    //3rd Approch :- Kadane's Algorithm
    public static void KadaneAlgo(int numbers[]){
        int maxSum = Integer.MIN_VALUE;
        int current_sum = 0;

        for(int i=0; i<numbers.length; i++){
            current_sum = current_sum + numbers[i];
            if(current_sum < 0){
                current_sum = numbers[i];
            }
            maxSum = Math.max(current_sum, maxSum);
        }
        System.out.println("Max sum of sub Array: "+ maxSum);
    }

    public static int trappedRainWater(int height[]){
        int n = height.length;
        // Calculate the left max bounday array
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for(int i=1; i<n;i++){
            leftMax[i] =Math.max(height[i], leftMax[i-1]);
        }

        // Calculate the Right max bounday array
        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i=n-2; i>=0;i--){
            rightMax[i] = Math.max(height[i],rightMax[i+1]);
        }

        int trappedWater = 0;
        //loop
        for(int i=0; i<n; i++){
            int waterLevel = Math.min(leftMax[i],rightMax[i]);
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }


    public static int buyAndSellsStocks(int prices[]){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i<prices.length;i++){
            if(buyPrice < prices[i]){
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            }else{
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }


    public static boolean isTwice(int nums[]){
        
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; i<nums.length; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        // int marks[] = new int[100];
        // Scanner sc= new Scanner(System.in);

        // int marks[] ={97,98,99};   //we can update the value in sub fun it can modified
        // int nonChange = 5; //it cna never be changable
        // update(marks , nonChange);


        // System.out.println(nonChange);
        // for(int i=0; i< marks.length; i++){
        //     System.out.print(marks[i]+" ");
        // }
        // System.out.println();


        // System.out.println("legnth of array:"+marks.length);

        // marks[0] = sc.nextInt();
        // marks[1] = sc.nextInt();
        // marks[2] = sc.nextInt();

        // System.out.println("Phy: "+ marks[0]);
        // System.out.println("Chem: "+ marks[1]);
        // System.out.println("Maths: "+ marks[2]);

        // int percentage = (marks[0]+marks[1]+marks[2])/3;
        // System.out.println("Percentage: "+percentage+"%");



        // int numbers[]= {2, 4, 6, 8, 10, 12, 14, 16};
        // int key = 16;
        // int index2 = linearSearch(numbers, key);

        // String fruits[] = {"Apple","Grapes","mango","Orange"};
        // String fKey = "mango";
        // int index = linearSearch2(fruits, fKey);

        // if(index == -1 && index2 == -1){
        //     System.out.println("MOT found");
        // }else{
        //     System.out.println("Key is at index: "+ index +" & "+ index2);
        // }


        // int numbers[] = { 13, 24, 6, 358, 5,100,78,34};
        // System.out.println("Largest value is : "+ getLargest(numbers));



        // int numbers[] = {2,4,6,8,10,12,14,16,34,45,56,78,90};
        // int key = 45;
        // System.out.println("The key index is:"+ binarySearch(numbers, key));



        // int numbers[] = {2,4,6,8,10};
        // reverse(numbers);
        
        // for(int i=0; i<numbers.length; i++){
        //     System.out.print(numbers[i]+" ");
        // }
        // System.out.println();


        // int numbers[] = {2,4,6,8,10};
        // printPairs(numbers);

        // int numbers[] = {2,4,6,8,10};
        // printSubarray(numbers);
        //printSubArraySum(numbers);

        // int numbers[] = {1,-2,6,-1,3};
        // maxSubarraySum(numbers);

        // int numbers[] = {2,4,6,8,10};
        // maxSubarrayPrifixSum(numbers);

        int numbers[] = {-1};
        KadaneAlgo(numbers);

        // int height[] = {1,0,2,1,0,1,3,2,1,2,1};
        // System.out.println(trappedRainWater(height));

        // int prices[] = {7,1,5,3,6,4};
        // System.out.println(buyAndSellsStocks(prices));

        // int nums[] = {1,2,3,4};
        // System.out.println(isTwice(nums));


    }
}