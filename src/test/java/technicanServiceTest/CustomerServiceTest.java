package technicanServiceTest;

import com.semicolon.africa.Main;
import com.semicolon.africa.ports.in.CustomerService;
import com.semicolon.africa.ports.in.dtos.request.RegisterCustomerRequest;
import com.semicolon.africa.ports.out.dtos.response.RegisterCustomerResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

    }

    private void customerLoginRequest(){
        
    }


}
