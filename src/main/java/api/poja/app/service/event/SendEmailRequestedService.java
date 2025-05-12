package api.poja.app.service.event;

import api.poja.app.endpoint.event.model.SendEmailRequested;
import api.poja.app.mail.Email;
import api.poja.app.mail.Mailer;
import java.util.List;
import java.util.function.Consumer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SendEmailRequestedService implements Consumer<SendEmailRequested> {
  private final Mailer mailer;

  @Override
  public void accept(SendEmailRequested sendEmailRequested) {
    var email =
        new Email(
            sendEmailRequested.getTo(),
            List.of(),
            List.of(),
            "Hello world email",
            "<h1>Hello World !</h1>",
            List.of());

    mailer.accept(email);
  }
}
