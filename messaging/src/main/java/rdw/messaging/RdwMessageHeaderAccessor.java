package rdw.messaging;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.util.MimeType;

/**
 * A {@link org.springframework.messaging.support.MessageHeaderAccessor}
 * implementation giving access to RDW-specific headers.<br/>
 */
public class RdwMessageHeaderAccessor extends MessageHeaderAccessor {

    /**
     * Wrap a message's headers.
     *
     * @param message message to extract headers from
     * @return a new RdwMessageHeaderAccessor
     */
    public static RdwMessageHeaderAccessor wrap(Message<?> message) {
        return new RdwMessageHeaderAccessor(message);
    }

    /**
     * Helper to set content type from a string and return the typed accessor.
     * Note the header value will be a {@link MimeType} not a String.
     *
     * @param contentType content type as a string, e.g. "application/xml"
     * @return this accessor
     */
    public RdwMessageHeaderAccessor setContentType(final String contentType) {
        setContentType(MimeType.valueOf(contentType));
        return this;
    }

    /**
     * @param content RDW content type, e.g. "exam"
     * @return this accessor
     * @see RdwMessageHeaderAccessor#getContent()
     */
    public RdwMessageHeaderAccessor setContent(final String content) {
        setHeader(RdwMessageHeaders.Content, content);
        return this;
    }

    /**
     * @return RDW content type, e.g. "exam"
     * @see RdwMessageHeaderAccessor#setContent(String)
     */
    public String getContent() {
        return (String) getHeader(RdwMessageHeaders.Content);
    }

    /**
     * Set 'received' header. This is stored in epoch milliseconds to allow for the most compatibility.
     * This should be interpreted carefully if time zone information is going to be introduced; assuming
     * the same time zone as the receiving server, something like:<pre>
     * Instant.ofEpochMilli(received)
     *        .atZone(ZoneId.systemDefault())
     *        .toLocalDateTime()
     * </pre>
     *
     * @param millis received timestamp in epoch milliseconds
     * @return this accessor
     * @see RdwMessageHeaderAccessor#setReceivedNow()
     * @see RdwMessageHeaderAccessor#getReceived()
     */
    public RdwMessageHeaderAccessor setReceived(final long millis) {
        setHeader(RdwMessageHeaders.Received, millis);
        return this;
    }

    /**
     * Set received timestamp to now.
     *
     * @return this accessor
     * @see RdwMessageHeaderAccessor#setReceived(long)
     * @see RdwMessageHeaderAccessor#getReceived()
     */
    public RdwMessageHeaderAccessor setReceivedNow() {
        return setReceived(System.currentTimeMillis());
    }

    /**
     * @return received timestamp in epoch milliseconds
     * @see RdwMessageHeaderAccessor#setReceived(long)
     */
    public Long getReceived() {
        return (Long) getHeader(RdwMessageHeaders.Received);
    }

    /**
     * @param login user login, e.g. test@example.com
     * @return this accessor
     * @see RdwMessageHeaderAccessor#getUserLogin()
     */
    public RdwMessageHeaderAccessor setUserLogin(final String login) {
        setHeader(RdwMessageHeaders.UserLogin, login);
        return this;
    }

    /**
     * @return user login, e.g. test@example.com
     * @see RdwMessageHeaderAccessor#setUserLogin(String)
     */
    public String getUserLogin() {
        return (String) getHeader(RdwMessageHeaders.UserLogin);
    }

    /**
     * Set user tenancy chain as a string; for now, avoiding dependency on utils so this:<pre>
     * final TenancyChain tenancyChain = ...;
     * accessor.setUserTenancyChain(tenancyChain.toString())
     * </pre>
     *
     * @param chain user tenancy chain as a string, e.g. "||GENERAL|STATE|...|"
     * @return this accessor
     * @see RdwMessageHeaderAccessor#getUserTenancyChain()
     */
    public RdwMessageHeaderAccessor setUserTenancyChain(final String chain) {
        setHeader(RdwMessageHeaders.UserTenancyChain, chain);
        return this;
    }

    /**
     * Get user tenancy chain as a string; for now, avoiding dependency on utils so this:<pre>
     * final TenancyChain tenancyChain = TenancyChain.fromString(accessor.getUserTenancyChain());
     * if (!tenancyChain.isEmpty()) ...
     * </pre>
     *
     * @return user tenancy chain as a string, e.g. "||GENERAL|STATE|...|"
     * @see RdwMessageHeaderAccessor#setUserTenancyChain(String)
     */
    public String getUserTenancyChain() {
        return (String) getHeader(RdwMessageHeaders.UserTenancyChain);
    }


    private RdwMessageHeaderAccessor(final Message<?> message) {
        super(message);
    }
}