import org.junit.Test;
import org.zhanghx.webdemo.webdemo.commons.JdbcUtils;

import java.sql.Connection;

public class TestJdbcUtils {

    @Test
    public void testJdbcUtils(){
        Connection connection = JdbcUtils.getConnection();
    }
}
