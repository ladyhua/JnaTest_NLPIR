package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import code.TestOneFile;

public class LoadResult {
	
	public static void main(String[] args) throws Exception  {
		File file=new File("D:\\SogouData\\trainandtest\\result_4_2.txt");
		String txt=TestOneFile.loadFile(file);
		txt.replaceAll("\r|\n", "");
		System.out.println(txt);
		String[] words=txt.split(".");
		System.out.println(words.length);
			int num1=0;
			int num2=0;
			int num3=0;
		    int num4=0;
			int num5=0;
			int num6=0;
			int num7=0;
			int num8=0;
			int num9=0;
			int num10=0;
		for(int i=0;i<words.length;i++){
			words[i]=words[i].trim();
			System.out.print(words[i]);
			if(words[i].equals("01")){
				num1++;
			}else if(words[i].equals("02")){
				num2++;
			}else if(words[i].equals("03")){
				num3++;
			}else if(words[i].equals("04")){
				num4++;
			}else if(words[i].equals("05")){
				num5++;
			}else if(words[i].equals("06")){
				num6++;
			}else if(words[i].equals("07")){
				num7++;
			}else if(words[i].equals("08")){
				num8++;
			}else if(words[i].equals("09")){
				num9++;
			}else if(words[i].equals("010")){
				num10++;
			}else{
				System.out.println("error");
			}
		}
		System.out.println(num1+";"+num2+";"+num3+";"+num4+";"+num5+";"+num6+";"+num7+";"+num8+";"+num9+";"+num10);
		
	}
	private static void print(int labal,int num1,int num2,int num3,int num4,int num5,int num6,int num7,int num8,int num9,int num10) throws IOException {
		// TODO Auto-generated method stub
		String temp="在第"+labal+"类别中:";
		System.out.println(temp);
		temp+="被判别为第1类文档的文档数为"+num1+"    被判别为第2类文档的文档数为"+num2+"    被判别为第3类文档的文档数为"+num3+
				"    被判别为第4类文档的文档数为"+num4+"    被判别为第5类文档的文档数为"+num5+"    被判别为第6类文档的文档数为"
				+num6+"    被判别为第7类文档的文档数为"+num7+"    被判别为第8类文档的文档数为"+num8+"    被判别为第9类文档的文档数为"+num9+
				"    被判别为第10类文档的文档数为"+num10;
		File file=new File("D:\\SogouData\\trainandtest\\result_4_fina.txt");
		FileOutputStream fos=new FileOutputStream(file,true);
		fos.write(temp.getBytes());
		String newline = System.getProperty("line.separator");
		fos.write(newline.getBytes());
		fos.flush();
		fos.close();
	}
}
