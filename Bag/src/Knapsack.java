import java.util.*;
public class Knapsack {

	static class Item{
		String id;
		int size=0;
		int value=0;
		static Item newItem(String id,int size,int value){
			Item item=new Item();
			item.id=id;
			item.size=size;
			item.value=value;
			return item;
		}
		public String toString(){
			return this.id;
		}
	}
	static class Load{
		List<Item> items=new ArrayList<Item>();	//������Ʒ�ļ���
		Load(){
		}
		int getValue(){
			int value=0;
			for(Item item:items){
				value+=item.value;
			}
			return value;
		};
		int getSize(){
			int size=0;
			for(Item item:items){
				size+=item.size;
			}
			return size;
		};
		public String toString(){
			return String.valueOf(this.getValue())+" ";
		}
	}
	static Item[] sourceItems={Item.newItem("��ʵ��ӵ��һ��,ʲô����ȱ", 4, 5),Item.newItem("�ⲻ�Ǹ��", 5, 6),Item.newItem("���ҽԷ���", 6, 8)}; 
	static int bagSize=10;//���Ŀռ�
	static int itemCount=sourceItems.length;//��Ʒ������
	static Load[][] okBags=new Load[itemCount+1][bagSize+1];
	static void init(){
		for(int i=0;i<bagSize+1;i++){
			okBags[0][i]=new Load();
		}
		for(int i=0;i<itemCount+1;i++){
			okBags[i][0]=new Load();
		}
	}
	static void doBag(){
		init();
		for(int iItem=1;iItem<=itemCount;iItem++){
			for(int curBagSize=1;curBagSize<=bagSize;curBagSize++){
				okBags[iItem][curBagSize]=new Load();
				if(sourceItems[iItem-1].size>curBagSize){
					okBags[iItem][curBagSize].items.addAll(okBags[iItem-1][curBagSize].items);					
				}else{
					int notIncludeValue=okBags[iItem-1][curBagSize].getValue();
					int freeSize = curBagSize - sourceItems[iItem - 1].size;// �ŵ�ǰ��Ʒ��ʣ��ռ�
					int includeValue = sourceItems[iItem - 1].value + okBags[iItem - 1][freeSize].getValue();// ��ǰ��Ʒ��ֵ+���˵�ǰ��Ʒ��ʣ����ռ��ܷ���Ʒ�ļ�ֵ
					if (notIncludeValue < includeValue) {// ���˼�ֵ����ͷ���.
						okBags[iItem][curBagSize].items.addAll(okBags[iItem - 1][freeSize].items);
						okBags[iItem][curBagSize].items.add(sourceItems[iItem - 1]);
					 } else {// ���򲻷��뵱ǰ��Ʒ
					 okBags[iItem][curBagSize].items.addAll(okBags[iItem - 1][curBagSize].items);
					 }
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Knapsack.doBag();
        for (int i = 0; i < Knapsack.itemCount + 1; i++) {// ��ӡ���з����а�������Ʒ
            for (int j = 0; j < Knapsack.bagSize + 1; j++) {
                System.out.print(Knapsack.okBags[i][j].items);
            }
            System.out.println("");
        }

        for (int i = 0; i < Knapsack.itemCount + 1; i++) {// ��ӡ���з����а����ܼ�ֵ
            for (int j = 0; j < Knapsack.bagSize + 1; j++) {
                System.out.print(Knapsack.okBags[i][j]);
            }
            System.out.println("");
        }

        Load okBagResult = Knapsack.okBags[Knapsack.itemCount][Knapsack.bagSize];
        System.out.println("���ս��Ϊ:" + okBagResult.items.toString() + okBagResult);
        
	}

}
