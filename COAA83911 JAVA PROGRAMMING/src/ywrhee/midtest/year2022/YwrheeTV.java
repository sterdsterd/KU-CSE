package ywrhee.midtest;

import java.util.Iterator;

public class YwrheeTV {

	private int contentsNum;
	private YwrheeContents[] contents;
	private int count = 0;
	
	
	
	private static YwrheeTV singleton;
	
	
	private YwrheeTV(int contentsNum) {
		this.contentsNum = contentsNum;
		this.contents = new YwrheeContents[this.contentsNum];
		
	}

	static YwrheeTV getInstance(int contentsNum) {
		singleton = new YwrheeTV(contentsNum);
		return singleton;
	}
	
	public void addContent(YwrheeContents content) {
		for (int i = 0; i < count; i++) {
			if (contents[i].getTitle().equals(content.getTitle())) {
				System.out.println("Ÿ��Ʋ�� ���� ��ǰ�� ��ϵǾ� �ֽ��ϴ�.");
				return;
			}
		}
		
		if (count >= contentsNum) {
			System.out.println("���̻� �߰��� �� �����ϴ�.");
			return;
		}
		
		contents[count++] = content;
		System.out.println("����� �Ϸ�Ǿ����ϴ�.");
	}
	
	public YwrheeContents searchContents(String title) {
		for (int i = 0; i < count; i++) {
			if (contents[i].getTitle().equals(title)) {
				return contents[i];
			}
		}
		
		return null;
	}
	
	public YwrheeContents[] recommandContents(YwrheeClient client) {
		YwrheeContents[] recommendContents = new YwrheeContents[3];
		int count = 0;
		
		for (int i = 0; i < contents.length; i++) {
			for (int j = 0; j < i; j++) {
				if (contents[j].getDownloads() < contents[j + 1].getDownloads()) {
					YwrheeContents swap = contents[j];
					contents[j] = contents[j + 1];
					contents[j + 1] = swap;
				}
			}
			
		}

		for (YwrheeContents content : contents) {
			boolean isRecommendable = true;
			
			if (content instanceof YwrheeMovie
				&& ((YwrheeMovie) content).getAgeRestrict() > client.getAge()) {
				isRecommendable = false;
			}
			
			for (int i = 0; i < client.getCount() && isRecommendable; i++) {
				if (client.getDownloadedContents()[i] == content)
					isRecommendable = false;
			}
			
			if (isRecommendable && count < 3) recommendContents[count++] = content; 
		}
		
		
		// Resizing array to prevent printing null
		YwrheeContents[] rmdContents = new YwrheeContents[count];
		for (int i = 0; i < count; i++) {
			rmdContents[i] = recommendContents[i];
		}
		
		return rmdContents;
		
	}
	
}
