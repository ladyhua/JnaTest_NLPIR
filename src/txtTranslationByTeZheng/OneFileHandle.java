package txtTranslationByTeZheng;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import code.SortById;
import code.Term;
import code.TestOneFile;

public class OneFileHandle {
	public static List<Term> oneFileHandle(File file,Map<String,Term> terms) throws Exception{
		TestOneFile tof=new TestOneFile();
		String txt=tof.loadFile(file);
		String nativeBytes=tof.wordCut(txt);
		List<String> wordList=new ArrayList<String>();
		/*Iterator<Entry<String, Term>> iter=terms.entrySet().iterator();
		while(iter.hasNext()){
			Entry<String, Term> entry = iter.next();
			System.out.println(entry.getValue().getWord()+"|||"+entry.getValue().getChi()+"|||"+entry.getValue().getIdf());
		}*/
		String[] rawWords=nativeBytes.split("\\s+");
		for(String rawWord:rawWords){
			String[] words=rawWord.split("/");
			if(words.length==2){
				String word=words[0].trim();
				wordList.add(word);
			}
		}
		double N=wordList.size();
		for(String word:wordList){
			Term term=terms.get(word);
			if(term!=null){
				term.icrFreq();
			}
		}
		List<Term> list=new ArrayList<Term>();
		Iterator<Entry<String, Term>> iters=terms.entrySet().iterator();
		//把map中的term拿出来加到list中
		while(iters.hasNext()){
			Entry<String, Term> entry = iters.next();
			list.add(entry.getValue());
		}
		for(int i=0;i<list.size();i++){
			list.get(i).setTf(list.get(i).getFreq()/N);
			list.get(i).setTfidf(list.get(i).getTf()*list.get(i).getIdf());
		}
		System.out.println("tfidf compute success");
		return list;
	}
	
	//test
	public static void main(String[] args) throws Exception{
		Map<String,Term> terms=LoadWordDictionary.loadWordDictionary();
		File file=new File("D:\\SogouData\\testingwords\\testingwords\\C01\\0.txt");
		List<Term> list=oneFileHandle(file,terms);
		List<Term> finalList=SortById.sort(list);
		PrintFileTfidf.printFileTfidf(finalList,1,0);
		PrintToTrainingHeart_Scale.print(finalList,1);
	}
}
