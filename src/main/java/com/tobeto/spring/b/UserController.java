// UserController.java
package com.tobeto.spring.b;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserBuss userBuss;


    public UserController(UserBuss userBuss) {
        this.userBuss = userBuss;
        List<User> allUsers = userBuss.getUsers();
    }

    @GetMapping()
    public List<User> getAllUsers() {



        return this.userBuss.getUsers();
    }

    @PostMapping()
    public String createUser(@RequestBody User user) {


        userBuss.addUser(user);

        return "Kullanıcı oluşturuldu: " + user.getName() + " (ID: " + user.getId() + ")";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        User existingUser = userBuss.getUserById(id);

        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setAge(user.getAge());

            userBuss.updateUser(existingUser);

            return "Kullanıcı güncellendi: ID: " + id + ", Yeni Bilgiler: İsim: " + existingUser.getName() +
                    ", E-mail: " + existingUser.getEmail() + ", Yaş: " + existingUser.getAge();
        } else {
            return "Kullanıcı bulunamadı. Güncelleme başarısız.";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userBuss.deleteUser(id);
        return "Kullanıcı silindi: " + id;
    }
}
