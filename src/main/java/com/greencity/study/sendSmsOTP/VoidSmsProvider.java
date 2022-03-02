package com.greencity.study.sendSmsOTP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service(value="voidSmsProvider")
public class VoidSmsProvider implements SmsProvider {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getSenderName() {
        return "VOID";
    }

    @Override
    public boolean sendSms(String mobile, String text) {
        logger.info("短信发送插件【Void】。mobile: {}, content: {}", mobile, text);
        return true;
    }

    @Override
    public boolean checkDelivered(String mobile) {
        return true;
    }

    @Override
    public boolean matches(String mobile) {
        return true;
    }

    @Override
    public int getPriority() {
        return 0;
    }

//    @Override
//    public void setLogger(Logger logger) {
//
//    }
}
