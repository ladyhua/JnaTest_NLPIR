package txtTranslationByTeZheng;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import code.Term;

public class LoadWordDictionary {
	public static Map<String, Term> loadWordDictionary() throws IOException{
		Map<String,Term> terms=new HashMap<String,Term>();
		List<Term> list=new ArrayList<Term>();
		File file=new File("D:\\SogouData\\1000dictionary\\dic_idf_new.txt");
		InputStreamReader read=new InputStreamReader(new FileInputStream(file),"GBK");
		BufferedReader br=new BufferedReader(read);
		String temp="";
		while((temp=br.readLine())!=null){
			String[] words=temp.split("\\s+");
			if(words.length==3){
				String word0=words[0];
				//System.out.println(word0);
				String word1=words[1];
				//System.out.println(word1);
				String word2=words[2];
				//System.out.println(word2);
				Term term=terms.get(word0);
				if(term==null){
					term=new Term(word0);
					term.setId(Integer.parseInt(word1));
					term.setIdf(Double.parseDouble(word2));
					terms.put(word0, term);
					list.add(term);
				}
			}
		}
		br.close();
		return terms;
	}

	
	//test
	public static void main(String[] args){
		List<Term> list=new ArrayList<Term>();
		Map<String,Term> terms=new HashMap<String,Term>();
		try {
			terms=loadWordDictionary();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<Entry<String, Term>> iter=terms.entrySet().iterator();
		while(iter.hasNext()){
			Entry<String, Term> entry = iter.next();
			list.add(entry.getValue());
		}
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getWord()+"   "+list.get(i).getId()+"    "+list.get(i).getIdf());
		}
		System.out.println(list.size());
	}
}
