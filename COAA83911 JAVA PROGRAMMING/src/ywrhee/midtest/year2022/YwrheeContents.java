package ywrhee.midtest.year2022;

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
        String str = "타이틀 : " + title + "\n";
        str += "가격 : " + price + "\n";
        str += "다운로드 수 : " + downloads + "\n";
        str += "총 판매가격 : " + totalPrice + "\n";

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
