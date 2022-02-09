public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1)
            return 0;
        int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; ++i) {
            for (int j = 0; j < obstacleGrid[0].length; ++j) {
                if(i==0&j==0)
                    dp[i][j]=1;
                else
                dp[i][j]=0;
                if(i>0&&obstacleGrid[i-1][j]==0)
                    dp[i][j]=dp[i-1][j]+dp[i][j];
                if(j>0&&obstacleGrid[i][j-1]==0)
                    dp[i][j]=dp[i][j-1]+dp[i][j];
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
    public static void main(String[] args){
        Solution63 s = new Solution63();
        int[][] obstacle= new int[][]{{0,0},{1,1},{0,0}};
        int[][] obstacle2= new int[][]{{1,0,0},{0,1,0},{0,0,0}};
        System.out.println(s.uniquePathsWithObstacles(obstacle2));
    }
}
