package ywrhee.week05;

public class TestMain {
    public static void main(String[] args) {
        BankManager branch1 = new BankManager("건대지점", 5);
        branch1.createAccount();
        branch1.createAccount();
        branch1.deposit();
        branch1.withdraw();

        System.out.println(branch1.bankAccount[0]);
        System.out.println(branch1.bankAccount[1]);

        branch1.transfer();
        System.out.println(branch1.bankAccount[0]);
        System.out.println(branch1.bankAccount[1]);
    }
}
