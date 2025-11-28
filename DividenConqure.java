public class DividenConqure {
    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void margeSort(int arr[], int sti, int eni){
        if(sti >= eni){
            return;
        }
        int mid = sti +(eni - sti)/2;
        margeSort(arr, sti, mid);
        margeSort(arr, mid+1, eni);

        marge(arr, sti, mid, eni);
    }

    public static void marge(int arr[], int sti, int mid, int eni){
        int temp[] = new int[eni-sti+1];
        int i = sti; //iterator for left part
        int j = mid+1; // iterator for right part
        int k = 0;  // iterator for temp arr

        while(i <= mid && j <= eni){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++; 
            }else{
                temp[k] = arr[j];
                j++; 
            }
            k++;
        }
        //left ele if remaining elements present
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // meanwhile  right side
        while(j <= eni){
            temp[k++] = arr[j++];
        }

        //copy temp sorted arr into original
        for(k=0,i=0; k<=arr.length; k++, i++){   
                arr[i] = temp[k];
        }
    }



    public static void quickSort(int arr[], int si, int ei){
        if(si >= ei){
            return;
        }
        int pIdx = partition(arr, si, ei);

        quickSort(arr, si, pIdx-1); //left side
        quickSort(arr, pIdx+1, ei); //right side
    }
    public static int partition(int arr[],int si, int ei){
        int pivot = arr[ei];
        int i = si -1;  //make place for elem smaller than pivot

        for(int j= si; j<ei; j++){
            if(arr[j] <= pivot){
                i++;

                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static int rotatedSearch(int arr[], int target, int si, int ei){
        if(si > ei){
            return -1;
        }
        //find mid
        int mid = si +(ei- si)/2;

        // mid is a target
        if(arr[mid] ==  target){
            return mid;
        }
        
        // mmid in line 1
        if(arr[si] <=  arr[mid]){
            // case 1: left
            if(arr[si] <= target && target <= arr[mid]){
                return rotatedSearch(arr, target, si, mid-1);
            }else{
            // case 2: right
                return rotatedSearch(arr, target, mid+1, ei);
            }
        }

        // mid in line 2
        else{
            // case 3: right
            if(arr[mid] <= target && target <= arr[ei]){
                return rotatedSearch(arr, target, mid+1, ei);
            }else{
            // case 4: left
                return rotatedSearch(arr, target, si, mid-1);
            } 
        }
    }
    public static void main(String[] args) {
        // int arr[] = {6,3,9,5,2,8};
       
        // margeSort(arr, 0, arr.length-1);
        
        // // quickSort(arr, 0, arr.length-1);
        // printArr(arr);

        int arr[] = {4,5,6,7,0,1,2};
        int target = 3;
        int indNo = rotatedSearch(arr, target, 0, arr.length-1);
        System.out.println(indNo);


    }
}
