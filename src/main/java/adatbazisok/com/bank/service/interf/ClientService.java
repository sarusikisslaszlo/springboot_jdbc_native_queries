package adatbazisok.com.bank.service.interf;

import adatbazisok.com.bank.entity.Client;
import java.sql.Date;
import java.util.List;

public interface ClientService {

  List<Client> findAll();

  Client getById(String id);

  void saveClient(String idNum, String name, Date bornDate, String motherName, String city, int zipCode, String street);

  void updateClient(String idNum, String name, Date bornDate, String motherName, String city, int zipCode, String street);

  void deleteClient(String id);

}
