package ywrhee.week01;

public class YwrheeExample02 {

    final int COFFEE = 500;
    final int MILK = 200;
    final int WATER = 100;

    public static int getCost(int price, int num) {
        return price * num;
    }

    public static void main(String[] args) {
        System.out.println("202211342 이율원");

        YwrheeExample02 greenjoa1 = new YwrheeExample02();

        int coffee = 500;
        int milk = 200;
        int water = 100;

        int coffeeCost = getCost(greenjoa1.COFFEE, coffee);
        int milkCost = getCost(greenjoa1.MILK, milk);
        int waterCost = getCost(greenjoa1.WATER, water);

        int totalCost = coffeeCost + milkCost + waterCost;

        System.out.println("총구입금액 : " + totalCost);
    }
}
