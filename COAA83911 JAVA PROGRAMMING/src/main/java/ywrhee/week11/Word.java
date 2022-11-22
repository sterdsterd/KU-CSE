package ywrhee.week11;

public class Word {
	String eng;
	String kor;
	int count = 0;
	
	public Word(String eng, String kor) {
		super();
		this.eng = eng;
		this.kor = kor;
	}

	public int getCount() {
		return count;
	}
	
	@Override
	public String toString() {
		return eng + " : " + kor;
	}
	
}
