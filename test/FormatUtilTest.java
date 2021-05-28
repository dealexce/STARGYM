import Util.FormatUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author by Yechen He
 * @date 2021/5/27.
 */
class FormatUtilTest {
    public static FormatUtil formatUtil;

    @BeforeAll
    static void initial(){
        formatUtil = new FormatUtil();
    }
    @Test
    void checkTelephone() {
        assertTrue(formatUtil.checkTelephone("13339100726"));
    }

    @Test
    void checkPassword() {
        assertTrue(formatUtil.checkPassword("123456"));
    }
}