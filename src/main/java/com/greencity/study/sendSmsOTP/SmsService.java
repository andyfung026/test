package com.greencity.study.sendSmsOTP;

public interface SmsService {

//    /**
//     * 发送注册时的手机验证码
//     * @param mobile 手机号
//     * @param otp 验证码
//     * @return
//     */
//    boolean sendRegisterOtp(String mobile, String otp);
//
//    /**
//     * 发送登录时的手机验证码
//     * @param mobile 手机号
//     * @param otp 验证码
//     * @return
//     */
//    boolean sendLoginOtp(String mobile, String otp);

    /**
     * 客户发放时的手机验证码
     * @param mobile
     * @param otp
     * @return
     */
    boolean sendOrderOtp(String mobile, String otp);

//    /**
//     * 提现时的手机验证码
//     * @param mobile 手机号
//     * @param otp 验证码
//     * @return
//     */
//    boolean sendWithdrawOtp(String mobile, String otp);
//
//
//
//    /**
//     * 发送重置时的手机验证码
//     * @param mobile 手机号
//     * @param otp 验证码
//     * @return
//     */
//    boolean sendResetOtp(String mobile, String otp);
}
