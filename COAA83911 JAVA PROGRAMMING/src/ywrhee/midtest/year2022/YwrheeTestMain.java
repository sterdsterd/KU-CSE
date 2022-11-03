package ywrhee.midtest.year2022;

public class YwrheeTestMain {
    public static void main(String[] args) {
        System.out.println("1) 202211342 이율원");

        System.out.println("2) Contents 객체 생성 및 출력하기");
        YwrheeContents c1 = new YwrheeContents("영화1", 1000);
        System.out.println(c1);

        System.out.println("3) Drama 객체 생성 및 출력하기");
        YwrheeContents c2 = new YwrheeDrama("드라마1-1", 2000, 0.25);
        System.out.println(c2);

        System.out.println("4) Movie 객체 생성 및 출력하기");
        YwrheeContents c3 = new YwrheeMovie("영화2", 2000, 19);
        System.out.println(c3);

        System.out.println("5) TV 객체 생성하기");
        //YwrheeTV tempTVTv = new YwrheeTV(5);
        YwrheeTV ywrheeTV = YwrheeTV.getInstance(5);

        System.out.println("6) 컨텐츠 추가하기");
        ywrheeTV.addContent(new YwrheeDrama("드라마1-1", 2000, 0.3));
        ywrheeTV.addContent(new YwrheeDrama("드라마1-2", 2000, 0.0));
        ywrheeTV.addContent(new YwrheeDrama("드라마1-2", 2000, 0.25));
        ywrheeTV.addContent(new YwrheeMovie("영화2", 2000, 19));
        ywrheeTV.addContent(new YwrheeMovie("영화3", 1000, 10));
        ywrheeTV.addContent(new YwrheeDrama("드라마2-1", 1000, 0.1));
        ywrheeTV.addContent(new YwrheeMovie("영화4", 1000, 15));

        System.out.println("7) 컨텐츠 타이틀로 검색하기");
        YwrheeContents content1 = ywrheeTV.searchContents("드라마1-1");
        YwrheeContents content2 = ywrheeTV.searchContents("영화2");
        YwrheeContents content3 = ywrheeTV.searchContents("영화3");
        YwrheeContents content4 = ywrheeTV.searchContents("드라마1-2");
        YwrheeContents content5 = ywrheeTV.searchContents("드라마2-1");

        System.out.println("8) Client 객체 생성 및 출력하기");
        YwrheeClient gdhong = new YwrheeClient("홍길동", 10, 3);
        System.out.println(gdhong);
        YwrheeClient gdkim = new YwrheeClient("김길동", 25, 4);
        YwrheeClient gdlee = new YwrheeClient("이길동", 42, 3);

        System.out.println("9) 컨텐츠 다운로드하기");
        gdhong.downloadContents(content1);
        gdhong.downloadContents(content2);
        gdhong.downloadContents(content3);
        gdhong.downloadContents(content3);
        gdhong.downloadContents(content4);
        gdhong.downloadContents(content5);
        System.out.println("--------------------");
        gdkim.downloadContents(content3);
        gdlee.downloadContents(content4);

        System.out.println("10) 다운로드이후 Client 객체 출력하기");
        System.out.println(gdhong);

        System.out.println("11) Client에게 다운로드 회수가 높은 컨텐츠 3개 추천하기");
        YwrheeContents[] rmdContents = ywrheeTV.recommandContents(gdhong);
        if (rmdContents != null) {
            for (int i = 0; i < rmdContents.length; i++) {
                System.out.println(rmdContents[i]);
            }

        }
    }
}
