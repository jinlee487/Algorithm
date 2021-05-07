package kakao_Blind_2018;
import java.util.*;

/* 
Solved! 
https://programmers.co.kr/learn/courses/30/lessons/17680
캐시
for this problem, we use arraylist to create a lru page replacement.
i tried to use a priorityqueue but did not know tha pq does not 
reorder when the elements inside it are changed. 
pq only reorders when it is polled or added. 
therefore i used an arraylist instead and order the array everytime there needs to be
a replacement to find the most lru cache.
*/
class Cache {
    int idx; 
    String city;
    Cache(int idx, String city){
        this.idx = idx; 
        this.city = city;
    }
    public Cache addIdx(int idx){
        this.idx = idx;
        return this;
    }
    @Override
    public String toString(){
        return "idx: " + this.idx + " city: " + this.city;
    }
}
public class P17680 {
    public static void main(String[] args) throws Exception {
        int cacheSize = 5;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        System.out.println(solution(cacheSize, cities));
    }
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        // PriorityQueue<Cache> pq = new PriorityQueue<Cache>(new Comparator<Cache>(){
        //     @Override
        //     public int compare(Cache o1, Cache o2)
        //     {
        //         return o1.idx - o2.idx;
        //     }
        // });
        ArrayList<Cache> arrayList = new ArrayList<Cache>();
        HashMap<String,Cache> hash = new HashMap<String,Cache>();
        for(int i=0;i<cities.length;i++){
            cities[i] = cities[i].toUpperCase();
            if(arrayList.size()<cacheSize){
                if(hash.containsKey(cities[i])){
                    hash.get(cities[i]).addIdx(i);
                    answer ++;
                } else {
                    hash.put(cities[i],new Cache(i,cities[i]));
                    arrayList.add(hash.get(cities[i]));
                    answer += 5;
                }
            } else {
                if(hash.containsKey(cities[i])){
                    hash.get(cities[i]).addIdx(i);
                    answer ++;
                } else {
                    if(cacheSize == 0){
                        answer += 5;
                    } else {
                        Collections.sort(arrayList,new Comparator<Cache>() {
                            @Override
                            public int compare(Cache o1, Cache o2) {
                                return o1.idx - o2.idx;
                            }
                        });
                        Cache c = arrayList.get(0);
                        hash.remove(c.city);
                        hash.put(cities[i],new Cache(i,cities[i]));
                        arrayList.set(0,hash.get(cities[i]));
                        answer += 5;
                    }
                }
            }
            // System.out.println("\n\nthis is arrayList = " + arrayList);
            // System.out.println("this is hash = " + hash);
            // System.out.println("this is answer = " + answer);

        }
        return answer;
    }
}
