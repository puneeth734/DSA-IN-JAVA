
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Classroom2 {
    static class Student implements Comparable <Student>{  // compare the variable
        String name;
        int rank;

        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }


    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            // add at lst index
            arr.add(data);

            int x = arr.size() - 1; // child
            int parent = (x-1) / 2; // parent
             
            while (arr.get(x) < arr.get(parent)) {
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);
            }
        }

        public int peek(){
            return arr.get(0);
        }
    }
    public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // pq.add(3);
        // pq.add(4);
        // pq.add(1);
        // pq.add(7);

        // while (!pq.isEmpty()) {
        //     System.out.print(pq.peek()+" ");
        //     pq.remove();
        // }


        PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.add(new Student("A" , 4 ));
        pq.add(new Student("B" , 5 ));
        pq.add(new Student("C" , 2 ));
        pq.add(new Student("D" , 12));
        pq.add(new Student("E" , 1 ));

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + " -> " + pq.peek().rank+" ");
            pq.remove();
        }
    }
}
