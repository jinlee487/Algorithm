package KakaoTalk_2020_first;

public class Key_and_Lock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] key = new int[][] {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		//int[][] lock = new int[][] {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		int[][] lock = new int[][] {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 1, 1, 1}, {1, 1, 0, 0, 1}, {1, 1, 1, 1, 1}};
		System.out.println(calc(key,lock));
	}
	public static boolean calc(int[][] key, int[][] lock) {
		boolean check = false; 
		int keylen = key.length, temp=0;
		int locklen= lock.length;
		int[][] keymap = new int[keylen][keylen];
		for(int i=0;i<keylen;i++) {
			keymap[i] = key[i].clone();
		}
//		for(int[] x:lock) {
//			System.out.println(Arrays.toString(x));
//		}
		int[][] lockmap = new int[2*(keylen-1)+locklen][2*(keylen-1)+locklen];
		for(int i=0;i<locklen;i++) {
			for (int j=0;j<locklen;j++) {
				lockmap[i+keylen-1][j+keylen-1] = lock[i][j];
			}
		}
//		System.out.println("this is the lockmap");
//		for(int[] x:lockmap) {
//			System.out.println(Arrays.toString(x));
//		}

		int[][] testmap = new int[2*(keylen-1)+locklen][2*(keylen-1)+locklen];

		for(int c=0;c<4;c++) { //rotation
//			System.out.println("this is the keymap");
//			for(int[] x:keymap) {
//				System.out.println(Arrays.toString(x));
//			}
			
			for(int i=0;i<locklen+(keylen-1);i++) { // col picking starting points
				next:
				for(int j=0;j<locklen+(keylen-1);j++) { //row 
//					System.out.printf("\nstarting => [%d,%d]",i,j);
					for(int copy=0;copy<lockmap.length;copy++) { //reinitializing testmap
						testmap[copy] = lockmap[copy].clone();
					}
					check = true; //reinitializing check
					
					for(int k=0;k<keylen;k++) { //col
						for(int kk=0;kk<keylen;kk++) { //row
							temp=lockmap[i+k][j+kk]+key[k][kk]; 
							testmap[i+k][j+kk] = temp;
//							System.out.printf("\n[%d+%d][%d+%d]=> %d\n",i,k,j,kk,temp);
						}
					}
//					System.out.println("this is the test map");
//					for(int[] x:testmap) {
//						System.out.println(Arrays.toString(x));
//					}
					
					for(int a=keylen-1;a<keylen-1+locklen;a++) {
						for(int b=keylen-1;b<keylen-1+locklen;b++) {
							if (testmap[a][b]!=1) {
								check=false;
								continue next;
							}
						}
					}
					if(check==true) return check;
				}
			}
			if(c+1==4)
				return check;
			for(int row=0;row<keylen;row++) {
				for(int col=0;col<keylen;col++) {
					key[row][col] = keymap[col][Math.abs(row-(keylen-1))]; 
				}
			}
			for(int i=0;i<keylen;i++) {
				keymap[i] = key[i].clone();
			}
		}
		return check;
	}
}
