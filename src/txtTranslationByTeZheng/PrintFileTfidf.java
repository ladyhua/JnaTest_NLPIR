package txtTranslationByTeZheng;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import code.Term;

public class PrintFileTfidf {
	public static void printFileTfidf(List<Term> list,int labal,int fileId){
		PrintWriter writer;
		try {
			writer=new PrintWriter(new FileWriter("D:\\SogouData\\testingwords\\tfidf\\"+labal+"_"+fileId+".txt"));
			for(int i=0;i<list.size();i++){
				writer.println(list.get(i).getWord()+"     "+list.get(i).getId()+"                 "+list.get(i).getTf()+"            "+list.get(i).getIdf()+"                           "+list.get(i).getTfidf());
				
						
			}
			System.out.println("C"+labal+"文件夹下的"+fileId+".txt文件保存tfidf成功");
			writer.println();
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
