import java.util.Scanner;
import java.util.Stack;

public class SearchMazePath {
	private Stack<MazeCell> pathStack=new Stack<>();	//保存迷宫路径
	
	private int[][]maze;		//存储迷宫
	private boolean mark=false;	//标记
	private MazeCell startCell;
	private MazeCell endCell;
	
	public SearchMazePath(){
		initialMaze();
	}
	public void findPath(){
		assert mark;
		processCell(startCell.getX(),startCell.getY(),startCell.getStep());
	}
	private void processCell(int x,int y,int step){
		if(x==endCell.getX()&&y==endCell.getY()){
			pathStack.pop();
			printPath();
			System.out.println("("+endCell.getX()+","+endCell.getY()+")");
			return;
		}
		test(x,y-1,step+1);
		test(x,y+1,step+1);
		test(x-1,y,step+1);
		test(x+1,y,step+1);
	}
	private void test(int x,int y,int step){
		if(cango(x,y)){
			MazeCell mazecell=new MazeCell(x,y,step);
			insertToPath(mazecell);
			processCell(x,y,step);
			
		}
	}
	private void printPath(){
		for(int i=0;i<pathStack.size();i++){
			MazeCell cell=pathStack.get(i);
			System.out.println("("+cell.getX()+","+cell.getY()+")->");
		}
	}
	private void insertToPath(MazeCell mazecell){
		while(pathStack.peek().getStep()>=mazecell.getStep()){
			pathStack.pop();
		}
		pathStack.push(mazecell);
	}
	private boolean cango(int x,int y){
		if(maze[x][y]==1){
			return false;
		}
		for(int i=0;i<pathStack.size();i++){
			MazeCell mazecell=pathStack.get(i);
			if(mazecell.getX()==x&&mazecell.getY()==y){
				return false;
			}
		}
		return true;
	}
	
	private void initialMaze(){
		int column;
		int row;
		Scanner scanner=new Scanner(System.in);
		int temp=0;
		do{
			System.out.println("请输入迷宫行数(>0)");
			temp=scanner.nextInt();
		}while(temp<=0);
		row=temp;
		do{
			System.out.println("请输入迷宫列数(>0)");
			temp=scanner.nextInt();
		}while(temp<=0);
		column=temp;
		maze=new int[row+2][column+2];
		System.out.println("请输入迷宫(1为墙，0为通道，-1为起点，2为终点)");
		for(int i=0;i<column+2;i++){
			maze[0][i]=1;
		}
		for(int i=1;i<row+1;i++){
			maze[i][0]=1;
			for(int j=1;j<column+1;j++){
				temp=scanner.nextInt();
				switch(temp){
					case -1:
						startCell=new MazeCell(i,j,0);
						maze[i][j]=temp;
						pathStack.push(startCell);
						break;
					case 2:
						endCell=new MazeCell(i,j,-1);
					case 1:
					case 0:
						maze[i][j]=temp;
						break;
					default:
						System.out.println("输入不符合要求");
						return;
				}
			}
			maze[i][column+1]=1;
		}
		for(int i=0;i<column+2;i++){
			maze[row+1][i]=1;
		}
		if(startCell!=null&&endCell!=null){
			mark=true;
			System.out.println("输入成功");
		}else{
			System.out.println("至少要有一个起点和一个终点");
		}
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchMazePath searchpath=new SearchMazePath();
		searchpath.findPath();
	}

}
