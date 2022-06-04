package app.authapp.dao;

import app.authapp.model.Login;
import app.authapp.model.User;

public interface UserDao {

  int register(User user);

  User validateUser(Login login);
}
