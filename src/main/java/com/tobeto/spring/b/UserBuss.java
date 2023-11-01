// UserBuss.java
package com.tobeto.spring.b;

import java.util.List;

public interface UserBuss {
    List<User> getUsers();
    void addUser(User user);
    void deleteUser(Long id);
    User getUserById(Long id);
    void updateUser(User user);
}
