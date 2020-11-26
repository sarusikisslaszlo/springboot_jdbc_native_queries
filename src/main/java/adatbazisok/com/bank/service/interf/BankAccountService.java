package adatbazisok.com.bank.service.interf;

import adatbazisok.com.bank.entity.BankAccount;
import java.util.List;

public interface BankAccountService {

  List<BankAccount> findAll();

  BankAccount getById(String id);

  void saveBankAccount(String id, int balance, String type, String clientId, Long bankId);

  void updateById(String id, int balance, String type, String clientId, Long bankId);

  void deleteBankAccountById(String id);

  List<Object[]> getSumAmount();

  List<Object[]> getBAlanceByBank();


}
