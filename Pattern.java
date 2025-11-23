// import java.util.*;

public class Pattern {

    public static void triangle(int n){
        for(int line=1; line<=n ; line++){

            for(int star=1; star<=line; star++){  
                System.out.print("* ");             
            }                                    
        System.out.println();                     
        }
    }

    public static void ulta_triangle(int n){
        for(int line=1; line<=n; line++){
            for(int star=1; star<=(n-line+1); star++){     
                System.out.print("* ");                 
            }                                             
        System.out.println();                             
        }

    }

    public static void alphtri(int n){
        char ch = 'A';
        for(int line=1; line<=n; line++){
            for(int chars=1; chars<=line; chars++){     
                System.out.print(ch +" ");  
                ch++;                
            }                                              
        System.out.println();                              
        }
    }


    public static void hallo_rect(int totRows ,int totCols){
        for(int i = 1; i<=totRows; i++){
            for(int j=1; j<=totCols; j++){
                if(i == 1 || i==totRows || j == 1 || j==totCols){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
       
    }

    public static void Half_pyramid(int n){
        for(int i = 1; i<=n; i++){

            for(int j = 1; j<=n-i;j++){
                System.out.print(" ");
            }

            for(int j =1; j<=i; j++){
                System.out.print("*");
            }
        System.out.println();
        }
    }


    public static void Half_pyramid_withNum(int n){
        
        for(int i=1;i<=n;i++){

            for(int j=1; j<=n-i+1;j++){
                System.out.print(j+" ");
            }

        System.out.println();
        }
        
    }

   
    public static void fluid_tri(int n){
        int counter = 1;

        for(int i = 1; i<= n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(counter+" ");
                counter ++;
         
           }
        System.out.println();
        }
    }


    public static void zero_one_tri(int n){

        for(int i=0; i<=n; i++){

            for(int j=1; j<=i; j++){
                if((i+j)%2 == 0){
                    System.out.print("1 ");
                }else{
                    System.out.print("0 ");
                }
            }
        System.out.println();
        }
    }

    public static void butterfly(int n){
        for(int i=1; i<=n;i++){
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }

            for(int j=1; j<=2*(n-i);j++){
                System.out.print(" ");
            }

            for(int j=1; j<=i;j++){
                System.out.print("*");
            }
        System.out.println();
        } 
    
        for(int i=n; i>=1; i--){
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }

            for(int j=1; j<=2*(n-i);j++){
                System.out.print(" ");
            }

            for(int j=1; j<=i;j++){
                System.out.print("*");
            }
        System.out.println();
        }
    }


    public static void solid_rhombus(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }

            for(int j=1; j<=n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void hallow_rhombus(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }

            //hallo rectangle code
            for(int j=1; j<=n; j++){
                if(i==1 || i==n || j==1 || j== n){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static void daimond(int n){

        for(int i=1; i<=n; i++){
            //spaces
            for(int j=1; j<=(n-i); j++){
                System.out.print(" ");
            }
            //stars
            for(int j=1; j<=(2*i)-1;j++){
                System.out.print("*");
            }
        System.out.println();
        }


        for(int i=n; i>=1; i--){
            //spaces
            for(int j=1; j<=(n-i); j++){
                System.out.print(" ");
            }
            //stars
            for(int j=1; j<=(2*i)-1;j++){
                System.out.print("*");
            }
        System.out.println();
        }
    }

    public static void num_pyramid(int n){
        for(int i=1; i<= n; i++){
            for(int j=1; j<=(n-i);j++){
                System.out.print(" ");
            }

            for(int j=1;j<=i;j++){
                System.out.print(i+" ");
            }
        System.out.println();
        }
    }

    public static void palindromeNum(int n){

        for(int i=1;i<=n;i++){

            for(int j=1;j<=(n-i); j++){
                System.out.print(" ");
            }
            for(int j=i;j>=1;j--){
                System.out.print(j);
            }
            for(int j=2;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }


    public static void main(String args[]){
       
        // triangle(5);

        // ulta_triangle(5);
    
        // alphtri(5);

        // hallo_rect(4,5);

        // Half_pyramid(4);

        // Half_pyramid_withNum(5);

        // fluid_tri(5);

        // zero_one_tri(5);

        // butterfly(4);

        // solid_rhombus(5);

        // hallow_rhombus(5);

        // daimond(4);

        // num_pyramid(5);

        palindromeNum(5);

    }
}