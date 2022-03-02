package com.greencity.study.sendSmsOTP;


import javax.annotation.Resource;


public class SendSms {
    public static void main(String[] args) {

        SendSms sendSms =
                new SendSms();
        String s = sendSms.sendOTP();
        System.out.println(s);
    }

    @Resource
    private SmsService smsService;

    private String sendOTP() {


        String otp = RandomUtils.randomOtp(6);
        //发送短信
        boolean result = smsService.sendOrderOtp("13838289692", otp);
        if (result) {
            System.out.println(otp);
        }else {
            return otp;
        }
        return null;
    }
}
