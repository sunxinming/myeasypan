package com.myeasypan.controller;

import com.myeasypan.entity.constants.Constants;
import com.myeasypan.entity.dto.CreateImageCode;
import com.myeasypan.exception.BusinessException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author sunxinming
 * @version v1.0
 */
@RestController("accountController")
public class AccountController {
    /**
     * @param response
     * @param session  用于存储图片验证码
     * @param type
     * @throws IOException 获取图片验证码
     */
    @RequestMapping("/checkCode")
    public void checkCode(HttpServletResponse response, HttpSession session, Integer type) throws
            IOException {
        CreateImageCode vCode = new CreateImageCode(130, 38, 5, 10);
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        String code = vCode.getCode();
        if (type == null || type == 0) {
            session.setAttribute(Constants.CHECK_CODE_KEY, code);
        } else {
            session.setAttribute(Constants.CHECK_CODE_KEY_EMAIL, code);
        }
        vCode.write(response.getOutputStream());
    }

    @RequestMapping("/sendEmailCode")
    public void sendEmailCode(HttpSession session, String email, String CheckCode, Integer type) {
        if(!CheckCode.equalsIgnoreCase((String) session.getAttribute(Constants.CHECK_CODE_KEY_EMAIL))){
            throw new BusinessException("图片验证码不正确");
        }

    }

}
