package hanu.controllers;

import hanu.db.connect;
import hanu.model.domain.Account;
import hanu.model.domain.Role;
import hanu.model.repository.AccountRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AccountController implements AccountRepository{
    Connection connection;


    @Override
    public void add(Account account) {

    }

    @Override
    public void add(List<Account> items) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Account item) {

    }

    @Override
    public void deleteAll(List<Account> items) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public boolean existById(Integer integer) {
        return false;
    }

    @Override
    public Account findById(Integer integer) {
        return null;
    }

    @Override
    public List<Account> findAllById(List<Integer> integers) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Account> findAll() { //currently omitting admins
        connection = connect.getConnection();
        List<Account> accountList= new ArrayList<Account>();
        try {

            String admlogin = "select * from account where (role!= \"Admin\")";
            PreparedStatement stm = connection.prepareStatement(admlogin);

            ResultSet result = stm.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String username = result.getString("username");
                String password = result.getString("password");
                Role role = Role.valueOf(result.getString("role"));
                accountList.add(new Account(id, username, password, role));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accountList;
    }

    @Override
    public Account save(Account item) {
        return null;
    }

    @Override
    public List<Account> saveAll(List<Account> items) {
        return null;
    }

    @Override
    public Account findById(int id) {
        return null;
    }

    @Override
    public Account findByUsernameAndPassword(String username, String password){
        connection = connect.getConnection();
        Account account= null;
        try {

            String admlogin = "select * from account where ( username = ? and password = ?)";
            PreparedStatement stm = connection.prepareStatement(admlogin);
            stm.setString(1, username);
            stm.setString(2, password);

            ResultSet result = stm.executeQuery();

            if (result.next()) {
                int id = result.getInt("id");
//                String username = result.getString("username");
//                String password = result.getString("password");
                Role role = Role.valueOf(result.getString("role"));
                account = new Account(id, username, password, role);
            }
            else{
                System.out.println("No accounts found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }
}
