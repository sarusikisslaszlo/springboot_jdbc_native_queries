package adatbazisok.com.bank.repository;

import adatbazisok.com.bank.entity.Bank;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends CrudRepository<Bank, Long> {

  @Query(nativeQuery = true, value = "SELECT * FROM bank")
  List<Bank> findAll();

  @Query(nativeQuery = true, value = "SELECT * FROM bank WHERE bank.id=:id")
  Bank getById(@Param("id") Long id);

  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = "INSERT INTO bank (nev, hely) VALUES ((:name), (:city))")
  void saveBank(@Param("name") String name, @Param("city") String city);

  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = "UPDATE bank SET bank.id=(:id), bank.nev=(:name), bank.hely=(:city) WHERE bank.id=:id")
  void updateBank(@Param("id") Long id, @Param("name") String name, @Param("city") String city);

  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = "DELETE FROM bank WHERE bank.id=:id")
  void deleteBank(@Param("id") Long id);

}
