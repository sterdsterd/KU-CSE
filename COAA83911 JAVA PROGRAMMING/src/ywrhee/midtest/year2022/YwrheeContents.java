package ywrhee.midtest;

public class YwrheeContents {
	
	private String title;
	private int price;
	private int downloads;
	private int totalPrice;
	
	public YwrheeContents(String title, int price) {
		this.title = title;
		this.price = price;
	}
	
	@Override
	public String toString() {
		String str = "Ÿ��Ʋ : " + title + "\n";
		str += "���� : " + price + "\n";
		str += "�ٿ�ε� �� : " + downloads + "\n";
		str += "�� �ǸŰ��� : " + totalPrice + "\n";
		
		return str; 
	}
	
	public String getTitle() {
		return title;
	}
	
	public void addDownloads() {
		setDownloads(getDownloads() + 1);
		setTotalPrice(getPrice() * getDownloads());
	}

	public int getPrice() {
		return price;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}

	public int getDownloads() {
		return downloads;
	}

	protected void setDownloads(int downloads) {
		this.downloads = downloads;
	}

	protected void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


}
