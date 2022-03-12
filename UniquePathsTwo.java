public class UniquePathsTwo {
	
	/*
	 * Unique Paths II 
	 * 
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
	 * the diagram below).
	 * 
	 * The robot can only move either down or right at any point in time. The robot
	 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
	 * the diagram below).
	 * 
	 * Now consider if some obstacles are added to the grids. How many unique paths
	 * would there be?
	 * 
	 * An obstacle and space is marked as 1 and 0 respectively in the grid.
	 * 
	 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]] Output: 2 Explanation: There
	 * is one obstacle in the middle of the 3x3 grid above. There are two ways to
	 * reach the bottom-right corner: 1. Right -> Right -> Down -> Down 2. Down ->
	 * Down -> Right -> Right
	 * 
	 * Input: obstacleGrid = [[0,1],[0,0]] Output: 1
	 */
			 
	public int uniquePathsWithObstacles(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		if (grid[0][0] == 1)
			return 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					grid[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (grid[0][i] == Integer.MAX_VALUE) {
				for (int j = i + 1; j < n; j++) {
					grid[0][i] = 0;
				}
				break;
			}
			grid[0][i] = 1;
		}
		for (int i = 0; i < m; i++) {
			if (grid[i][0] == Integer.MAX_VALUE) {
				for (int j = i + 1; j < m; j++) {
					grid[i][0] = 0;
				}
				break;
			}
			grid[i][0] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (grid[i][j] != Integer.MAX_VALUE)
					grid[i][j] = (grid[i][j - 1] == Integer.MAX_VALUE ? 0 : grid[i][j - 1])
							+ (grid[i - 1][j] == Integer.MAX_VALUE ? 0 : grid[i - 1][j]);
			}
		}
		return grid[m - 1][n - 1] == Integer.MAX_VALUE ? 0 : grid[m - 1][n - 1];
	}
}