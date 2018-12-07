/**
 * Aviso legal
 * 
 * Toda la información contenida aquí es propiedad de Diners Club Spain, S.A. y está protegida por
 * la ley de propiedad intelectual. Cualquier difusión o reproducción total o parcial, incluso para
 * uso por personal interno (empleado) o externo (proveedor), por cualquier medio y bajo cualquier
 * forma, está prohibida, salvo autorización expresa por parte de Diners Club Spain, otorgada con
 * carácter previo y de forma escrita.
 * 
 * El uso o acceso permitido a dicha información no podrá entenderse como cesión de ninguna clase de
 * derecho de explotación sobre los citados derechos de propiedad intelectual.
 */


package es.vilex.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;
import es.vilex.app.entities.User;
import es.vilex.app.respositories.UserDao;

@Component
public class UserLazyList extends LazyDataModel<User> {



  @Autowired
  private UserDao dao;

  // public UserLazyList(UserDao userDao) {
  // this.dao = userDao;
  // }

  public UserDao getUserDao() {
    return dao;
  }

  public void setUserDao(UserDao userDao) {
    this.dao = userDao;
  }

  @Override
  public User getRowData(String id) {
    Optional<User> optionalUser = dao.findById(Long.valueOf(id));
    if (optionalUser.isPresent()) {
      return optionalUser.get();
    } else {
      return null;
    }
  }


  @Override
  public Object getRowKey(User user) {
    return user.getId();
  }

  @Override
  public List<User> load(int first, int pageSize, String sortField, SortOrder sortOrder,
      Map<String, Object> filters) {
    List<User> userList = new ArrayList<>();


    Sort sort = Sort.by(Order.asc(sortField));
    if (sortOrder.equals(SortOrder.DESCENDING)) {
      sort = Sort.by(Order.desc(sortField));
    }

    Page<User> result = dao.findAll(PageRequest.of((first / pageSize), pageSize, sort));
    this.setRowCount((int) result.getTotalElements());
    this.setPageSize(pageSize);
    userList = result.getContent();
    return userList;
  }



}
