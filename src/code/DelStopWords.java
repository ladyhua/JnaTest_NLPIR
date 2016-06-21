package code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;



public class DelStopWords {
	private static Set<String> stopWords=new HashSet<String>();
	public static void loadStopWords() throws IOException{
		File file=new File("D:\\SogouData\\中文停用词表.txt");
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
		String word=null;
		while((word=br.readLine())!=null){
			word=word.trim();
			if(word!=null){
				if(!stopWords.contains(word)){
					stopWords.add(word);
				}
			}
		}
		br.close();
		//System.out.print(stopWords);
	}
	//entry.getValue().getWord())||entry.getKey().matches("\\s+")||entry.getKey().matches("nbsp[^\\s]+")||entry.getValue().getWord()==null||entry.getValue().getWord().length()<=1||entry.getValue().getWord().matches("[a-zA-Z0-9]*")||!entry.getValue().getWord().matches("^[\u4e00-\u9fa5]{2,5}$")
	public static Map<String,Term> delStopWords(Map<String,Term> terms){
		Iterator<Entry<String, Term>> iter = terms.entrySet().iterator();
		while(iter.hasNext()) {
			Entry<String, Term> entry = iter.next();
			if(stopWords.contains(entry.getValue().getWord())) {
				iter.remove();
			}
		}
		return terms;
	}
	public static Set<String> getStopWords() {
		return stopWords;
	}
	public static void setStopWords(Set<String> stopWords) {
		DelStopWords.stopWords = stopWords;
	}
	
}
