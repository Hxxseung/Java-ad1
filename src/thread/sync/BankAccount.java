package thread.sync;

public interface BankAccount {

    boolean withdraw(int amount); //계좌의 돈 출금, 출금할 금액 매개변수로 받음.
                                  //계좌 잔액 > 출금 금액 => true , 잔액 < 출금 금액 => false

    int getBalance();   //계좌 잔액 반환
}
