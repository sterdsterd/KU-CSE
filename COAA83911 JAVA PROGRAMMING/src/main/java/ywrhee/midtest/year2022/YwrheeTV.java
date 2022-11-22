package ywrhee.midtest.year2022;

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
                System.out.println("타이틀이 같은 작품이 등록되어 있습니다.");
                return;
            }
        }

        if (count >= contentsNum) {
            System.out.println("더이상 추가될 수 없습니다.");
            return;
        }

        contents[count++] = content;
        System.out.println("등록이 완료되었습니다.");
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
