package com.wangdakeji.wongder.utils;

import org.junit.Test;

/**
 * description for this class
 * Created by wangda
 * on 17-11-8
 */
public class MailTest {
    @Test
    public void test() {
        SendMail s=new SendMail();
        s.sendResetPasswordEmail();
    }
}
