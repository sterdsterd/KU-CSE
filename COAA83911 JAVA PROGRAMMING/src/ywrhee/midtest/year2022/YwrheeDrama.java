package ywrhee.midtest;

public class YwrheeDrama extends YwrheeContents {
	
	private double discountRate;
	
	public YwrheeDrama(String title, int price, double discountRate) {
		super(title, price);
		this.discountRate = discountRate;
	}
	
	@Override
	public String toString() {
		String str = super.toString();
		str += "������ : " + (discountRate * 100) + "%\n";
		str += "--------------------\n";
		
		return str;
	}
	
	@Override
	public void addDownloads() {
		super.addDownloads();
		setTotalPrice((int) (getTotalPrice() * (1 - discountRate)));
	}
	
}
