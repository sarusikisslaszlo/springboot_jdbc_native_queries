package adatbazisok.com.bank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "bank")
public class Bank {

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "nev")
  private String name;

  @Column(name = "hely")
  private String city;

}
