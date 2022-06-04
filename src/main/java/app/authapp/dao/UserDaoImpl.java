package app.authapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import app.authapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import app.authapp.model.Login;

public class UserDaoImpl implements UserDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public int register(User user) {

    return jdbcTemplate.update("INSERT INTO users VALUES (?,?)", user.getUsername(), user.getPassword());
  }

  public User validateUser(Login login) {
    String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
        + "'";
    List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));

    return users.size() > 0 ? users.get(0) : null;
  }

}

