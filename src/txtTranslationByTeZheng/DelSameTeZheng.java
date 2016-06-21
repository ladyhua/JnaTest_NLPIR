package txtTranslationByTeZheng;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import code.Term;

public class DelSameTeZheng {
	public static void delSameTeZheng(List<Term> list){
		
		
		PrintWriter writer;
		try {
			writer=new PrintWriter(new FileWriter("D:\\SogouData\\trainingwords\\特征向量_去重复.txt"));
			for(int i=0;i<list.size();i++){
				writer.println(list.get(i).getWord()+"     "+list.get(i).getId()+"                                                               "+list.get(i).getIdf());
				
						
			}
			writer.println();
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
