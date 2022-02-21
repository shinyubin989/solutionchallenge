package we_won.hackerton.emailAuthentication;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/authenticate")
public class EmailController {

  private final EmailServiceImpl emailService;

  @GetMapping("/mail")
  public void emailConfirm(@RequestBody String email) throws Exception {
    emailService.sendSimpleMessage(email);
  }

  @GetMapping("/verifyCode")
  public boolean verifyCode(@RequestBody String code) {
    boolean result = false;

    if (EmailServiceImpl.ePw.equals(code)) {
      result = true;
    }
    return result;
  }


}
