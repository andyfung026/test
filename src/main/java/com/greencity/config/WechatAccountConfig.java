package com.greencity.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2020/10/21/021 9:42
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {


    private String mpAppId;

    private String mpAppSecret;

}
