package main.teste;

import main.java.conta.model.Account;
import main.java.exception.AccountNotFound;
import main.java.exception.InsufficientBalanceException;
import main.java.repository.IAccountRepository;
import main.java.repository.impl.AccountRepository;

public class TestTransfer {

    public static void main(String[] args) {
        Account accountFrancisco = new Account(1, 100, 3427, 38593, "Francisco Junior");

        try {
            Account accountHelena = getAccount(2);
            accountFrancisco.transfer(25, accountHelena);
            System.out.println(accountHelena);
        } catch (InsufficientBalanceException e) {
            e.printStackTrace();
        } catch (AccountNotFound e) {
            e.printStackTrace();
        }
    }

    private static Account getAccount(double id) {
        IAccountRepository account = new AccountRepository();
        return account.getAccountById(id);
    }
}