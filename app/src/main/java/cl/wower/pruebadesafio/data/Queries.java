package cl.wower.pruebadesafio.data;

import java.util.ArrayList;
import java.util.List;

import cl.wower.pruebadesafio.models.Post;

/**
 * Created by JuanCarlos on 16-08-17.
 */

public class Queries {

    public List<Post> posts() {

        List<Post> posts = new ArrayList<>();
        List<Post> postList = Post.find(Post.class, "done = 0");

        if (postList != null && postList.size() > 0) {
            posts.addAll(postList);
        }
        return posts;
    }


}
