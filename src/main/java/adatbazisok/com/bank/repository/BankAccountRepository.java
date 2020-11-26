package adatbazisok.com.bank.repository;

import adatbazisok.com.bank.entity.BankAccount;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, String> {

  @Query(nativeQuery = true, value = "SELECT * FROM folyoszamla;")
  List<BankAccount> findAll();

  @Query(nativeQuery = true, value = "SELECT * FROM folyoszamla WHERE folyoszamla.szamlaszam = :id")
  BankAccount getById(@Param("id") String id);

  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = "INSERT INTO folyoszamla (folyoszamla.szamlaszam, folyoszamla.egyenleg, folyoszamla.elnevezes, folyoszamla.ugyfel_id, folyoszamla.bank_id) VALUES ((:id), (:balance), (:type), (:clientId), (:bankId))")
  void saveBankAccount(@Param("id") String id, @Param("balance") int balance, @Param("type") String type, @Param("clientId") String clientId, @Param("bankId") Long bankId);

  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = "UPDATE folyoszamla SET folyoszamla.szamlaszam=(:id), folyoszamla.egyenleg=(:balance), folyoszamla.elnevezes=(:type), folyoszamla.ugyfel_id=(:clientId), folyoszamla.bank_id=(:bankId) WHERE folyoszamla.szamlaszam = :id")
  void updateById(@Param("id") String id, @Param("balance") int balance, @Param("type") String type, @Param("clientId") String clientId, @Param("bankId") Long bankId);

  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = "DELETE FROM folyoszamla WHERE folyoszamla.szamlaszam=(:id);")
  void deleteBankAccountById(@Param("id") String id);

  @Query(nativeQuery = true, value = "SELECT SUM(folyoszamla.egyenleg), bank.id FROM adatbazis.bank, adatbazis.folyoszamla WHERE bank.id=folyoszamla.bank_id GROUP BY bank.id ORDER BY bank.id")
  List<Object[]> getSumAmount();

  @Query(nativeQuery = true, value = "SELECT AVG(folyoszamla.egyenleg), bank.id FROM adatbazis.bank, adatbazis.folyoszamla WHERE bank.id=folyoszamla.bank_id GROUP BY bank.id ORDER BY bank.id")
  List<Object[]> getBAlanceByBank();

}
