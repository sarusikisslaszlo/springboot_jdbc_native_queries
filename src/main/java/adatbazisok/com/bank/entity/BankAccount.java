package adatbazisok.com.bank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "folyoszamla")
public class BankAccount {

  @Id
  @Column(name = "szamlaszam")
  private String accountNumber;

  @Column(name = "egyenleg")
  private int balance;

  @Column(name = "elnevezes")
  private String type;

  @Column(name = "ugyfel_id")
  private String ugyfelId;

  @Column(name = "bank_id")
  private Long bankId;
}
