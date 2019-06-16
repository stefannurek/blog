package blog.demo.controller;

import blog.demo.repository.PostRepository;
import blog.demo.model.Comment;
import blog.demo.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/posts")
public class PostController {

    private PostRepository postRepository;

    public PostController(PostRepository postRepository){
        this.postRepository=postRepository;
    }


    @GetMapping("/add")
    public String addPost(ModelMap modelMap){
        modelMap.put("post", new Post());
        return "posts/add";
    }

    @PostMapping("")
    public String createPost(@ModelAttribute Post post){
        postRepository.save(post);
        return "redirect:/posts/" + post.getId();
    }

    @GetMapping("/{id}")
    public String showPost(@PathVariable Long id, ModelMap modelMap){
        Post post = postRepository.findById(id).get();
        modelMap.put("post", post);
        Comment comment = new Comment();
        comment.setPost(post);
        modelMap.put("comment", comment);
        modelMap.put("comments", post.getComments());
        return "posts/show";
    }
}
