package ywrhee.week05;

public class SalesReport {
    private Salesman[] team;
    private double highestSales = 0;
    private double averageSales = 0;
    private final int number;

    public SalesReport(int number) {
        this.number = number;
        team = new Salesman[number];

        for (int i = 0; i < number; i++) {
            System.out.println((i + 1) + "번째 팀원 정보 입력");
            team[i] = new Salesman();
            System.out.println("입력완료");
        }

    }

    public void computeStats() {
        for (Salesman clerk : team) {
            highestSales = highestSales < clerk.getSales() ? clerk.getSales() : highestSales;
            averageSales += clerk.getSales();
        }

        averageSales /= number;
    }

    public Salesman getBestClerk() {
        Salesman bestClerk = null;
        for (Salesman clerk : team) {
            if (bestClerk == null || bestClerk.getSales() < clerk.getSales())
                bestClerk = clerk;
        }
        return bestClerk;
    }

    @Override
    public String toString() {
        String info = "총 팀원 수: " + number + "\n";
        info += "최고판매액: " + highestSales + "\n";
        info += "평균판매액: " + averageSales + "\n";
        info += "--------------------\n";

        for (Salesman clerk : team) {
            info += clerk.toString() + "\n";
        }

        return info;
    }
}
