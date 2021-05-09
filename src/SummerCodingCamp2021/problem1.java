package SummerCodingCamp2021;

import java.util.*;
public class problem1 {
    public static void main(String[] args) {
        String code = "012345";
        String day = "20190620";
        String[] data = {"price=80 code=987654 time=2019062113","price=90 code=012345 time=2019062014","price=120 code=987654 time=2019062010","price=110 code=012345 time=2019062009","price=95 code=012345 time=2019062111"};
        System.out.println(solution(code, day, data));
    }
    public static int[] solution(String code, String day, String[] data) {

        ArrayList<Data> arrayList = new ArrayList<Data>();
        String[] d;
        for(int i=0;i<data.length;i++){
            d = data[i].split(" ");
            if(d[1].contains(code)&&d[2].contains(day)){
                arrayList.add(new Data(Integer.parseInt(d[0].split("=")[1]),Integer.parseInt(d[2].split("=")[1])));
            }
        }
        Collections.sort(arrayList, new Comparator<Data>(){
            @Override
            public int compare(Data o1,Data o2){
                return o1.time - o2.time;
            }
        });
        int[] answer = new int[arrayList.size()];

        for(int i=0;i<arrayList.size();i++){
            answer[i] = arrayList.get(i).price;
        }
        return answer;
    }
}
class Data {
    int price;
    int time;
    Data(int price, int time){
        this.price = price;
        this.time = time;
    }
    @Override
    public String toString(){
        return "price: " + price + " time: " + time;
    }
}
