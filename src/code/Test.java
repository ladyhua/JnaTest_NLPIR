package code;

import java.io.IOException;

public class Test {
	 
	    public static void main(String[] args) {
	        DelStopWords dsw=new DelStopWords();
	        try {
				dsw.loadStopWords();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
}

