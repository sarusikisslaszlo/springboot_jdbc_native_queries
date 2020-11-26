package adatbazisok.com.bank.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tranzakcio")
public class Transaction {

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "osszeg")
  private int amount;

  @Column(name = "kitol")
  private String fromClient;

  @Column(name = "kinek")
  private String toClient;

  @Column(name = "idopont")
  private Date dateTime;

  @Column(name = "szamla_id")
  private String accountNum;
}
