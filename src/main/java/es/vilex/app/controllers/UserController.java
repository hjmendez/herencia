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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import es.vilex.app.entities.User;
import es.vilex.app.respositories.UserDao;

@ManagedBean("userController")
@ViewScoped // este es el scope por defecto
public class UserController {

  FacesContext context;


  private User user;

  @Autowired
  private UserLazyList userList;

  private User[] selectedUsers;


  @Autowired
  private UserDao dao;


  @PostConstruct
  private void init() {
    newUser();
  }


  public User getUser() {
    return user;
  }


  public void setUser(User user) {
    this.user = user;
  }



  public UserLazyList getUserList() {
    return userList;
  }


  public void setUserList(UserLazyList userList) {
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


  // gestión de formulario
  public void newUser() {
    System.out.println("nuevo usuario");
    user = new User();
  }


  public void saveUser() {
    System.out.println("salvando");
    dao.save(user);
    FacesContext.getCurrentInstance().addMessage(null,
        new FacesMessage("Guardado", "Usuario guardado con éxito"));
    newUser();
  }


  public void deleteUsers() {
    System.out.println("borrando usuarios");
    if (selectedUsers.length == 0) {
      context.addMessage(null,
          new FacesMessage("Eliminando", "Debe seleccionar un elemento de la tabla"));
    }
    for (User user : selectedUsers) {
      dao.delete(user);
    }
  }

}
