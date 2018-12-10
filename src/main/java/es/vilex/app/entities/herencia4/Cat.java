


package es.vilex.app.entities.herencia4;

import javax.persistence.Entity;

@Entity
public class Cat extends Animal {

  private String catType;

  public String getCatType() {
    return catType;
  }

  public void setCatType(String catType) {
    this.catType = catType;
  }

}
