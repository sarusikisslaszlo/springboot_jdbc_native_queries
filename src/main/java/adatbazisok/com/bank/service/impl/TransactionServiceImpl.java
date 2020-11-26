package adatbazisok.com.bank.service.impl;

import adatbazisok.com.bank.entity.Transaction;
import adatbazisok.com.bank.repository.TransactionRepository;
import adatbazisok.com.bank.service.interf.TransactionService;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

  @Autowired
  private TransactionRepository transactionRepository;

  @Override
  public List<Transaction> findAll() {
    return transactionRepository.findAll();
  }

  @Override
  public Transaction getById(Long id) {
    return transactionRepository.getById(id);
  }

  @Override
  public void saveTransaction(int amount, String from, String to, Date date, String accountId) {
    transactionRepository.saveTransaction(amount, from, to, date, accountId);
  }

  @Override
  public void updateTransaction(Long id, int amount, String from, String to, Date date, String accountId) {
    transactionRepository.updateTransaction(id, amount, from, to, date, accountId);
  }

  @Override
  public void deleteTransaction(Long id) {
    transactionRepository.deleteTransaction(id);
  }

  @Override
  public int queryTrans() {
    return transactionRepository.queryTrans();
  }

}
