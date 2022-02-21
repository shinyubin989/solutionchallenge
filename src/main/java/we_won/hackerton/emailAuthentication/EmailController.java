package we_won.hackerton.emailAuthentication;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/authenticate")
public class EmailController {

  private final EmailServiceImpl emailService;

  @PostMapping("/mail/{email}")
  public void emailConfirm(@PathVariable String email) throws Exception {
    System.out.println("emailcheck = " + email);
    emailService.sendSimpleMessage(email);
  }

  @PostMapping("/verifyCode/{code}")
  public boolean verifyCode(@PathVariable String code) {
    boolean result = false;

    if (EmailServiceImpl.ePw.equals(code)) {
      result = true;
    }
    return result;
  }


}
