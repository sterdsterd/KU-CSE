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
			System.out.println("나이제한으로 다운로드되지 않았습니다.");
			return;
		}
		
		
		for (int i = 0; i < count; i++) {
			if (downloadedContents[i] == content) {
				System.out.println("이미 다운로드 완료된 작품입니다.");
				return;
			}
		}
		
		if (count >= downloadableNum) {
			System.out.println("더이상 다운로드하실 수 없습니다.");
			return;
		}
		
		content.addDownloads();
		downloadedContents[count++] = content;
		System.out.println("다운로드 완료하었습니다.");
	}
	
	@Override
	public String toString() {
		String str = "이름 : " + name + "\n";
		str += "나이 : " + age + "\n";
		str += "--------------------\n";
		if (count == 0) {
			str += "아직 다운로드된 컨텐츠가 없습니다.";
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
