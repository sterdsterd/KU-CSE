package ywrhee.midtest;

public class YwrheeClient {
	
	private String name;
	private int age;
	private int downloadableNum;
	
	private YwrheeContents[] downloadedContents;
	private int count = 0;
	
	public YwrheeClient(String name, int age, int downloadableNum) {
		this.name = name;
		this.age = age;
		this.downloadableNum = downloadableNum;
		downloadedContents = new YwrheeContents[this.downloadableNum];
	}
	
	public void downloadContents(YwrheeContents content) {
		if (content instanceof YwrheeMovie
				&& ((YwrheeMovie) content).getAgeRestrict() > age) {
			System.out.println("������������ �ٿ�ε���� �ʾҽ��ϴ�.");
			return;
		}
		
		
		for (int i = 0; i < count; i++) {
			if (downloadedContents[i] == content) {
				System.out.println("�̹� �ٿ�ε� �Ϸ�� ��ǰ�Դϴ�.");
				return;
			}
		}
		
		if (count >= downloadableNum) {
			System.out.println("���̻� �ٿ�ε��Ͻ� �� �����ϴ�.");
			return;
		}
		
		content.addDownloads();
		downloadedContents[count++] = content;
		System.out.println("�ٿ�ε� �Ϸ��Ͼ����ϴ�.");
	}
	
	@Override
	public String toString() {
		String str = "�̸� : " + name + "\n";
		str += "���� : " + age + "\n";
		str += "--------------------\n";
		if (count == 0) {
			str += "���� �ٿ�ε�� �������� �����ϴ�.";
		} else {
			for (YwrheeContents content : downloadedContents) {
				str += content;
			}
		}
		
		return str;
	}
	
	public YwrheeContents[] getDownloadedContents() {
		return downloadedContents;
	}
	
	public int getCount() {
		return count;
	}
	
	public int getAge() {
		return age;
	}
}
