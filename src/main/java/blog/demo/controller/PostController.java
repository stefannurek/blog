package blog.demo.controller;

import blog.demo.PostRepository;
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
        modelMap.put("post", postRepository.findById(id).get());
        return "posts/show";
    }
}
