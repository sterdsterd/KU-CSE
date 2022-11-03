package ywrhee.midtest;

import java.util.Iterator;

public class YwrheeTestMain {
	public static void main(String[] args) {
		System.out.println("1) 202211342 ������");
		
		System.out.println("2) Contents ��ü ���� �� ����ϱ�");
		YwrheeContents c1 = new YwrheeContents("��ȭ1", 1000);
		System.out.println(c1);
		
		System.out.println("3) Drama ��ü ���� �� ����ϱ�");
		YwrheeContents c2 = new YwrheeDrama("���1-1", 2000, 0.25);
		System.out.println(c2);
		
		System.out.println("4) Movie ��ü ���� �� ����ϱ�");
		YwrheeContents c3 = new YwrheeMovie("��ȭ2", 2000, 19);
		System.out.println(c3);
		
		System.out.println("5) TV ��ü �����ϱ�");
		//YwrheeTV tempTVTv = new YwrheeTV(5);
		YwrheeTV ywrheeTV = YwrheeTV.getInstance(5);
		
		System.out.println("6) ������ �߰��ϱ�");
		ywrheeTV.addContent(new YwrheeDrama("���1-1", 2000, 0.3));
		ywrheeTV.addContent(new YwrheeDrama("���1-2", 2000, 0.0));
		ywrheeTV.addContent(new YwrheeDrama("���1-2", 2000, 0.25));
		ywrheeTV.addContent(new YwrheeMovie("��ȭ2", 2000, 19));
		ywrheeTV.addContent(new YwrheeMovie("��ȭ3", 1000, 10));
		ywrheeTV.addContent(new YwrheeDrama("���2-1", 1000, 0.1));
		ywrheeTV.addContent(new YwrheeMovie("��ȭ4", 1000, 15));
		
		System.out.println("7) ������ Ÿ��Ʋ�� �˻��ϱ�");
		YwrheeContents content1 = ywrheeTV.searchContents("���1-1");
		YwrheeContents content2 = ywrheeTV.searchContents("��ȭ2");
		YwrheeContents content3 = ywrheeTV.searchContents("��ȭ3");
		YwrheeContents content4 = ywrheeTV.searchContents("���1-2");
		YwrheeContents content5 = ywrheeTV.searchContents("���2-1");
		
		System.out.println("8) Client ��ü ���� �� ����ϱ�");
		YwrheeClient gdhong = new YwrheeClient("ȫ�浿", 10, 3);
		System.out.println(gdhong);
		YwrheeClient gdkim = new YwrheeClient("��浿", 25, 4);
		YwrheeClient gdlee = new YwrheeClient("�̱浿", 42, 3);
		
		System.out.println("9) ������ �ٿ�ε��ϱ�");
		gdhong.downloadContents(content1);
		gdhong.downloadContents(content2);
		gdhong.downloadContents(content3);
		gdhong.downloadContents(content3);
		gdhong.downloadContents(content4);
		gdhong.downloadContents(content5);
		System.out.println("--------------------");
		gdkim.downloadContents(content3);
		gdlee.downloadContents(content4);
		
		System.out.println("10) �ٿ�ε����� Client ��ü ����ϱ�");
		System.out.println(gdhong);
		
		System.out.println("11) Client���� �ٿ�ε� ȸ���� ���� ������ 3�� ��õ�ϱ�");
		YwrheeContents[] rmdContents = ywrheeTV.recommandContents(gdhong);
		if (rmdContents != null) {
			for (int i = 0; i < rmdContents.length; i++) {
				System.out.println(rmdContents[i]);
			}
			
		}
	}
}
