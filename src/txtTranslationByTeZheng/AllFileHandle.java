package txtTranslationByTeZheng;

import java.io.File;
import java.util.List;
import java.util.Map;

import code.SortById;
import code.Term;

public class AllFileHandle {
	public static void allFileHandle() throws Exception{
		File file=new File("D:\\SogouData\\testingwords\\testingwords");
		File[] files=file.listFiles();
		for(int i=0;i<files.length;i++){
			String path=files[i].getAbsolutePath();
			String labal=path.substring(path.length()-2);
			int labalInt=Integer.parseInt(labal);
			File[] filess=files[i].listFiles();
			for(int j=0;j<filess.length;j++){
				Map<String,Term> terms=LoadWordDictionary.loadWordDictionary();
				List<Term> list=OneFileHandle.oneFileHandle(filess[j],terms);
				List<Term> finalList=SortById.sort(list);
				//PrintFileTfidf.printFileTfidf(finalList,labalInt,j);
				PrintToTrainingHeart_Scale.print(finalList,labalInt);
				
			}
		}
	}
	
	//test
	public static void main(String[] args){
		try {
			allFileHandle();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
