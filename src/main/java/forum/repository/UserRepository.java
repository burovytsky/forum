package forum.repository;

import forum.model.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    private final Map<Integer, User> users = new HashMap<>();
    int idCount = 1;

    public UserRepository() {
        User user = new User();
        user.setId(idCount++);
        user.setUsername("admin");
        user.setPassword("123456");

        User user1 = new User();
        user1.setId(idCount++);
        user1.setUsername("user");
        user1.setPassword("1234");
        users.put(user1.getId(), user1);
        users.put(user.getId(), user);
    }

    public void saveUser(User user) {
        user.setId(idCount++);
        users.put(user.getId(), user);
    }

    public User findById(int id) {
        return users.get(id);
    }

    public Collection<User> getAll() {
        return users.values();
    }

    public boolean checkUser(String username, String password) {
        for (Map.Entry<Integer, User> userEntry : users.entrySet()) {
            if (userEntry.getValue().getUsername().equals(username) &&
                    userEntry.getValue().getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
