public class MinPathSum {
	
	 /*	64. Minimum Path Sum
	 * https://leetcode.com/problems/minimum-path-sum/
	 * 
	 * Given a m x n grid filled with non-negative numbers, find a path from top
	 * left to bottom right, which minimizes the sum of all numbers along its path.
	 * 
	 * Note: You can only move either down or right at any point in time.
	 * 
	 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]] Output: 7 Explanation: Because the
	 * path 1 → 3 → 1 → 1 → 1 minimizes the sum.
	 */
			
    public int minPathSum(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
        int dp[][] = grid;
        
        for(int i=1;i<n;i++){
            dp[0][i]+=dp[0][i-1];
        }
        
        for(int i=1;i<m;i++){
            dp[i][0]+=dp[i-1][0];
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j])+dp[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}