package com.mycompany.myapp.dummy.infrastructure.secondary;

import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "burger")
public class BurgerEntity {

  @Id
  @Column(name = "id")
  private UUID id;

  @Column(name = "name")
  private String name;

  @Lob
  @Column(name = "file")
  private byte[] file;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public byte[] getFile() {
    return file;
  }

  public void setFile(byte[] file) {
    this.file = file;
  }
}
