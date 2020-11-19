package forum.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import forum.model.Post;
import forum.repository.PostRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class ForumCrudService {

    private final PostRepository posts;

    public ForumCrudService(PostRepository posts) {
        this.posts = posts;
    }

    public List<Post> getAll() {
        return new ArrayList<>(posts.findAll(Sort.by(Sort.Direction.ASC, "id")));
    }

    public void save(Post post) {
        post.setCreated(new Timestamp(System.currentTimeMillis()));
        posts.save(post);
    }

    public Post findById(int id) {
        return posts.findById(id).get();
    }

}