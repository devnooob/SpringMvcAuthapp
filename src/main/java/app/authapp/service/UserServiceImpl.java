package app.authapp.service;

import app.authapp.dao.UserDao;
import app.authapp.model.Login;
import app.authapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

  public int register(User user) {
    return userDao.register(user);
  }

  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }

}
