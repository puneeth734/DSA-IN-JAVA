import java.net.Inet4Address;
import java.util.*;
import java.util.LinkedList;

public class QueueB {
    // static class Queue{
    //     static int arr[];
    //     static int size;
    //     static int rear;
    //     static int front;

    //     Queue(int n){
    //         arr = new int[n];
    //         size = n;
    //         rear = -1;
    //         front = -1;
    //     }

    //     public static boolean isEmpty(){
    //         return rear == -1 && front == -1;
    //     }
        
    //     public static boolean isFull(){
    //         return (rear + 1) % size == front;
    //     }

    //     public static void add(int data){
    //         if(isFull()) {
    //             System.out.println("Queue is full");
    //             return;
    //         }
    //         if(front == -1){
    //             front = 0;
    //         }
    //         rear = (rear +1) % size;
    //         arr[rear] = data;
    //     }

    //     public static int remove(){
    //         if(isEmpty()){
    //             System.out.println("Queue is empty");
    //             return -1;
    //         }

    //         int result = arr[front];
    //         front = (front + 1) % size;
    //         if(rear == front){
    //             rear = front = -1;
    //         }else{
    //             front = (front +1) % size; 
    //         }
    //         return result;
    //         // for(int i=0; i<rear; i++){
    //         //     arr[i] = arr[i+1];
    //         // }
    //         // rear = rear -1;
    //         // return front;
    //     }

    //     public static int peek(){
    //         if(isEmpty()){
    //             System.out.println("Queue is empty");
    //             return -1;
    //         }

    //         return arr[front];
    //     }


    // QUEUE USING TWO STACKS
    //     static Stack<Integer> s1 = new Stack<>();
    //     static Stack<Integer> s2 = new Stack<>();

    //     public static boolean isEmpty(){
    //         return s1.isEmpty();
    //     }

    //     public static void add(int data){  //O(n)
    //         while (!s1.isEmpty()) {
    //             s2.push(s1.pop());
    //         }
    //         s1.push(data);

    //         while (!s2.isEmpty()) {
    //             s1.push(s2.pop());
    //         }
    //     }

    //     public static int remove(){
    //         if(isEmpty()){
    //             System.out.println("Queu is empty");
    //             return -1;
    //         }

    //         return s1.pop();
    //     }

    //     public static int peek(){
    //         if(isEmpty()){
    //             System.out.println("Queu is empty");
    //             return -1;
    //         }

    //         return s1.peek();
    //     }

    // }
    static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data){
            if(!q1.isEmpty()){
                q1.add(data);
            }else{
                q2.add(data);
            }
        }

        public static int pop(){
            if(isEmpty()){
                System.out.println("Empty stack");
                return -1;
            }
            int top = -1;

            //case 1
            if(!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            }else{ // case 2
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                   q1.add(top);
                }
            }
            return top; 
        }
         
        public static int peek(){
            if(isEmpty()){
                System.out.println("Empty stack");
                return -1;
            }
            int top = -1;

            //case 1
            if(!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                   
                    q2.add(top);
                }
            }else{ // case 2
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    
                   q1.add(top);
                }
            }
            return top; 
        }
        
    }

    public static void main(String[] args) {
        // Queue q = new Queue(5);
        // q.add(1);
        // q.add(2);
        // q.add(3);

        // while (!q.isEmpty()) {
        //     System.out.println(q.peek());
        //     q.remove();
        // }
        // Queue q = new Queue();
        // q.add(1);
        // q.add(2);
        // q.add(3);

        // while (!q.isEmpty()) {
        //     System.out.println(q.peek());
        //     q.remove();
        // }

        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
                System.out.println(s.peek());
                s.pop();
            }
    }
}
