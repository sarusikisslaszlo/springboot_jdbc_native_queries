package adatbazisok.com.bank.service.impl;

import adatbazisok.com.bank.entity.BankAccount;
import adatbazisok.com.bank.repository.BankAccountRepository;
import adatbazisok.com.bank.service.interf.BankAccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountServiceImpl implements BankAccountService {

  @Autowired
  private BankAccountRepository bankAccountRepository;

  @Override
  public List<BankAccount> findAll() {
    return bankAccountRepository.findAll();
  }

  @Override
  public BankAccount getById(String id) {
    return bankAccountRepository.getById(id);
  }

  @Override
  public void saveBankAccount(String id, int balance, String type, String clientId, Long bankId) {
    bankAccountRepository.saveBankAccount(id, balance, type, clientId, bankId);
  }

  @Override
  public void updateById(String id, int balance, String type, String clientId, Long bankId) {
    bankAccountRepository.updateById(id, balance, type, clientId, bankId);
  }

  @Override
  public void deleteBankAccountById(String id) {
    bankAccountRepository.deleteBankAccountById(id);
  }

  @Override
  public List<Object[]> getSumAmount() {
    return bankAccountRepository.getSumAmount();
  }

  @Override
  public List<Object[]> getBAlanceByBank() {
    return bankAccountRepository.getBAlanceByBank();
  }

}
