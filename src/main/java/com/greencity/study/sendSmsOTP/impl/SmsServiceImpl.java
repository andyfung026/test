package com.greencity.study.sendSmsOTP.impl;


import com.greencity.study.sendSmsOTP.SmsProvider;
import com.greencity.study.sendSmsOTP.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Qualifier;


@Service
public class SmsServiceImpl implements SmsService {
    static String TEMPLATE_REGISTER_OTP = "亲爱的用户，您的注册验证码为：%s，请勿转告他人哟。";
    static String TEMPLATE_LOGIN_OTP = "亲爱的用户，您的登录验证码为：%s，请勿转告他人哟。";
    static String TEMPLATE_ORDER_OTP = "亲爱的用户，本次工资发放的验证码为：%s，请勿转告他人哟。";
    static String TEMPLATE_WITHDRAW_OTP = "亲爱的用户，本次提现的验证码为：%s，请勿转告他人哟。";
    static String TEMPLATE_RESET_OTP = "亲爱的用户，您的重置验证码为：%s，请勿转告他人哟。";

    @Value("${sms.enabled}")
    private boolean smsEnabled;

    @Autowired
    @Qualifier(value = "firstInformationSmsProvider")
    SmsProvider provider;

    @Autowired
    @Qualifier(value = "voidSmsProvider")
    SmsProvider voidProvider;

    private boolean sendSmsFinal(String mobile, String message) {
        if (smsEnabled) {
            return provider.sendSms(mobile, message);
        } else {
            return voidProvider.sendSms(mobile, message);
        }
    }
    @Override
    public boolean sendOrderOtp(String mobile, String otp) {
        String message = String.format(TEMPLATE_ORDER_OTP, otp);
        return sendSmsFinal(mobile, message);
    }

}
