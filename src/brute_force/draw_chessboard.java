package brute_force;

import java.util.Scanner;

/*
 * Solved!
 * https://www.acmicpc.net/problem/1018
 * 체스판 그리기 
 * 
 */
public class draw_chessboard {
	static int height;
	static int row;
	static String[][] b;
	static String[] temp;
	static int min;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        height = sc.nextInt();
        row = sc.nextInt();
        min = height*row;
        sc.nextLine();
        b = new String[height][row];
        for (int i=0;i<height;i++) {
        	String input = sc.nextLine();
        	temp = input.split("");
        	for (int j=0;j<row;j++) {
        		b[i][j]=temp[j];
        	}
        }
        sc.close();
//        System.out.println("");
//        for (int i=0;i<height;i++) {
//        	for (int j=0;j<row;j++) {
//        		System.out.print(b[i][j]);
//        	}
//        	System.out.println("");
//        }
        skip:
        for (int i=0;i<height;i++) {
        	if (i+7>=height)
        		break;
        	for (int j=0;j<row;j++) {
        		if (j+7>=row)
        			continue skip;
				String start = "W";
				int hcount = 0;
				int count = 0;
        		for(int ii=i;ii<=i+7;ii++,hcount++) {
        			int rcount = 0; 
        			for (int jj=j;jj<=j+7;jj++) {
        				if (hcount%2==0) {
        					if (rcount%2==0) {
        						if (start.equals(b[ii][jj])) {
        							rcount++;
        						}
        						else {
        							count++;
        							rcount++;
        						}
        					}
        					else {
        						if (start.equals(b[ii][jj])) {
        							count++;
        							rcount++;
        						}
        						else {
        							rcount++;
        						}
        					}
        				}
	    				else {
	    					if (rcount%2==1) {
	    						if (start.equals(b[ii][jj])) {
	    							rcount++;
	    						}
	    						else {
	    							count++;
	    							rcount++;
	    						}
	    					}
	    					else {
	    						if (start.equals(b[ii][jj])) {
	    							count ++;
	    							rcount ++;
	    						}
	    						else {
	    							rcount ++;
	    						}
	    					}
	    				}
        			}
        		}
        		if (count<min) {
        			min = count;
        		}
				start = "B";
				hcount = 0;
				count = 0;
        		for(int ii=i;ii<=i+7;ii++, hcount++) {
        			int rcount = 0; 
        			for (int jj=j;jj<=j+7;jj++) {
        				if (hcount%2==0) {
        					if (rcount%2==0) {
        						if (start.equals(b[ii][jj])) {
        							rcount++;
        						}
        						else {
        							count++;
        							rcount++;
        						}
        					}
        					else {
        						if (start.equals(b[ii][jj])) {
        							count++;
        							rcount++;
        						}
        						else {
        							rcount++;
        						}
        					}
        				}
	    				else {
	    					if (rcount%2==1) {
	    						if (start.equals(b[ii][jj])) {
	    							rcount++;
	    						}
	    						else {
	    							count++;
	    							rcount++;
	    						}
	    					}
	    					else {
	    						if (start.equals(b[ii][jj])) {
	    							count ++;
	    							rcount ++;
	    						}
	    						else {
	    							rcount ++;
	    						}
	    					}
	    				}
        			}
        		}
        		if (count<min) {
        			min = count;
        		}

        	}
        }
        System.out.println(min);
	}
}
