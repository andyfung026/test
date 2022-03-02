package com.greencity.study.sendSmsOTP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service(value="firstInformationSmsProvider")
public class FirstInformationSmsProvider implements SmsProvider {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    // 服务URL
    @Value("${sms.firstinformation.url}")
    private String url;
    // 用户名
    @Value("${sms.firstinformation.username}")
    private String userName;
    // 密码
    @Value("${sms.firstinformation.password}")
    private String password;
    // 短信签名
    @Value("${sms.firstinformation.sign}")
    private String sign;

    private boolean sendSmsFinal(String mobile, String msg) {

        StringBuilder arge = new StringBuilder();

        arge.append("name=");
        arge.append(this.userName);
        arge.append("&pwd=");
        arge.append(this.password);
        arge.append("&content=");
        arge.append(msg);
        arge.append("&mobile=");
        arge.append(mobile);
        arge.append("&sign=");
        arge.append(this.sign);
        arge.append("&type=pt");

        String resp = null;
        try {
            resp = HttpStreamRequest.http(this.url, arge.toString());

            logger.info("Plugin: [{}], mobile: {}, message: {}", this.getSenderName(), mobile, msg);
            logger.info("Plugin: [{}], result: >> {}", this.getSenderName(), resp);

            return !StringUtils.isEmpty(resp) && "0".equals(resp.split(",")[0]);

        } catch (Exception e) {
            logger.error("sms send exception", e);
        }
        return false;
    }

    @Override
    public String getSenderName() {
        return "第一信息";
    }

    /** {@inheritDoc} */
    @Override
    public boolean sendSms(String mobile, String message) {
        return sendSmsFinal(mobile,message);
    }

    @Override
    public boolean checkDelivered(String mobile) {
        return false;
    }

    @Override
    public boolean matches(String mobile) {
        return false;
    }

    @Override
    public int getPriority() {
        return 0;
    }
//
//    @Override
//    public void setLogger(Logger logger) {
//
//    }
}
