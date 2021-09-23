package algoexpert.easy.ClassPhotos;
import java.util.*;
public class solution {
    public boolean classPhotos1(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        // Write your code here.
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);
        boolean red = redShirtHeights.get(0)<blueShirtHeights.get(0) ? true : false;
        for(int i=0;i<redShirtHeights.size();i++){
            if(red){
                if(redShirtHeights.get(i)>=blueShirtHeights.get(i)){
                    return false; 
                }
            } else {
                if(redShirtHeights.get(i)<=blueShirtHeights.get(i)){
                    return false; 
                }
            }
        }
        return true;
    }
    public boolean classPhotos2(
        ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        // Write your code here.
		Collections.sort(redShirtHeights);
		Collections.sort(blueShirtHeights);
		if(redShirtHeights.get(0)<blueShirtHeights.get(0)){
			for(int i=0;i<blueShirtHeights.size();i++){
				if(redShirtHeights.get(i)>blueShirtHeights.get(i)){
					return false;
				}
			}	
		} 
		else if(redShirtHeights.get(0)>blueShirtHeights.get(0)){
			for(int i=0;i<blueShirtHeights.size();i++){
				if(redShirtHeights.get(i)<blueShirtHeights.get(i)){
					return false;
				}
			}	
		}
		else {
			return false;
		}

		
    return true;
  }
}


