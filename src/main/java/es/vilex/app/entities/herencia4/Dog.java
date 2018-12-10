


package es.vilex.app.entities.herencia4;

import javax.persistence.Entity;

@Entity
public class Dog extends Animal {

  private String dogType;

  public String getDogType() {
    return dogType;
  }

  public void setDogType(String dogType) {
    this.dogType = dogType;
  }

}
