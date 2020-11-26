package adatbazisok.com.bank.service.interf;

import adatbazisok.com.bank.entity.Bank;
import java.util.List;

public interface BankService {

  List<Bank> findAll();

  Bank getById(Long id);

  void saveBank(String name, String city);

  void updateBank(Long id, String name, String city);

  void deleteBank(Long id);

}
