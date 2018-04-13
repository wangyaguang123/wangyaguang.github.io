import java.io.File;
import java.io.IOException;

public class fileshow {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File f=new File("E:\\movie");
		showDir(1,f);
	}
	public static void showDir(int indent,File file)throws IOException{
		for(int i=0;i<indent;i++)
			System.out.print('—');
		System.out.println(file.getName());
		if(file.isDirectory())
		{
			File[] files=file.listFiles();
			for(int i=0;i<files.length;i++)
				showDir(indent+4, files[i]);
		}
	}

}
