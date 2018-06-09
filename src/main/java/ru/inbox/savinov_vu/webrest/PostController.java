package ru.inbox.savinov_vu.webrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.webrest.model.Post;
import ru.inbox.savinov_vu.webrest.repository.CommentRepository;
import ru.inbox.savinov_vu.webrest.repository.PostRepository;

import javax.validation.Valid;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;


@CrossOrigin(origins={"http://domain1.com", "http://domain2.com"},
        allowedHeaders="X-AUTH-TOKEN",
        allowCredentials="false",
        maxAge=15*60,
        methods={RequestMethod.GET, RequestMethod.POST }
)
@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;


//    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody @Valid Post post, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(post, HttpStatus.BAD_REQUEST);
        }
        Post savedPost = postRepository.save(post);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader1", "MyValue1");
        responseHeaders.set("MyResponseHeader2", "MyValue2");
        return new ResponseEntity<>(savedPost, responseHeaders, HttpStatus.CREATED);
    }


    @GetMapping("")
    public List<Post> listPosts() {
        return postRepository.findAll();
    }


    @GetMapping(value = "/{id}")
    public Post getPost(@PathVariable("id") Integer id) {
        return postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException
                ("No post found with id=" + id));
    }


    @PutMapping("/{id}")
    public Post updatePost(@PathVariable("id") Integer id, @RequestBody
            Post post) {
        postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("No post found with id=" + id));
        return postRepository.save(post);
    }


    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") Integer id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException
                ("No post found with id=" + id));
        postRepository.deleteById(post.getId());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> servletRequestBindingException(RuntimeException e)
    {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setErrorMessage(e.getMessage());
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        errorDetails.setDevErrorMessage(sw.toString());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
