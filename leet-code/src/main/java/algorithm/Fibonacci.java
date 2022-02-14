package algorithm;

/**
 * @author : tangshijie
 * @since : 2021-12-03 22:37
 */
public class Fibonacci {
    
    public int fib(int n) {
        return simpleSolution(n);
    }
    
    // version 1
    public int simpleSolution(int n){
        if(n==0||n==1) return n;
        return fib(n-1)+fib(n-2);
    }
    
    // version 2
    public int solutionWithMemoArray(int n){
        int[] memo = new int[n+1];
        return getResultWithMemoArray(n,memo);
    }
    
    public int getResultWithMemoArray(int n,int[] memo){
        if(n==0||n==1) return n;
        if(0 != memo[n]) return memo[n];
        memo[n]=getResultWithMemoArray(n-1,memo)+getResultWithMemoArray(n-2,memo);
        return memo[n];
    }
    
    // version 3
    public int solutionWithDP(int n){
        int[] dp = new int[n+1];
        return getResultWithDP(n,dp);
    }
    
    public int getResultWithDP(int n,int[] dp){
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    
    // version 4
    public int solutionWith2Var(int n){
        if(n<1) return 0;
        if(n==1||n==2) return 1;
        int prev=1;
        int curr=1;
        for(int i =3;i<=n;i++){
            int sum=prev+curr;
            prev=curr;
            curr=sum;
        }
        return curr;
    }
}
