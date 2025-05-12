package api.poja.app.service;

import api.poja.app.endpoint.event.model.SendEmailRequested;
import api.poja.app.service.event.SendEmailRequestedService;
import jakarta.mail.internet.InternetAddress;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HelloWorldService {
  private final SendEmailRequestedService sendEmailRequestedService;

  @SneakyThrows
  public String sendHelloWorldWithAsyncEmail(String to) {
    var event = SendEmailRequested.builder().to(new InternetAddress(to)).build();

    sendEmailRequestedService.accept(event);

    return "Your Hello World Email has been sent to " + to;
  }
}
