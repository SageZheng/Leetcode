public class solutionsubmatric
{
    public static int[][] preprocess(int[][] mat)
    {
        int[][] sum = new int[mat.length][mat[0].length];
        sum[0][0] = mat[0][0];
        for (int j = 1; j < mat[0].length; j++) {
            sum[0][j] = mat[0][j] + sum[0][j - 1];
        }
        for (int i = 1; i < mat.length; i++) {
            sum[i][0] = mat[i][0] + sum[i - 1][0];
        }
        for (int i = 1; i < mat.length; i++)
        {
            for (int j = 1; j < mat[0].length; j++)
            {
                sum[i][j] = mat[i][j] + sum[i - 1][j] + sum[i][j - 1]
                        - sum[i - 1][j - 1];
            }
        }
        return sum;
    }
    public static int findSum(int[][] mat, int p, int q, int r, int s)
    {
        if (mat == null || mat.length == 0) {
            return 0;
        }
        int[][] sum = preprocess(mat);
        int total = sum[r][s];
        if (q - 1 >= 0) {
            total -= sum[r][q - 1];
        }
        if (p - 1 >= 0) {
            total -= sum[p - 1][s];
        }
        if (p - 1 >= 0 && q - 1 >= 0) {
            total += sum[p - 1][q - 1];
        }
        return total;
    }

    public static void main(String[] args)
    {
        int[][] D =
                {
                        { 0,-2,-7,0},
                        { 9,2,-6,2},
                        { -4,1,-4,1},
                        { -1,8,0,2},
                };

        int p = 1, q = 0, r = 3, s = 1;

        System.out.print(findSum(D, p, q, r, s));
    }
}

