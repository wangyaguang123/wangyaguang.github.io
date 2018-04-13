
public class Load {

    static int n;//��װ����Ŀ  
    static int[] w;//��װ����������  
    static int c;//��һ���ִ���������  
    static int cw;//��ǰ������  
    static int bestw;//��ǰ����������  
    static int r;//ʣ�༯װ������  
    static int[] x;//��ǰ�⣬��¼�Ӹ�����ǰ�ڵ��·��  
    static int[] bestx;//��¼��ǰ���Ž�  
    public static int maxLoading(int[] ww,int cc){  
        //��ʼ�������ݳ�Ա,�����±��1��ʼ  
        n=ww.length-1;  
        w=ww;  
        c=cc;  
        cw=0;  
        bestw=0;  
        x=new int[n+1];  
        bestx=new int[n+1];  
          
        //��ʼ��r����ʣ���������  
        for(int i=1;i<=n;i++){  
            r+=w[i];  
        }  
          
        //��������������  
        backtrack(1);  
        return bestw;  
    }  
    //�����㷨  
    public static void backtrack(int i){  
        //������i��ڵ�  
        if(i>n){//����Ҷ�ڵ�  
            if(cw>bestw){  
                for(int j=1;j<=n;j++){  
                    bestx[j]=x[j];  
                }  
                bestw=cw;  
            }  
            return;  
        }  
        r-=w[i];  
        if(cw+w[i]<=c){//����������(Լ������)  
            x[i]=1;//��������־Ϊ1  
            cw+=w[i];  
            backtrack(i+1);//������һ��  
            cw-=w[i];//�ָ��ֳ�����Ϊcw��ȫ�ֱ���  
        }  
        if(cw+r>bestw){//�������������޽纯����  
            x[i]=0;//��������־Ϊ0  
            backtrack(i+1);  
        }  
        r+=w[i];//�ָ��ֳ���r��ȫ�ֱ���  
    }  
    public static void main(String[] args) {  
        int[] w={0,10,40,40};    
        int c1=50;  
        int c2=50;  
        int n=w.length-1;  
        int weight1=maxLoading(w,c1);  
        int weight2=0;//�����2�Ҵ�����Ҫװ������  
        for(int i=1;i<=n;i++)  
            weight2+=w[i]*(1-bestx[i]);//ʣ��δװ��ļ�װ��ȫ��װ��ڶ��Ҵ���bestx[i]Ϊ1����0  
        if(weight2>c2)  
            System.out.println("�޷���ȫ����װ��װ�����Ҵ���");  
        else{  
            System.out.println("��һ�Ҵ�װ��������ǣ�"+weight1);  
            System.out.println("�ڶ��Ҵ�װ��������ǣ�"+weight2);  
            for(int i=1;i<=n;i++){  
                if(bestx[i]==1)  
                    System.out.println("��װ��"+i+"װ���һ�Ҵ���");  
                else  
                    System.out.println("��װ��"+i+"װ��ڶ��Ҵ���");  
            }  
        }  
    }  
}
