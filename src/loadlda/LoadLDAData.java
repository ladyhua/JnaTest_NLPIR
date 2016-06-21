package loadlda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class LoadLDAData {
	public static void main(String[] args) throws IOException{
	List<List<Double>> lists=new ArrayList<List<Double>>();
	
	File file=new File("D:\\SogouData\\trainingwords\\trainlda\\model-final.theta");
	InputStreamReader read=new InputStreamReader(new FileInputStream(file),"GBK");
	BufferedReader br=new BufferedReader(read);
	String temp="";
	int i=1;
	while((temp=br.readLine())!=null){
		List<Double> list=new ArrayList<Double>();
		String[] words=temp.split("\\s+");
		for(int j=0;j<words.length;j++){
			list.add(Double.parseDouble(words[j]));
		}
		lists.add(list);
		print(list,i);
		i++;
	}
	System.out.println(i);
	}

	private static void print(List<Double> list, int i) throws IOException {
		// TODO Auto-generated method stub
		
		int labal;
		if(i>0&&i<1001){
			labal=1;
		}else if(i>1000&&i<2001){
			labal=2;
		}else if(i>2000&&i<3001){
			labal=3;
		}else if(i>3000&&i<4001){
			labal=4;
		}else if(i>4000&&i<5001){
			labal=5;
		}else if(i>5000&&i<6001){
			labal=6;
		}else if(i>6000&&i<7001){
			labal=7;
		}else if(i>7000&&i<8001){
			labal=8;
		}else if(i>8000&&i<9001){
			labal=9;
		}else{
			labal=10;
		}
		String temp=labal+" ";
		for(int j=0;j<list.size();j++){
			temp=temp+(j+1)+":"+list.get(j)+" ";
		}
		File file=new File("D:\\SogouData\\trainandtest\\trainData6.txt");
		FileOutputStream fos=new FileOutputStream(file,true);
		fos.write(temp.getBytes());
		String newline = System.getProperty("line.separator");
		fos.write(newline.getBytes());
		System.out.println("文件写入最终文件成功"+"|||"+i);
		fos.flush();
		fos.close();
	}


}
