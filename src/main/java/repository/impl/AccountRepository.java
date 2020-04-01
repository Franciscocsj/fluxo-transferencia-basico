package main.java.repository.impl;

import main.java.conta.model.Account;
import main.java.exception.AccountNotFound;
import main.java.repository.IAccountRepository;

public class AccountRepository implements IAccountRepository {

    public Account getAccountById(double idAccount) {

        Account account = new Account(2, 200, 7893, 57789, "Helena Damante");

        if (idAccount == account.getId()) {
            return account;
        } else {
            throw new AccountNotFound("Account not found for the given id: " + idAccount);
        }

    }
}
