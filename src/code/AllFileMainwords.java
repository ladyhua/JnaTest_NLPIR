package code;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AllFileMainwords {
	public static Map<String,Term> allTerm_08=new HashMap<String,Term>();
	public static Map<String,Term> nounTerm_08=new HashMap<String,Term>();
	public static Map<String,Term> mainTerm_08=new HashMap<String,Term>();
	public static void main(String[] args) throws Exception{
	  String labal=null;
	 for(int j=0;j<2;j++){
		   if(j==0){
			   labal="09";
		   }else{
			   labal="10";
		   }
		File file=new File("D:\\SogouData\\trainingwords\\trainingwords\\C"+labal);
		File[] list=file.listFiles();
		for(int i=0;i<list.length;i++){
			//System.out.println(list[i].getAbsolutePath());
			TestOneFile tof=new TestOneFile();
			String txt=tof.loadFile(list[i]);
			String nativeBytes=tof.wordCut(txt);
			allTerm_08=tof.cutWord(nativeBytes,allTerm_08);
		}
		TestOneFile tof=new TestOneFile();
		nounTerm_08=tof.tiNoun(allTerm_08);
		DelStopWords dsw=new DelStopWords();
		dsw.loadStopWords();
		Map<String,Term> mainTerm_08=dsw.delStopWords(nounTerm_08);
		System.out.println();
		for(String word:mainTerm_08.keySet()){
			System.out.print(word+" ");
		}
		System.out.println();
		System.out.println(mainTerm_08.size());
		int labalInt=Integer.parseInt(labal);
		Map<String,Term> tempTerms_08=ComputeCHIAndIDF.computeCHI(labalInt, mainTerm_08);
		Iterator<Entry<String, Term>> iter=tempTerms_08.entrySet().iterator();
		while(iter.hasNext()){
			Entry<String, Term> entry = iter.next();
			System.out.println(entry.getValue().getWord()+"|||"+entry.getValue().getChi()+"|||"+entry.getValue().getIdf());
		}
		List<Term> teZhengList=new ArrayList();
		CHISort cs=new CHISort();
		teZhengList=cs.chiSort(tempTerms_08);
		ListToTxt ltt=new ListToTxt();
		ltt.listToTxt(teZhengList,labal,j);
	  }
   }
}
