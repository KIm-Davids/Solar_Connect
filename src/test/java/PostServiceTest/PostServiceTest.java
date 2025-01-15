package PostServiceTest;

import com.semicolon.africa.Main;
import com.semicolon.africa.adapters.services.PostServicesImpl;
import com.semicolon.africa.domain.Post;
import com.semicolon.africa.ports.in.dtos.request.post.CreatePostRequest;
import com.semicolon.africa.ports.out.dtos.response.post.CreatePostResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = Main.class)
public class PostServiceTest {

    @Autowired
    private PostServicesImpl postServices;

    @Test
    public void testThatCustomerCanCreatePost(){
        CreatePostRequest request = postRequest();
        CreatePostResponse response = postServices.createPost(request);
        assertNotNull(response);
    }


    private CreatePostRequest postRequest(){
        CreatePostRequest post = new CreatePostRequest();
        post.setCustomerId(3L);
        post.setId(1L);
        post.setTitle("I need a very good technician");
        post.setContent("My solar needs maintenance");
//        post.setCustomerId(1L);
        return post;
    }


}
