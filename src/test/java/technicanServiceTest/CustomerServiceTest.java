package technicanServiceTest;

import com.semicolon.africa.Main;
import com.semicolon.africa.ports.in.CustomerService;
import com.semicolon.africa.ports.in.dtos.request.CreateReviewRequest;
import com.semicolon.africa.ports.in.dtos.request.customer.LoginCustomerRequest;
import com.semicolon.africa.ports.in.dtos.request.customer.RegisterCustomerRequest;
import com.semicolon.africa.ports.out.dtos.response.CreateReviewResponse;
import com.semicolon.africa.ports.out.dtos.response.customer.CustomerLoginResponse;
import com.semicolon.africa.ports.out.dtos.response.customer.RegisterCustomerResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = Main.class)
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void testThatCustomerCanRegister(){
        RegisterCustomerRequest request = customerRegisterRequest();
        RegisterCustomerResponse response = customerService.registerCustomer(request);
        assertNotNull(response);
    }

    private RegisterCustomerRequest customerRegisterRequest(){
        RegisterCustomerRequest request = new RegisterCustomerRequest();
        request.setFirstName("Michael");
        request.setLastName("Davids");
        request.setNin("01245");
        request.setEmail("gmail@email.com");
        request.setLocation("312 hebert macauley street yaba");
        request.setPassword("michael");
        request.setPhoneNumber("08022222946");
        return request;
    }


    @Test
    public void testThatCustomerCanLogin(){
        LoginCustomerRequest request = customerLoginRequest();
        CustomerLoginResponse response = customerService.loginCustomer(request);
        assertNotNull(response);
    }

    private LoginCustomerRequest customerLoginRequest(){
        LoginCustomerRequest request = new LoginCustomerRequest();
        request.setCustomerId(1L);
        request.setCustomerEmail("gmail@email.com");
        request.setPassword("michael");
        return request;
    }

    @Test
    public void  testThatCustomerCanMakeReview(){
        CreateReviewRequest request = createCustomerReview();
        CreateReviewResponse response = customerService.createReview(request);
        assertNotNull(response);
    }

    private CreateReviewRequest createCustomerReview(){
        CreateReviewRequest reviewRequest = new CreateReviewRequest();
        reviewRequest.setRating(3);
        reviewRequest.setDescription("A very nice technician He really helped fix my solar and he did it perfectly");
        reviewRequest.setReviewDate(LocalDate.now());
        reviewRequest.setTechnicianId(1L);
        reviewRequest.setCustomerId(1L);
        return reviewRequest;
    }
}
