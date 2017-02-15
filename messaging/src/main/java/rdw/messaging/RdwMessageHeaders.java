package rdw.messaging;

import org.springframework.messaging.MessageHeaders;

/**
 * Pre-defined names and prefixes to be used for setting and/or retrieving RDW message properties
 * from/to {@link org.springframework.messaging.Message Message} Headers.<br/>
 * <p>
 * The naming convention uses prefixes to scope a header. Thus, all these will have "rdw_" as the
 * prefix. Additional prefixes may be used to further scope a header. The header key itself should
 * be camel-cased. For example, rdw_attr_shoeSize.
 * </p>
 */
public class RdwMessageHeaders {

    private static final String Prefix = "rdw_";

    static final String Content = Prefix + "content";
    static final String Received = Prefix + "received";

    private static final String UserPrefix = Prefix + "user_";
    static final String UserLogin = UserPrefix + "login";
    static final String UserTenancyChain = UserPrefix + "tenancyChain";
}
