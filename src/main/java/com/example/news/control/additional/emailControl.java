package com.example.news.control.additional;
import com.example.news.service.additional.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jirong")
public class emailControl {
    @Autowired
    private EmailService emailService;
    @PostMapping("/email/{account}")
    public String email(@PathVariable("account") String account) {
//        前端页面不能有等待
//        调用发送邮件
//        email.sendText();
//        要转几秒才能发送,前端观感不好，故用spring的异步任务
//        用body转字符串容易错误，还是传类吧
        System.out.println(account);
        try {
            emailService.sendText(account);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("发送邮箱失败");
        }
        return "邮箱发送成功,请注意查收";
    }
}
