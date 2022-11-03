package ywrhee.midtest;

public class YwrheeMovie extends YwrheeContents {

	private int ageRestrict;
	
	public YwrheeMovie(String title, int price, int ageRestrict) {
		super(title, price);
		this.ageRestrict = ageRestrict;
	}
	
	@Override
	public String toString() {
		String str = super.toString();
		str += "나이제한 : " + ageRestrict + "\n";
		str += "--------------------\n";
		
		return str;
	}
	
	public int getAgeRestrict() {
		return ageRestrict;
	}
}
