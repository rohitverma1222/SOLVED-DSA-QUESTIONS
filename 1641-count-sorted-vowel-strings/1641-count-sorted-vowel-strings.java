class Solution {
//     public int countVowelStrings(int n) {
// //         int s=5;
// //         int dp1[]=new int[s];
// //         for(int i=0;i<s;i++)
// //         {
// //             dp1[i]=1;
// //         }
// //         if(n==1)
// //             return 5;
// //         int dp2[]=new int[s];
// //         for(int i=0;i<n-1;i++)
// //         {
// //             dp2[s-1]=1;
// //             for(int j=3;j>=0;j--)
// //             {
// //                 dp2[j]=dp1[j];
// //                 if(j+1<5)
// //                     dp2[j]+=dp1[j+1];
// //                 if(j+2<5)
// //                     dp2[j]+=dp1[j+2];
// //                 if(j+3<5)
// //                     dp2[j]+=dp1[j+3];
// //                 if(j+4<5)
// //                     dp2[j]+=dp1[j+4];
// //             }
            
            
// //             for(int j=0;j<5;j++)
// //             {
// //                 dp1[j]=dp2[j];
// //                 // System.out.println(dp1[j]);
// //             }
// //         }
        
//         int sum=65;
// //         for(int i=0;i<5;i++)
// //             sum+=dp1[i];
        
//         return sum;
//     }
    public int countVowelStrings(int n) {
        if(n==1)
            return 5;
        int []dp=new int[5];
        Arrays.fill(dp,1);
        while(n>1)
        {
            int dp1[]=new int[5];
            dp1[4]=dp[4]+dp[3]+dp[2]+dp[1]+dp[0];
            dp1[3]=dp[3]+dp[2]+dp[1]+dp[0];
            dp1[2]=dp[2]+dp[1]+dp[0];
            dp1[1]=dp[1]+dp[0];
            dp1[0]=dp[0];
            
            dp=dp1;
            n--;
        }
        int sum=0;
        for(int i:dp)
        {
            sum+=i;
        }
        return sum;
    }
}



