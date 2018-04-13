

public class Nabla {
	public int n;//第一行符号的个数
	public int half;//n*(n-1)/4
	public int count;
	public int[][] p;//符号三角形矩阵  
    public long sum;//已找到的符号三角形个数 
    public long compute(int nn){  
        n=nn;  
        count=0;  
        sum=0;  
        half=n*(n+1)/2;  
        if(half%2==1) return 0;  
        half=half/2;  
        p=new int[n+1][n+1];  
        backtrack(1);  
        return sum;  
    }  
    public void backtrack(int t){  
        if(count>half||(t*(t-1)/2-count)>half)  
            return ;  
        if(t>n)  
            sum++;  
        else{  
            for(int i=0;i<2;i++){  
                p[1][t]=i;  
                count+=i;  
                for(int j=2;j<=t;j++){  
                    p[j][t-j+1]=p[j-1][t-j+1]^p[j-1][t-j+2];//^：按位异或。比如二进制     1001 ^ 1100 = 0101  0^0=0，1^1=0 ，1^0 = 1，0^1=1。  
                    count+=p[j][t-j+1];  
                }  
                backtrack(t+1);  
                for(int j=2;j<=t;j++){  
                    count-=p[j][t-j+1];  
                      
                }  
                count-=i;  
            }  
        }  
    }  

}
