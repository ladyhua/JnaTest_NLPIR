package code;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;



import com.sun.jna.Library;
import com.sun.jna.Native;

public class TestOneFile {
	public interface CLibrary extends Library {
		// 定义并初始化接口的静态变量
		CLibrary Instance = (CLibrary) Native.loadLibrary(
				"D:\\NLPIR\\lib\\win64\\NLPIR", CLibrary.class);
		
		public int NLPIR_Init(String sDataPath, int encoding,
				String sLicenceCode);
				
		public String NLPIR_ParagraphProcess(String sSrc, int bPOSTagged);
		public String NLPIR_GetLastErrorMsg();
		public void NLPIR_Exit();
	}
	
	public static String loadFile(File file) throws Exception{
		InputStreamReader reader=new InputStreamReader(new FileInputStream(file),"GBK");
		int fileLength=(int)file.length();
		char[] chars=new char[fileLength];
		reader.read(chars);
		String txt=String.valueOf(chars);
		return txt;
	}
	
	public static String wordCut(String txt){
		String argu = "D:\\NLPIR";
		String system_charset = "GBK";//GBK----0
		//String system_charset = "UTF-8";
		int charset_type = 1;
		
		int init_flag = CLibrary.Instance.NLPIR_Init(argu, charset_type, "0");
		String nativeBytes = null;

		if (0 == init_flag) {
			nativeBytes = CLibrary.Instance.NLPIR_GetLastErrorMsg();
			System.err.println("初始化失败！fail reason is "+nativeBytes);
			return nativeBytes;
		}

		//String nativeBytes = null;
		try {
			nativeBytes = CLibrary.Instance.NLPIR_ParagraphProcess(txt, 1);

			System.out.println("分词结果为： " + nativeBytes);
		}catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return nativeBytes;
	}
	//取名词
	public static Map<String,Term> tiNoun(Map<String,Term> terms ){
		//\s[\u4e00-\u9fa5]+/n\s
		
		/*Pattern pat=Pattern.compile("\\s[\u4e00-\u9fa5]+/n\\s");
		Matcher m=pat.matcher(nativeBytes);
		boolean b=m.find();
		System.out.println(b);
		String nounWords="";
		while(m.find()){
			//System.out.println(m.group());
			String s=m.group();
			s=s.substring(1, s.length()-3);
			nounWords=nounWords+s+" ";
		}
		System.out.println("本文中的名词有："+nounWords);
		return nounWords;*/
		Iterator<Entry<String, Term>> iter = terms.entrySet().iterator();
		while(iter.hasNext()) {
			Entry<String, Term> entry = iter.next();
			if(!entry.getValue().getLexicalCategory().equals("n")) {
				iter.remove();
			}
			
		}
		return terms;
	}
	
	public static Map<String,Term> cutWord(String nativeBytes,Map<String,Term> terms){
		String[] rawWords=nativeBytes.split("\\s+");
		for(String rawWord:rawWords){
			String[] words=rawWord.split("/");
			if(words.length==2){
				String word=words[0].trim();
				String lexicalCategory=words[1];
				Term term=terms.get(word);
				if(term==null){
					term=new Term(word);
					term.setLexicalCategory(lexicalCategory);
					terms.put(word, term);
				}
				term.icrFreq();
			}
		}
		return terms;
	}
	
	/*public static void main(String[] args) throws Exception{
		File file=new File("D:\\SogouData\\C000008\\10.txt");
		String txt=loadFile(file);
		String nativeBytes=wordCut(txt);
		Map<String,Term> terms=cutWord(nativeBytes);
		Map<String,Term> nounTerms=tiNoun(terms);
		DelStopWords dsw=new DelStopWords();
		dsw.loadStopWords();
		Map<String,Term> nounTerms_1=dsw.delStopWords(nounTerms);
		for(String word:nounTerms_1.keySet()){
			System.out.print(word+" ");
		}
	}*/
	
	/*public static void wordCutExceptCX(String nativeBytes) {
		nativeBytes=nativeBytes.replaceAll("/\\w+\\s", "  ");
		System.out.println(nativeBytes);
	}*/
}
