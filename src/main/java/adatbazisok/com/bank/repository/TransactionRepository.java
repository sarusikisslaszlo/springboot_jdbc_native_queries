package adatbazisok.com.bank.repository;

import adatbazisok.com.bank.entity.Transaction;
import java.sql.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

  @Query(nativeQuery = true, value = "SELECT * FROM tranzakcio")
  List<Transaction> findAll();

  @Query(nativeQuery = true, value = "SELECT * FROM tranzakcio WHERE tranzakcio.id=:id")
  Transaction getById(@Param("id") Long id);

  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = "INSERT INTO tranzakcio (osszeg, kitol, kinek, idopont, szamla_id) VALUES ((:amount), (:from), (:to), (:date), (:accountId))")
  void saveTransaction(@Param("amount") int amount, @Param("from") String from, @Param("to") String to, @Param("date") Date date, @Param("accountId") String accountId);

  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = "UPDATE tranzakcio SET tranzakcio.id=(:id), tranzakcio.osszeg=(:amount), tranzakcio.kitol=(:from), tranzakcio.kinek=(:to), tranzakcio.idopont=(:date), tranzakcio.szamla_id=(:accountId) WHERE tranzakcio.id=:id")
  void updateTransaction(@Param("id") Long id, @Param("amount") int amount, @Param("from") String from, @Param("to") String to, @Param("date") Date date, @Param("accountId") String accountId);

  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = "DELETE FROM tranzakcio WHERE tranzakcio.id=:id")
  void deleteTransaction(@Param("id") Long id);

  @Query(nativeQuery = true, value = "SELECT COUNT(tranzakcio.id) FROM tranzakcio WHERE idopont BETWEEN DATE_SUB(NOW(), INTERVAL 7 DAY) AND NOW() AND osszeg > (SELECT AVG(osszeg) FROM tranzakcio)")
  int queryTrans();

}
