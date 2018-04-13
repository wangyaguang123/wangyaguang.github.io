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
		List<Item> items=new ArrayList<Item>();	//包里物品的集合
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
	static Item[] sourceItems={Item.newItem("其实你拥有一切,什么都不缺", 4, 5),Item.newItem("这不是告别", 5, 6),Item.newItem("你我皆凡人", 6, 8)}; 
	static int bagSize=10;//包的空间
	static int itemCount=sourceItems.length;//物品的数量
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
					int freeSize = curBagSize - sourceItems[iItem - 1].size;// 放当前物品包剩余空间
					int includeValue = sourceItems[iItem - 1].value + okBags[iItem - 1][freeSize].getValue();// 当前物品价值+放了当前物品后剩余包空间能放物品的价值
					if (notIncludeValue < includeValue) {// 放了价值更大就放入.
						okBags[iItem][curBagSize].items.addAll(okBags[iItem - 1][freeSize].items);
						okBags[iItem][curBagSize].items.add(sourceItems[iItem - 1]);
					 } else {// 否则不放入当前物品
					 okBags[iItem][curBagSize].items.addAll(okBags[iItem - 1][curBagSize].items);
					 }
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Knapsack.doBag();
        for (int i = 0; i < Knapsack.itemCount + 1; i++) {// 打印所有方案中包含的物品
            for (int j = 0; j < Knapsack.bagSize + 1; j++) {
                System.out.print(Knapsack.okBags[i][j].items);
            }
            System.out.println("");
        }

        for (int i = 0; i < Knapsack.itemCount + 1; i++) {// 打印所有方案中包的总价值
            for (int j = 0; j < Knapsack.bagSize + 1; j++) {
                System.out.print(Knapsack.okBags[i][j]);
            }
            System.out.println("");
        }

        Load okBagResult = Knapsack.okBags[Knapsack.itemCount][Knapsack.bagSize];
        System.out.println("最终结果为:" + okBagResult.items.toString() + okBagResult);
        
	}

}
