import com.weixin.PayRefund;
import com.weixin.WeiXinUtilWap;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

public class TestPay {

    @Value("${wxp12}")
    private String zhengShu;

    @Test
    public void testPay() {

        String s = PayRefund.wxRefund("F:/ding/src/main/resources/apiclient_cert.p12",
                WeiXinUtilWap.mch_id, "z2018102472341000000", "7.5",
                "z20181024723410000001", "7.5");
        System.out.println(s);
    }
}
