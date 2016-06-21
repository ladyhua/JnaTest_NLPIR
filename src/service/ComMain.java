package service;

import java.io.IOException;

public class ComMain {
	public static void main(String[] args) throws IOException{
		String[] arg={"-h","0","-t","0","D:\\SogouData\\trainandtest\\trainData4.txt","D:\\SogouData\\trainandtest\\model_4.txt"};
		//System.out.println("........SVM运行开始..........");
		//for(int i=1;i<11;i++){
		//String[] parg={"D:\\SogouData\\trainandtest\\testData4_"+i+".txt","D:\\SogouData\\trainandtest\\model_4.txt","D:\\SogouData\\trainandtest\\result_4_"+i+".txt"};
		//System.out.print("第"+i+"类文档开始测试");
		// 创建一个训练对象
		svm_train t = new svm_train();
		// 创建一个预测或者分类的对象
		svm_predict p = new svm_predict();
		t.main(arg); // 调用
		//System.out.print("第"+i+"类文档召回率为：");
		//p.main(parg); // 调用
	}
		//}
}
