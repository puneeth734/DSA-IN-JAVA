import java.util.*;
public class Function {
    public static void printHello(){
        System.out.println("hello Wrld");
    }
    
    public static int calSum(int num1,int num2){
        int sum = num1 + num2;
        return sum;
    }

    public static int multiply(int num1, int num2){
        int product = num1 * num2;
        return product;
    }



    public static int factorial(int num){
        int fac = 1;
        for(int i=1; i<=num;i++){
            fac = fac * i;
        }
        return fac;
    }



    public static int BinCoeff(int n,int r){
        int fact_n = factorial(n);
        int fact_r = factorial(r);
        int fact_nMr = factorial(n-r);
        int BinCoeff = fact_n/ (fact_r*fact_nMr);     // binomial coeffeient formula n!/r!(n-r)!
        return BinCoeff;
    }


    public static boolean isPrime(int n){
    
        if(n == 2){
            return true;
        }
        for(int i = 2; i< n-1; i++){                // we can replace the condition as "i<=Math.sprt(n)"
            if(n % i == 0){
                return false;
            }
        }
            return true;
    }



    public static void primesInRange(int n){
        for(int i=2; i<=10; i++){
            if(isPrime(i)){
                System.out.println(i+"");
            }
        }
        System.out.println();
    }



    public static void binToDec(int BinNum){
        int myNum = BinNum;
        int pow = 0;
        int decNum = 0;

        while(BinNum > 0){
            int lastDigit = BinNum % 10;
            decNum = decNum + (lastDigit * (int) Math.pow(2,pow));
           
            pow++;
            BinNum = BinNum /10;
        }
        System.out.println("Binary of "+ myNum +"is: "+BinNum);
    }



    public static void decToBin(int n){
        int myNum = n;
        int pow = 0;
        int binNum = 0;

        while (n > 0) {
            int rem = n % 2;
            binNum = binNum +(rem * (int) Math.pow(10,pow));

            pow ++;
            n = n/2;
        }
        System.out.println("binary form of "+ myNum +"= "+ binNum);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Product of two numbers

        // System.out.println("Enter First number: ");
        // int num1 = sc.nextInt();
        // System.out.println("Enter Second number: ");
        // int num2 = sc.nextInt();
        // int prod = multiply(num1, num2);
        // System.out.println("The product of "+num1+" and "+num2+" is: "+prod);
        
        // Factorial of number

        // System.out.println("Enter your number");
        // int num = sc.nextInt();
        // System.out.println("factorail of number is: "+ factorial(num));


        // Binomial Coeffcient
        // int n_value = sc.nextInt();
        // int r_value = sc.nextInt();

        // int BinCoeff = BinCoeff(n_value,r_value);
        // System.out.println("Number of binomial coefficent is:"+ BinCoeff);

       
        // System.out.println(isPrime(10));


        
        // primesInRange(10);

        // binToDec(101);

        decToBin(7);
    }
}
