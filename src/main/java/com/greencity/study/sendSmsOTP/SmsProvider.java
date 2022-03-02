package com.greencity.study.sendSmsOTP;

import org.slf4j.Logger;

public interface SmsProvider {
    /**
     * 获得插件的名字
     *
     * @return a {@link String} object.
     */
    String getSenderName();
    /**
     * 发送短信
     *
     * @param mobile 手机号
     * @param message 短信内容
     * @return a boolean.
     */
    boolean sendSms(String mobile, String message);

    /**
     * 检查短信是否发送成功
     *
     * @param mobile a {@link String} object.
     * @return a boolean.
     */
    boolean checkDelivered(String mobile);

    /**
     * 检查当前插件是否支持该手机号
     *
     * @param mobile a {@link String} object.
     * @return a boolean.
     */
    boolean matches(String mobile);

    /**
     * 获取当前插件的优先级
     *
     * @return a int.
     */
    int getPriority();

    /**
     * 设置日志组件，用于记录日志
     *
     * @param logger a {@link Logger} object.
     */
//    void setLogger(Logger logger);
}
