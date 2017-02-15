package rdw.messaging;

import org.junit.Test;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.InvalidMimeTypeException;
import org.springframework.util.MimeType;

import static org.assertj.core.api.Assertions.assertThat;
import static rdw.messaging.RdwMessageHeaderAccessor.wrap;

public class RdwMessageHeaderAccessorTest {

    @Test
    public void itShouldSetAndGetRdwValues() {
        final String content = "TRT_V0";
        final long received = System.currentTimeMillis();
        final String login = "test@example.com";
        final String chain = "|CA|ASMTDATALOAD|STATE|98765|CA98765|||CA|CALIFORNIA|||||||||";
        final Message message = MessageBuilder.createMessage("payload", wrap(null)
                .setContent(content)
                .setReceived(received)
                .setUserLogin(login)
                .setUserTenancyChain(chain)
                .getMessageHeaders());

        final RdwMessageHeaderAccessor accessor = wrap(message);

        assertThat(accessor.getContent()).isEqualTo(content);
        assertThat(accessor.getReceived()).isEqualTo(received);
        assertThat(accessor.getUserLogin()).isEqualTo(login);
        assertThat(accessor.getUserTenancyChain()).isEqualTo(chain);
    }

    @Test
    public void setReceivedNowIsHandy() {
        final Message message = MessageBuilder.createMessage("payload", wrap(null)
                .setReceivedNow()
                .getMessageHeaders());
        assertThat(wrap(message).getReceived()).isNotNull();
    }

    @Test
    public void itShouldSetContentTypeAsString() {
        final Message message = MessageBuilder.createMessage("payload", wrap(null)
                .setContentType("application/xml")
                .getMessageHeaders());

        assertThat(wrap(message).getContentType()).isEqualTo(MimeType.valueOf("application/xml"));
    }

    @Test(expected = InvalidMimeTypeException.class)
    public void itRequiresANonBlankContentType() {
        MessageBuilder.createMessage("payload", wrap(null)
                .setContentType("")
                .getMessageHeaders());
    }

    @Test(expected = InvalidMimeTypeException.class)
    public void itRequiresAValidContentType() {
        MessageBuilder.createMessage("payload", wrap(null)
                .setContentType("notvalid")
                .getMessageHeaders());
    }
}
