// UserDao.java
package com.tobeto.spring.b;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    void addUser(User user);
    void deleteUser(Long id);
}
