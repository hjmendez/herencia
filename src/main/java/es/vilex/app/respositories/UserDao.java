
package es.vilex.app.respositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import es.vilex.app.entities.User;

public interface UserDao extends PagingAndSortingRepository<User, Long> {

}
