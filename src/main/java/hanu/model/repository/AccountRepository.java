package hanu.model.repository;

import hanu.base.Repository;
import hanu.model.domain.Account;

import java.util.List;

public interface AccountRepository extends Repository<Account, Integer> {
    List<Account> accounts= null;

    public boolean add(Account account);

    public void remove(int id);

    //public void save(Account account);

    public List<Account> findAll();

    public Account findById(int id);

    public Account findByUsernameAndPassword(String username, String password);
}
