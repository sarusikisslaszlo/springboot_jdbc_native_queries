package adatbazisok.com.bank.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ugyfel")
public class Client {

  @Id
  @Column(name = "szemigszam")
  private String idNum;

  @Column(name = "nev")
  private String name;

  @Column(name = "szul_datum")
  private Date bornDate;

  @Column(name = "anyja_neve")
  private String motherName;

  @Column(name = "varos")
  private String city;

  @Column(name = "iranyitoszam")
  private int zipCode;

  @Column(name = "utca_hazszam")
  private String street;


}
