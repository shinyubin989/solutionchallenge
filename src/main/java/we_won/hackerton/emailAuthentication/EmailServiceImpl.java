package we_won.hackerton.emailAuthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Random;

@Service
public class EmailServiceImpl implements EmailService{

  @Autowired
  JavaMailSender emailSender;

  public static final String ePw = createKey();

  private MimeMessage createMessage(String to) throws Exception {
    System.out.println("보내는 대상 : " + to);
    System.out.println("인증 번호 : "+ ePw);
    MimeMessage message = emailSender.createMimeMessage();

    message.addRecipients(Message.RecipientType.TO, to);
    message.setSubject("CandiFormation 이메일 본인인증 코드 메일입니다.");

    String contentMessage = "";
    contentMessage += "<div style='margin:100px;'>";
    contentMessage += "<h1> 안녕하세요! CandiFormation 입니다. </h1>";
    contentMessage += "<br>";
    contentMessage += "<p>아래 코드를 회원가입 창으로 돌아가 입력해주세요.</p>";
    contentMessage += "<br>";
    contentMessage += "<p></p>";
    contentMessage += "<br>";
    contentMessage += "<div align='center' style='border:1px solid black; font-family:verdana';>";
    contentMessage += "<h3 style='color:blue;'>회원가입 인증 코드입니다.</h3>";
    contentMessage += "<div style='font-size:130%'>";
    contentMessage += "CODE : <strong>";
    contentMessage += ePw + "</strong><div><br/> ";
    contentMessage += "</div>";
    message.setText(contentMessage, "utf-8", "html"); // 내용
    message.setFrom(new InternetAddress("candiformation@gmail.com","CandiFormation")); // 보내는 사람

    return message;
  }

  public static String createKey() {
    StringBuffer stringBuffer = new StringBuffer();
    Random random = new Random();

    for (int i = 0; i < 6; i++) {
      int index = random.nextInt(2); // 0~1

      switch (index) {
        case 0:
          stringBuffer.append((char) ((int) (random.nextInt(26)) + 97)); // a~z
          break;
        case 1:
          stringBuffer.append((random.nextInt(10))); // 0~9
          break;
      }
    }
    return stringBuffer.toString();
  }

  @Override
  public String sendSimpleMessage(String to) throws Exception {
    MimeMessage message = createMessage(to);
    try {
      emailSender.send(message);
    } catch (MailException e) {
      e.printStackTrace();
      throw new IllegalArgumentException();
    }
    return ePw;
  }
}
