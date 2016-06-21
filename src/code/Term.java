package code;

public class Term {
	private int id;
	private String word;
	private String lexicalCategory="unknown";
	private int freq;
	private double tf;
	private double idf;
	private double tfidf;
	private double chi;
	public Term(String word) {
		this.word=word;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getLexicalCategory() {
		return lexicalCategory;
	}
	public void setLexicalCategory(String lexicalCategory) {
		this.lexicalCategory = lexicalCategory;
	}
	public int getFreq() {
		return freq;
	}
	public void setFreq(int freq) {
		this.freq = freq;
	}
	public double getTf() {
		return tf;
	}
	public void setTf(double tf) {
		this.tf = tf;
	}
	public double getIdf() {
		return idf;
	}
	public void setIdf(double idf) {
		this.idf = idf;
	}
	public double getTfidf() {
		return tfidf;
	}
	public void setTfidf(double tfidf) {
		this.tfidf = tfidf;
	}
	public void icrFreq() {
		// TODO Auto-generated method stub
		freq++;
	}
	public double getChi() {
		return chi;
	}
	public void setChi(double chi) {
		this.chi = chi;
	}
	
	
}
