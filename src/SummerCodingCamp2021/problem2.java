package SummerCodingCamp2021;

import java.util.*;
public class problem2 {
    public static void main(String[] args) {
        int[] t = {0,3,3,3,3,3};
        int[] r = {4,3,2,2,2,2};
        System.out.println(Arrays.toString(solution(t,r)));
    }
    public static int[] solution(int[] t, int[] r) {
        PriorityQueue<Customer> pq1 = new PriorityQueue<Customer>(new Comparator<Customer>(){
            @Override
            public int compare(Customer o1,Customer o2){
                return o1.liftNumber - o2.liftNumber;
            }
        });
        PriorityQueue<Customer> pq2 = new PriorityQueue<Customer>(new Comparator<Customer>(){
            @Override
            public int compare(Customer o1,Customer o2){
                if(o2.rating == o1.rating){
                    if(o2.liftNumber == o1.liftNumber){
                        return o1.idx - o2.idx;
                    }
                    return o1.liftNumber - o2.liftNumber;

                }
                return o1.rating - o2.rating;
            }
        });
        for(int i=0;i<t.length;i++){
            pq1.add(new Customer(t[i],r[i],i));
        }
        System.out.println("this is from pq1 ");
        System.out.println(pq1);
        int[] answer = new int[t.length];
        Customer c;

        for(int i=0,liftCount = 0;liftCount<t.length;i++){
            for(;!pq1.isEmpty()&&pq1.peek().liftNumber<=i;){
                c = pq1.poll();
                System.out.println("this is from pq1 c => " + c);
                pq2.add(c);
            }
            if(!pq2.isEmpty()){
                c = pq2.poll();
                System.out.println("this is from pq2 c => " + c);
                answer[liftCount++] = c.idx;
            }
        }
        return answer;
    }
}
class Customer {
    int idx;
    int liftNumber;
    int rating;
    Customer(int liftNumber, int rating, int idx){
        this.liftNumber = liftNumber ; 
        this.rating = rating;
        this.idx = idx;
    }
    @Override
    public String toString(){
        return "liftNumber: " + liftNumber + " rating: " + rating + " idx: " + idx;
    }
}
