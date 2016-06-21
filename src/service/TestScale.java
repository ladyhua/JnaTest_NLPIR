package service;

import java.io.IOException;

public class TestScale {
	public static void main(String[] args) throws IOException{
		String[] testArgs = {"-l","0", "-u","1","-s","chao-test-scale","D:\\SogouData\\trainheart_scale.txt"};  
        svm_scale.main(testArgs);  
        String[] argvScaleTest ={"-r","chao-test-scale","D:\\SogouData\\testheart_scale.txt"};  
        svm_scale.main(testArgs);  
	}
}
