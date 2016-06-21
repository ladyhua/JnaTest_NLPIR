package code;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;



public class ComputeCHIAndIDF {
	private static int N=10000;   //docCount
	public static Map<String,Term> computeCHI(int labal,Map<String,Term> terms) throws Exception{
		Iterator<Entry<String, Term>> iter=terms.entrySet().iterator();
		while(iter.hasNext()){
			Entry<String, Term> entry = iter.next();
			String word=entry.getValue().getWord();//取关键词
			File file=new File("D:\\SogouData\\trainingwords\\trainingwords");
			File[] files=file.listFiles();
			int A=0;	//docContainWordInLabal
			int B=0;	//docContainWordNotInLabal
			int C=0;	//docNotContainWordInLabal
			int D=0;	//docNotContainWordNotInLabal
			for(int i=0;i<files.length;i++){
				File[] filess=files[i].listFiles();
				String path=files[i].getAbsolutePath();
				int nowlabal=Integer.parseInt(path.substring(path.length()-2));
				//System.out.println(nowlabal);
				for(int j=0;j<filess.length;j++){
					TestOneFile tof=new TestOneFile();
					String txt=tof.loadFile(filess[j]);
					if(labal==nowlabal){
						if(txt.contains(word)){
							A++;
						}else{
							C++;
						}
					}else{
						if(txt.contains(word)){
							B++;
						}else{
							D++;
						}
					}
				}
			}
			double chi=chiCompute(A,B,C,D);
			double idf=idfCompute(A,B);
			System.out.println((A+" "+B+" "+C+" "+D));
			System.out.println(entry.getValue().getWord()+"|||"+labal);
			
			entry.getValue().setChi(chi);
			entry.getValue().setIdf(idf);
		}
		return terms;
	}

	private static double idfCompute(int a, int b) {
		double a1=a;
		double b1=b;
		double temp=N/(a1+b1)+0.01;
		//System.out.println(temp);
		double idf=Math.log(temp);
		System.out.println("idfCompute success"+idf);
		return idf;
	}

	private static double chiCompute(int a1, int b1, int c1, int d1) {
		// TODO Auto-generated method stub
		double a=a1;
		double b=b1;
		double c=c1;
		double d=d1;
		double temp1=(a*d-c*b)*(a*d-c*b)*N;
		double temp2=(a+c)*(b+d)*(a+b)*(c+d);
		double chi=temp1/temp2;
		System.out.println("chiCompute Success"+chi);
		return chi;
	}

	//test
	public static void main(String[] args) throws Exception{
		double idf=idfCompute(10,90);
		System.out.println(idf);
		chiCompute(26,924,329,7271);
	}
}
