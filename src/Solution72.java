public class Solution72 {
    public int minDistance(String word1, String word2) {
        boolean[][] dp= new boolean[word1.length()][word2.length()];
        int sum=0;
        for(int i=0;i<word1.length();i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j))
                    dp[i][j] = true;
            }
        }
        boolean[] passWord1=new boolean[word1.length()];
        boolean[] passWord2=new boolean[word2.length()];
        for (int j=0;j<word2.length();j++){
            int temp=0;
            for(int i=0;i<word1.length();i++){
                if(dp[i][j])
                    temp+=1;
            }
            if(temp==0)
                passWord2[j]=true;
        }
        for(int i=0;i<word1.length();i++){
            int temp=0;
            for (int j=0;j<word2.length();j++){
                if(dp[i][j])
                    temp+=1;
            }
            if(temp==0)
                passWord1[i]=true;
        }
        return sum;
    }
}
