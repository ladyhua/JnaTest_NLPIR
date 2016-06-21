package txtTranslationByTeZheng;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import code.Term;

public class PrintToTrainingHeart_Scale {
	public static void print(List<Term> list,int labal) throws IOException{
		String txt=labal+" ";
		for(int i=0;i<list.size();i++){
			if(list.get(i).getTfidf()!=0){
				txt=txt+list.get(i).getId()+":"+list.get(i).getTfidf()*100+" ";
			}
		}
		File file=new File("D:\\SogouData\\trainandtest\\testData4_"+labal+".txt");
		FileOutputStream fos=new FileOutputStream(file,true);
		fos.write(txt.getBytes());
		String newline = System.getProperty("line.separator");
		fos.write(newline.getBytes());
		System.out.println("文件写入最终文件成功"+"|||"+labal);
		fos.flush();
		fos.close();
	}
}
