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

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import es.vilex.app.entities.User;
import es.vilex.app.respositories.UserDao;

@ManagedBean("userController")
@ViewScoped // este es el scope por defecto
public class UserController {

  private User user;

  private LazyDataModel<User> userList;

  private User[] selectedUsers;


  @Autowired
  private UserDao dao;


  @PostConstruct
  private void init() {
    userList = new UserLazyList(dao);
    user = new User();
    // userList = new LazyDataModel<User>() {
    // @Override
    // public List<User> load(int first, int pageSize, String sortField, SortOrder sortOrder,
    // Map<String, Object> filters) {
    // setRowCount(11);
    // return dao.findAll(PageRequest.of(first, pageSize)).getContent();
    // }
    // };
  }


  public User getUser() {
    return user;
  }


  public void setUser(User user) {
    this.user = user;
  }


  public LazyDataModel<User> getUserList() {
    return userList;
  }


  public void setUserList(LazyDataModel<User> userList) {
    this.userList = userList;
  }


  public User[] getSelectedUsers() {
    return selectedUsers;
  }


  public void setSelectedUsers(User[] selectedUsers) {
    this.selectedUsers = selectedUsers;
  }


  public UserDao getDao() {
    return dao;
  }


  public void setDao(UserDao dao) {
    this.dao = dao;
  }


  public void save() {
    System.out.println("salvando");
  }



}
