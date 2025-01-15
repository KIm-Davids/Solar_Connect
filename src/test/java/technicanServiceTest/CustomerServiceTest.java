package technicanServiceTest;

import com.semicolon.africa.Main;
import com.semicolon.africa.domain.constants.Availability;
import com.semicolon.africa.domain.constants.LoginStatus;
import com.semicolon.africa.ports.in.CustomerService;
import com.semicolon.africa.ports.in.dtos.request.CreateReviewRequest;
import com.semicolon.africa.ports.in.dtos.request.UpdateReviewRequest;
import com.semicolon.africa.ports.in.dtos.request.customer.FindTechnicianByAvailabilityRequest;
import com.semicolon.africa.ports.in.dtos.request.customer.LoginCustomerRequest;
import com.semicolon.africa.ports.in.dtos.request.customer.RegisterCustomerRequest;
import com.semicolon.africa.ports.out.dtos.response.CreateReviewResponse;
import com.semicolon.africa.ports.out.dtos.response.customer.CustomerLoginResponse;
import com.semicolon.africa.ports.out.dtos.response.customer.RegisterCustomerResponse;
import com.semicolon.africa.ports.out.dtos.response.customer.UpdateReviewResponse;
import com.semicolon.africa.ports.out.dtos.response.technician.FindTechnicianByAvailabilityResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = Main.class)
@EntityScan(basePackages = "com.semicolon.africa.domain")
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
        request.setEmail("gmail1@email.com");
        request.setLocation("312 hebert macauley street yaba");
        request.setPassword("michael");
        request.setPhoneNumber("08022222996");
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
    public void testThatCustomerCanMakeReview(){
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

    @Test
    public void testThatCustomerCanFindTechnician(){
        FindTechnicianByAvailabilityRequest request = new FindTechnicianByAvailabilityRequest();
        request.setAvailability(Availability.AVAILABLE);
        request.setLoginStatus(LoginStatus.ONLINE);

        FindTechnicianByAvailabilityResponse response = customerService.findTechnicianByAvailability(request);
        System.out.println(response);
        assertNotNull(response);
    }

    @Test
    public void testThatCustomerCanUpdateReview(){
        UpdateReviewRequest request = reviewRequest();
        UpdateReviewResponse response = customerService.updateReview(request);
        assertNotNull(response);
    }

    private UpdateReviewRequest reviewRequest(){
        UpdateReviewRequest request = new UpdateReviewRequest();
        request.setId(6L);
        request.setReviewCount(2);
        request.setDescription("Did not fix the battery !!!!!");
        return request;
    }
}
