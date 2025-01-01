package technicanServiceTest;

import com.semicolon.africa.Main;
import com.semicolon.africa.adapters.TechnicianServiceImpl;
import com.semicolon.africa.adapters.validations.Validations;
import com.semicolon.africa.domain.constants.Availability;
import com.semicolon.africa.domain.constants.SubscriptionStatus;
import com.semicolon.africa.domain.constants.SubscriptionType;
import com.semicolon.africa.ports.in.dtos.request.*;
import com.semicolon.africa.ports.in.dtos.request.technician.AvailabilityStatusRequest;
import com.semicolon.africa.ports.in.dtos.request.technician.LoginTechnicianRequest;
import com.semicolon.africa.ports.in.dtos.request.technician.LogoutTechnicianRequest;
import com.semicolon.africa.ports.in.dtos.request.technician.RegisterTechnicianRequest;
import com.semicolon.africa.ports.out.dtos.response.*;
import com.semicolon.africa.ports.out.dtos.response.technician.AvailabilityStatusResponse;
import com.semicolon.africa.ports.out.dtos.response.technician.LoginTechnicianResponse;
import com.semicolon.africa.ports.out.dtos.response.technician.LogoutTechnicianResponse;
import com.semicolon.africa.ports.out.dtos.response.technician.RegisterTechnicianResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(classes = Main.class)
public class TechnicianServicesTest {

    @Autowired
    private TechnicianServiceImpl service;

    @Test
    public void testTechnicianEmailIsCorrect(){
        RegisterTechnicianRequest technician = registerTechnician();
        Validations validateEmail = new Validations();
        boolean assertions = validateEmail.validateEmail(technician.getEmail());
        assertTrue(assertions);
    }

    @Test
    public void testThatTechnicianCanRegister(){
        RegisterTechnicianRequest technician = registerTechnician();
        RegisterTechnicianResponse response = service.registerTechnician(technician);
        assertNotNull(response);
    }

    private RegisterTechnicianRequest registerTechnician(){
        RegisterTechnicianRequest request = new RegisterTechnicianRequest();
        request.setFirstName("paul");
        request.setLastName("Oscar");
        request.setEmail("email@gmail.com");
        request.setPhoneNumber("08023291202");
        request.setPassword("1234");
        request.setNin("12345");
        request.setLocation("312 Hebert Macauley way, yaba ");
        return request;
    }

    @Test
    public void testThatTechnicianCanLogin(){
       LoginTechnicianRequest request = loginTechnician();
        LoginTechnicianResponse response = service.loginTechnician(request);
        assertNotNull(response);
    }

    private LoginTechnicianRequest loginTechnician(){
        LoginTechnicianRequest request = new LoginTechnicianRequest();
        request.setTechnicianId(1L);
        return request;
    }

    @Test
    public void testThatTechnicianCanLogout(){
        LogoutTechnicianRequest request = logoutTechnician();
        LogoutTechnicianResponse response = service.logoutTechnician(request);
        assertNotNull(response);
    }

    private LogoutTechnicianRequest logoutTechnician(){
        LogoutTechnicianRequest request = new LogoutTechnicianRequest();
        request.setTechnicianId(1L);
        return request;
    }

    @Test
    public void testThatTechnicianCanChangeAvailabilityStatus(){
        AvailabilityStatusRequest request = availabilityStatusRequest();
        AvailabilityStatusResponse response = service.changeAvailability(request);
        assertNotNull(response);
    }

    private AvailabilityStatusRequest availabilityStatusRequest(){
        AvailabilityStatusRequest request = new AvailabilityStatusRequest();
        request.setTechnicianId(1L);
        request.setIsAvailable(Availability.AVAILABLE);
        return request;
    }

    @Test
    public void testThatTechnicianCanSubscribe(){
        SubscriptionRequest request = subscriptionRequest();
        SubscriptionResponse response = service.subscribe(request);
        assertNotNull(response);
    }

    private SubscriptionRequest subscriptionRequest(){
        SubscriptionRequest request = new SubscriptionRequest();
        request.setPaid(true);
        request.setTechnicianId(1L);
        request.setSubscriptionStatus(SubscriptionStatus.PREMIUM);
        request.setStartDate(LocalDate.now());
        request.setEndDate(LocalDate.now().plusDays(30));
        request.setSubscriptionType(SubscriptionType.MONTHLY);
        return request;
    }

    @Test
    public void testThatTechnicianCanUpdateSubscription(){
        UpdateSubscriptionRequest request = updateSubscriptionRequest();
        SubscriptionResponse response = service.updateSubscription(request);
        assertNotNull(response);
    }

    private  UpdateSubscriptionRequest updateSubscriptionRequest(){
        UpdateSubscriptionRequest request = new UpdateSubscriptionRequest();
        request.setPaid(true);
        request.setTechnicianId(1L);
        return request;
    }
}