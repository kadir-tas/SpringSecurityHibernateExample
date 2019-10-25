package dao;

import model.User;

public interface UserDetailsDao {
  public User findUserByUsername(String username);
}