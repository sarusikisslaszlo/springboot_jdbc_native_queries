package adatbazisok.com.bank.service.interf;

import adatbazisok.com.bank.entity.Transaction;
import java.sql.Date;
import java.util.List;

public interface TransactionService {

  List<Transaction> findAll();

  Transaction getById(Long id);

  void saveTransaction(int amount, String from, String to, Date date, String accountId);

  void updateTransaction(Long id, int amount, String from, String to, Date date, String accountId);

  void deleteTransaction(Long id);

  int queryTrans();

}
