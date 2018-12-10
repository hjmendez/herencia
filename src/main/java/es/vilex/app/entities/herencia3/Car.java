
package es.vilex.app.entities.herencia3;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Car extends Vehicle {
  public Integer seatings;

  public Integer getSeatings() {
    return seatings;
  }

  public void setSeatings(Integer seatings) {
    this.seatings = seatings;
  }


}
