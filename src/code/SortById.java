package code;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortById {
	public static List<Term> sort(List<Term>list){
		Comparator<Term> comparator=new Comparator<Term>(){
			public int compare(Term t1,Term t2){
				if(t1.getId()>t2.getId()){
					return 1;
				}else if(t1.getChi()==t2.getChi()){
					return 0;
				}else{
					return -1;
				}
			}
		};
		System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");  
		Collections.sort(list,comparator);
		System.out.println("sort success");
		return list;
	}
}
