package com.seroter.skincare_booking.api;

import com.seroter.skincare_booking.entity.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostAPI {

    List<Post> posts = new ArrayList<>();

    @PostMapping("Post")
    public ResponseEntity createNewPost(@RequestBody Post post) {
        posts.add(post);
        return ResponseEntity.ok(post);
    }

    @GetMapping("Post")
    public ResponseEntity getAllPosts() {return ResponseEntity.ok(posts);}
}
