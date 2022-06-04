package app.authapp.service;

import app.authapp.model.User;
import app.authapp.model.Login;

public interface UserService {

  int register(User user);

  User validateUser(Login login);
}
