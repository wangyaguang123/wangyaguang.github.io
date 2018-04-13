import java.util.Arrays;  
public class BagFBack {  
    private MyElement[] myelements; // ��װ����Ʒ  
    private float s; // ��������  
    private float nowWeight = 0; // ��¼��ǰ��������  
    private float nowPrice = 0; // ��¼��ǰ���ü۸�  
    private float betterValue; // ��¼���ļ۸�  
  
    /* 
     * ���췽�������ڳ�ʼ���������� 
     */  
    public BagFBack(float[] w, float[] v, float s) {  
        myelements = new MyElement[w.length];  
        for (int i = 0; i < w.length; i++) {  
            myelements[i] = new MyElement();  
            myelements[i].v = v[i];  
            myelements[i].w = w[i];   
        }  
        this.s = s;  
        // ��������м�ֵ����,ϵͳ���Ǵ�С����ģ����ҽ�MyElement���ˣ�ʹ���ǴӴ�С  
        Arrays.sort(myelements);  
        System.out.println("��Ʒ��ֵ" + "   " + "��Ʒ����");  
        for (int i = 0; i < myelements.length; i++) {  
            System.out.print(myelements[i].v + "    " + myelements[i].w);  
            System.out.println();   
        }  
    }  
    public void traceBack(int t) {  
        if (t >= myelements.length) {  
            // �Ѿ�����������һ�㣬Ҳ�������һ��  
            System.out.println("�ҵ�����");  
            betterValue = nowPrice;  
            System.out.println("�����õ��� " + betterValue);  
            output(myelements);  
            return;  
        }  
        // ���Ƚ�����������  
        if (nowWeight + myelements[t].w < s) {  
            // ����������  
            nowWeight += myelements[t].w;  
            nowPrice += myelements[t].v;  
            myelements[t].take = true;  
            traceBack(t + 1);  
            // ��ԭ�ֳ�  
            nowWeight -= myelements[t].w;  
            nowPrice -= myelements[t].v;  
            myelements[t].take = false;  
        }  
        // �������������Լ�Ҫ���������  
        if (bound(t + 1) > betterValue) {  
            traceBack(t + 1);  
        }  
  
    }  
  
    // ����������������  
    public void output(MyElement[] myelements2) {  
        System.out.print("������Ϊ��Щ����Ʒ��");  
        for (int i = 0; i < myelements2.length; i++) {  
            if (myelements2[i].take) {  
                System.out.print(myelements2[i].w + "   ");  
            }  
  
        }  
    }  
  
    /** 
     * ���ڼ����ұߵģ�����ұߴ�Щ����ֱ�ӽ��� 
     */  
    public float bound(int i) {  
        // �����Ͻ�  
        float cleft = s - nowWeight;  
        float bound = nowPrice;  
        // ����Ʒ��λ��ֵ�ݼ�˳��װ����Ʒ  
        while (i < myelements.length && cleft > myelements[i].v) {  
            cleft -= myelements[i].w;  
            bound += myelements[i].v;      
            myelements[i].take = true;
            i++;  
        }  
  
        // // ������һ��������������ȥ,�Ǿ�װ������������������01������Ҫôװ��Ҫô��װ�����Բ��ü���һ��  
        // if (i < myelements.length) {  
        // bound += (myelements[i].v / myelements[i].w) * cleft;  
        // }  
        return bound;  
    }  
  
    /** 
     * ��װΪ��Ʒ���� 
     */  
    class MyElement implements Comparable {  
        float w;  
        float v;  
        boolean take = false;  
  
        // ����ʵ�ֵķ������������ϵͳ����  
        @Override  
        public int compareTo(Object o) {  
            if (v / w < ((MyElement) o).v / ((MyElement) o).w) {  
                return 1; // ע�⣬�˴���Ҫ�������򣬴Ӵ�С�������Թ��ⷴ  
            } else {  
                return -1;  
            }  
        }  
    }  
  
    public static void main(String[] args) {  
  
        float[] w = { 12,2,3,5 };  
        float[] v = { 19,42,28,12 };  
        float s = 88;  
        BagFBack bagFBack = new BagFBack(w, v, s);  
        // �ӵ�0�㿪ʼ����  
        bagFBack.traceBack(0);
    }  
  
}  
