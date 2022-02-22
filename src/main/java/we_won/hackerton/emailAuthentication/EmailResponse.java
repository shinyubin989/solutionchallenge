package we_won.hackerton.emailAuthentication;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import we_won.hackerton.response.BasicResponse;

@Getter
@Setter
public class EmailResponse extends BasicResponse {
  public EmailResponse(String email, boolean verify) {
    this.email = email;
    this.verify = verify;
  }

  private String email;
  private boolean verify;
}