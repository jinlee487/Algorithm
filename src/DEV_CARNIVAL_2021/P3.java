package DEV_CARNIVAL_2021;
import java.util.*;
import java.io.*;
// for this problem I will use priorityque. The answer will the pq's size
// how to make a table of all the possibilities then, figure out which ones are incorrect...

class Intern {
    int index;
    int count;
    char[] c;
    Intern(int index, int count, char[] c){
        this.index = index; this.count = count; this.c = c;
    }
}
class P3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<Intern> pq = new PriorityQueue<Intern>();
        System.out.println("Hello Goorm! Your input is " + N + " "+ K);

    }
}
