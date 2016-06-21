package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CHISort {
	public static List<Term> chiSort(Map<String,Term> terms){
		List<Term> list=new ArrayList<Term>();
		Iterator<Entry<String, Term>> iter=terms.entrySet().iterator();
		while(iter.hasNext()){
			Entry<String, Term> entry = iter.next();
			list.add(entry.getValue());
		}
		Comparator<Term> comparator=new Comparator<Term>(){
			public int compare(Term t1,Term t2){
				if(t1.getChi()>t2.getChi()){
					return -1;
				}else if(t1.getChi()==t2.getChi()){
					return 0;
				}else{
					return 1;
				}
			}
		};
		System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");  
		Collections.sort(list,comparator);
		System.out.println("sort success");
		return list;
	}
	
	//test
	public static void main(String[] args){
		Map<String,Term> terms=new HashMap<String,Term>();
		for(int i=0;i<1000;i++){
			Term term=new Term("word"+i);
			term.setChi(i);
			terms.put("word"+i, term);
		}
		List<Term> list=chiSort(terms);
		for(int i=0;i<500;i++){
			System.out.println(list.get(i).getWord());
		}
	}
}
