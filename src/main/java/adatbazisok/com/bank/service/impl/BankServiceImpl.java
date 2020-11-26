package adatbazisok.com.bank.service.impl;

import adatbazisok.com.bank.entity.Bank;
import adatbazisok.com.bank.repository.BankRepository;
import adatbazisok.com.bank.service.interf.BankService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {

  @Autowired
  private BankRepository bankRepository;

  @Override
  public List<Bank> findAll() {
    return bankRepository.findAll();
  }

  @Override
  public Bank getById(Long id) {
    return bankRepository.getById(id);
  }

  @Override
  public void saveBank(String name, String city) {
    bankRepository.saveBank(name, city);
  }

  @Override
  public void updateBank(Long id, String name, String city) {
    bankRepository.updateBank(id, name, city);
  }

  @Override
  public void deleteBank(Long id) {
    bankRepository.deleteBank(id);
  }
}
