package ect;
import java.util.Scanner;
class point{
  int x;
  int y;
}
public class PointSort {
	public static void main(String[] args){
	    Scanner input = new Scanner(System.in);
	    int t = input.nextInt();
	    point[] p = new point[t];
	    for(int i=0;i<t;i++){
	      p[i] = new point();
	      p[i].x =input.nextInt();
	      p[i].y = input.nextInt();
	    }
	    quickSort(p,0,t-1,0);
	    int begin = 0;
	    int end = 1;
	    while(begin < t) {
	    	while(end < t) {
	    		if(p[begin].x == p[end].x) {
	    			end++;
	    		}else {
	    			break;
	    		}
	    	}
	    	quickSort(p,begin,end-1,1);
	    	begin = end;
	    	end = begin;
	    }
	    for(int i=0;i<t;i++){
	    	System.out.println(p[i].x+" "+p[i].y);
	    }
	    input.close();
	} 
	public static void quickSort(point[] p, int b, int e, int mode){
		if(b <= e) {
			int pi = partition(p,b,e, mode);
			quickSort(p,b,pi-1, mode);
			quickSort(p,pi+1,e, mode);
		}
	}
	public static int partition(point[] p, int b, int e, int mode){
		int pivot = (b+e)/2;
	    int l = b;
	    int r = e;
	    if(mode == 0) {
	    	while(l<r){
	    		while(p[pivot].x >= p[l].x && l<e){
	    			l++;
	       		}
	    		while(p[pivot].x < p[r].x && r>b){
	    			r--;
	    		}
	    		if(l<=r) {
	    			swap(p,l,r);
	    		}
	    		if(r == pivot) return l;
		    }
	    }else {
	    	while(l<r){
	    		while(p[pivot].y >= p[l].y && l<e){
	    			l++;
	       		}
	    		while(p[pivot].y < p[r].y && r>b){
	    			r--;
	    		}
	    		if(l<=r) {
	    			swap(p,l,r);
	    		}
	    		if(r == pivot) return l;
	    	}
	    }
	    swap(p,pivot,r);
	  	return r;
	}
	public static void swap(point[] p, int a, int b){
	    point tmp = new point();
	    tmp = p[a];
	    p[a] = p[b];
	    p[b] = tmp;
	}
}