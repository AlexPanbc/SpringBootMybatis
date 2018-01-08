package com.example.demo.controller;

 import com.example.demo.utils.R;
import com.google.code.kaptcha.Constants;
import com.example.demo.utils.ShiroUtils;
import com.google.code.kaptcha.Producer;
 import org.apache.shiro.authc.*;
 import org.apache.shiro.crypto.hash.Sha256Hash;
 import org.apache.shiro.subject.Subject;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Alex on 2018/1/6.
 */
@RestController
@RequestMapping
public class LoginController {


//    @Autowired
//    private Producer producer;

    @RequestMapping
    public void captcha(HttpServletResponse response) throws ServletException, IOException {
//        response.setHeader("Cache-Control", "no-store,no-cache");
//        response.setContentType("image/jpeg");
//
//        //// TODO: 2018/1/8  生成文字验证码
//        String text = producer.createText();
//        // TODO: 2018/1/8 生成图片验证码
//        BufferedImage image = producer.createImage(text);
//        // TODO: 2018/1/8 保存到session
//        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);
//
//        ServletOutputStream out = response.getOutputStream();
//        ImageIO.write(image, "jpg", out);
//        out.flush();
    }

    @PostMapping("/sys/login")
    public R login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("captcha") String captcha) throws IOException{
//        String kapthcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
//        if (!captcha.equalsIgnoreCase(kapthcha))
//            return R.error("验证码不正确");
        try{
            Subject subject = ShiroUtils.getSubject();
            //sha256加密
            password = new Sha256Hash(password).toHex();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
        }catch (UnknownAccountException e) {
            return R.error(e.getMessage());
        }catch (IncorrectCredentialsException e) {
            return R.error(e.getMessage());
        }catch (LockedAccountException e) {
            return R.error(e.getMessage());
        }catch (AuthenticationException e) {
            return R.error("账户验证失败");
        }
        return R.ok("哈哈哈" + username + password);
    }
}
