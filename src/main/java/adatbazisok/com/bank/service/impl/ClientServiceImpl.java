package adatbazisok.com.bank.service.impl;

import adatbazisok.com.bank.entity.Client;
import adatbazisok.com.bank.repository.ClientRepository;
import adatbazisok.com.bank.service.interf.ClientService;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

  @Autowired
  private ClientRepository clientRepository;

  @Override
  public List<Client> findAll() {
    return clientRepository.findAll();
  }

  @Override
  public Client getById(String id) {
    return clientRepository.getById(id);
  }

  @Override
  public void saveClient(String idNum, String name, Date bornDate, String motherName, String city, int zipCode, String street) {
    clientRepository.saveClient(idNum, name, bornDate, motherName, city, zipCode, street);
  }

  @Override
  public void updateClient(String idNum, String name, Date bornDate, String motherName, String city, int zipCode, String street) {
    clientRepository.updateClient(idNum, name, bornDate, motherName, city, zipCode, street);
  }

  @Override
  public void deleteClient(String id) {
    clientRepository.deleteClient(id);
  }

}
