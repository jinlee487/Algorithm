package bfs_dfs;

public class Target_number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}
	public static int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(0, numbers, target, 0, 0);
        return answer;
	}
	static int dfs(int cnt, int[] numbers, int target,int sum, int idx) {
    	if(idx==(numbers.length)) {
			if(sum==target) {
	    		return 1;
	    	}
			return 0;
    	}
		if (idx<numbers.length) {
    		cnt = dfs(cnt,numbers,target,sum+numbers[idx],idx+1)+
    		dfs(cnt,numbers,target,sum-numbers[idx],idx+1);
		}
    	return cnt;
	}
}
