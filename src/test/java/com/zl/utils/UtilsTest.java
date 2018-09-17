package com.zl.utils;

import org.junit.Test;

import javax.mail.MessagingException;

public class UtilsTest {

    @Test
    public void test(){

        String email = "test@lgzkd.com";
        String emailMsg="测试邮箱的方法是不是成功";
        try {
            MailUtils.sendMail(email,emailMsg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
