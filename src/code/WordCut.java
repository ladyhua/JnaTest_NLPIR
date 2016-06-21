package code;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WordCut {
	public static Map<String,Term> allTerm=new HashMap<String,Term>();

	public static void main(String[] args) throws Exception{
		
	
		File file=new File("D:\\SogouData\\testingwords\\testingwords");
		File[] files=file.listFiles();
		for(int i=0;i<files.length;i++){
			String path=files[i].getAbsolutePath();
			String labal=path.substring(path.length()-2);
			int labalInt=Integer.parseInt(labal);
			File[] filess=files[i].listFiles();
			for(int j=0;j<filess.length;j++){
				TestOneFile tof=new TestOneFile();
				String txt=tof.loadFile(filess[j]);
				String nativeBytes=tof.wordCut(txt);
				allTerm=tof.cutWord(nativeBytes,allTerm);
				print(allTerm,labalInt,j+2000);
			}
		}
	}

	private static void print(Map<String, Term> terms, int labalInt, int j) {
		// TODO Auto-generated method stub
		List<Term> list=new ArrayList<Term>();
		Iterator<Entry<String, Term>> iter=terms.entrySet().iterator();
		while(iter.hasNext()){
			Entry<String, Term> entry = iter.next();
			list.add(entry.getValue());
		}
		PrintWriter writer;
		try {
			writer=new PrintWriter(new FileWriter("D:\\SogouData\\trainingwords\\特征向量_"+labalInt+"_"+j+".txt"));
			for(int i=0;i<list.size();i++){
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
	
}