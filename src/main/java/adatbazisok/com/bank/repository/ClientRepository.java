package adatbazisok.com.bank.repository;

import adatbazisok.com.bank.entity.Client;
import java.sql.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, String> {

  @Query(nativeQuery = true, value = "SELECT * FROM ugyfel")
  List<Client> findAll();

  @Query(nativeQuery = true, value = "SELECT * FROM ugyfel WHERE ugyfel.szemigszam=:id")
  Client getById(@Param("id") String id);

  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = "INSERT INTO ugyfel (szemigszam, nev, szul_datum, anyja_neve, varos, iranyitoszam, utca_hazszam) VALUES ((:idNum), (:name), (:bornDate), (:motherName), (:city), (:zipCode), (:street))")
  void saveClient(@Param("idNum") String idNum, @Param("name") String name, @Param("bornDate") Date bornDate, @Param("motherName") String motherName, @Param("city") String city, @Param("zipCode") int zipCode, @Param("street") String street);

  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = "UPDATE ugyfel SET ugyfel.szemigszam=(:idNum), ugyfel.nev=(:name), ugyfel.szul_datum=(:bornDate), ugyfel.anyja_neve=(:motherName), ugyfel.varos=(:city), ugyfel.iranyitoszam=(:zipCode), ugyfel.utca_hazszam=(:street) WHERE ugyfel.szemigszam=:idNum")
  void updateClient(@Param("idNum") String idNum, @Param("name") String name, @Param("bornDate") Date bornDate, @Param("motherName") String motherName, @Param("city") String city, @Param("zipCode") int zipCode, @Param("street") String street);

  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = "DELETE FROM ugyfel WHERE ugyfel.szemigszam=:id")
  void deleteClient(@Param("id") String id);

}
