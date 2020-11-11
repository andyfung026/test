package com.greencity.controller;

import com.greencity.enums.ResultEnum;
import com.greencity.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLEncoder;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2020/10/20/020 17:26
 */

@Controller
@RequestMapping("/wechat")
@Slf4j
public class WechatController {

    @Autowired
    private WxMpService wxMpService;

    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnURL") String returnUrl) {
        //配置
        //调用方法
        String url = "http://4fbaf9.natappfree.cc/sell/wechat/userInfo";
        String resultUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_USER_INFO, URLEncoder.encode(returnUrl));
        return "redirect:" + resultUrl;
    }


    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code, @RequestParam("state") String resultUrl) {
        WxMpOAuth2AccessToken wxAccessToken = new WxMpOAuth2AccessToken();
        try {
            wxAccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.info("[微信网页授权]{}", e);
            throw new SellException(ResultEnum.WE_MP_ERROR.getCode(), e.getError().getErrorMsg());
        }
        String openId = wxAccessToken.getOpenId();

        return "redirect:" + resultUrl + "?openId" + openId;
    }

}
