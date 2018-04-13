import java.util.Date;
public class NQueen {

	private static final short K=15;        //ʹ�ó��������壬����֮���N�ʺ�����
    private static int count=0;            //���������
    private static short N=0;
    
    public static void main(String[] args) {
        for(N=9;N<=K;N++){
            Date begin =new Date();
            /**
             * ��ʼ�����̣�ʹ��һά������������Ϣ
             * chess[n]=X:��ʾ��n��X����һ���ʺ�
             */
            short chess[]=new short[N];
            for(int i=0;i<N;i++){
                chess[i]=0;
            }
            
            putQueenAtRow(chess,(short)0);
            Date end =new Date();
            System.out.println("��� " +N+ "�ʺ����⣬��ʱ��" +String.valueOf(end.getTime()-begin.getTime())+ "���룬��������"+count);
        }
    }

    private static void putQueenAtRow(short[] chess, short row) {        
        /**
         * �ݹ���ֹ�жϣ����row==N����˵���Ѿ��ɹ��ڷ���8���ʺ�
         * ����������ֹ�ݹ�
         */
        if(row==N){
            count++;
//            System.out.println("�� "+ count +" �ֽ⣺");
//            for(int i=0;i<N;i++){
//                for(int j=0;j<N;j++){
//                    System.out.print(chess[i][j]+" ");
//                }
//                System.out.println();
//            }
            return;
        }
        
        short[] chessTemp=chess.clone();
        
        /**
         * ����һ�е�ÿһ��λ�ó����ŷŻʺ�
         * Ȼ����״̬�������ȫ�����ִ�еݹ麯���ڷ���һ�лʺ�
         */
        for(short i=0;i<N;i++){
            //�ڷ���һ�еĻʺ�
            chessTemp[row]=i;
            
            if( isSafety( chessTemp,row,i ) ){
                putQueenAtRow(chessTemp,(short) (row+1));
            }
        }
    }

    private static boolean isSafety(short[] chess,short row,short col) {
        //�ж����ϡ����ϡ������Ƿ�ȫ
        short step=1;
        for(short i=(short) (row-1);i>=0;i--){
            if(chess[i]==col)    //����
                return false;
            if(chess[i]==col-step)    //����
                return false;
            if(chess[i]==col+step)    //����
                return false;
            
            step++;
        }   
        return true;
    }
}
