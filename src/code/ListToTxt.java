package code;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ListToTxt {
	public static void listToTxt(List<Term> list,String labal,int j){
		
		
		PrintWriter writer;
		try {
			writer=new PrintWriter(new FileWriter("D:\\SogouData\\trainingwords\\特征向量_"+labal+".txt"));
			for(int i=0;i<500;i++){
				writer.println(list.get(i).getWord()+"     "+(i+1+4000+j*500)+"                                                               "+list.get(i).getIdf());
				
						
			}
			writer.println();
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//test
	/*public static void main(String[] args){
		List<Term> list=new ArrayList();
		for(int i=0;i<1000;i++){
			Term t=new Term("word"+i);
			t.setIdf(i);
			list.add(t);
		}
		listToTxt(list);
	}*/
}
