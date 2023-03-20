package ywrhee.week11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

public class VocManager {
//	private final int CAPACITY = 100;
	private String userName;
	private ArrayList<Word> voc = new ArrayList<>();
//	private int number = 0;

	static Scanner scan = new Scanner(System.in);
	
	VocManager(String userName) {
		this.userName = userName;
	}
	
	void addWord(Word word) {
//		if(number < CAPACITY) {
			voc.add(word);
//			number++;
//		} else System.out.println("단어장에 더이상의 단어를 등록할 수 없습니다.");
	}
	
	void makeVoc(String fileName) {
		try(Scanner scan = new Scanner(new File(fileName))){
			while(scan.hasNextLine()) {
				String str = scan.nextLine();
				ArrayList<String> temp = new ArrayList<>(Arrays.asList(str.split("\t")));
				this.addWord(new Word(temp.get(0).trim(), temp.get(1).trim()));
			}
			System.out.println(userName+"의 단어장이 생성되었습니다.");
			this.menu();
			
		} catch(FileNotFoundException e) {
			System.out.println(userName+"의 단어장이 생성되지 않았습니다. \n파일명을 확인하세요.");
		}
		
	}
	
	void menu() {		
		int choice = 0;
		while(choice != 4) {
			System.out.println("\n------"+userName+"의 단어장 -------");
			System.out.println("1) 단어검색 2) 단어검색2 3) 빈출 단어 4)종료");
			System.out.print("메뉴를 선택하세요 : ");
			choice = scan.nextInt();
			scan.nextLine();
			System.out.println();

			switch (choice) {
			case 1:
				searchVoc();
				break;
			case 2:
				searchVoc2();
				break;
			case 3:
				showFrequentWords();
				break;
			case 4:
				System.out.println(userName + "의 단어장 프로그램을 종료합니다.");
				break;
			}
				
		}		
	}

	public void showFrequentWords() {
		System.out.println("------ 빈출 단어 ------");
		Stream<Word> stream = voc.stream();
		stream.sorted(Comparator.comparingInt(Word::getCount).reversed())
				.limit(5)
				.forEach( it ->
						System.out.println(it.count + "번 -> " + it)
				);
	}
	public void searchVoc2() {
		System.out.println("------ 단어 검색 ------");
		System.out.print("검색할 부분 단어를 입력하세요 (영단어) : ");
		String sWord = scan.nextLine().trim();
		for(Word word : voc) {
			if(word!=null) {
				if(word.eng.contains(sWord)) {
					System.out.println(word);
					word.count++;
				}
			} else {
				//System.out.println("단어장에 등록되어 있지 않습니다.");
				break;
			}
		}
	}
	

	public void searchVoc() {
		System.out.println("------ 단어 검색 ------");
		System.out.print("검색할 단어를 입력하세요 (영단어) : ");
		String sWord = scan.nextLine();
		sWord = sWord.trim();
		for(Word word : voc) {
			if(word != null) {
				if(word.eng.equals(sWord)) {
					System.out.println("단어의 뜻 : " + word.kor);
					word.count++;
					break;
				}
			}else {
				System.out.println("단어장에 등록되어 있지 않습니다.");
				break;
			}
		}		
	}
		
}
