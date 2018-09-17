package com.zl.utils;

import org.junit.Test;

import javax.mail.MessagingException;

public class MailUtilsTest {

    @Test
    public void test(){
        String email = "test@lgzkd.com";
        String emailMsg = "这是一封激活邮件,请<a href=http://localhost:8080/stores/user?method=active&code=" + 12334+ ">点击激活" + 12334 + "</a>";
        try {
            MailUtils.sendMail(email, emailMsg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
