package ywrhee.week02;

public class YwrheeLab02 {
    public static void main(String[] args) {
        System.out.println("202211342 이율원");
        int rgb = 0x88a5ff73;
        String strRgb = Integer.toBinaryString(rgb);
        System.out.println("현재 색상 : " + strRgb);

        int rgbWithoutGreen = rgb & 0xffff00ff;
        String strRgbWithoutGreen = Integer.toBinaryString(rgbWithoutGreen);

        System.out.println("변경 색상 : " + strRgbWithoutGreen);

    }
}
