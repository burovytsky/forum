package forum.service;

import forum.model.Post;
import forum.model.User;
import forum.repository.PostRepository;
import forum.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ForumService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public ForumService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public void save(Post post) {
        postRepository.save(post);
    }

    public Collection<Post> getAll() {
        return postRepository.getAll();
    }

    public Post findById(int id) {
        return postRepository.findById(id);
    }

    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    public User findUserById(int id) {
        return userRepository.findById(id);
    }

    public Collection<User> getAllUsers() {
        return userRepository.getAll();
    }

    public boolean checkUser(String username, String password) {
        return userRepository.checkUser(username, password);
    }
}
