package com.wangdakeji.wongder.utils;

import com.sun.mail.util.MailSSLSocketFactory;
import lombok.Data;
import org.junit.Test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

/**
 * description for this class
 * Created by wangda
 * on 17-11-8
 */
@Data
public class SendMail {
    private static final String SMTP_AUTH_USER = "appadmin@wangdakeji.cn";
    private static final String TO = "lxx3061313@163.com";
    private static final String SMTP_AUTH_PWD = "tdmwvhchfhksbedi";
    /**
     * 发送重设密码链接的邮件
     */
    public void sendResetPasswordEmail() {
        try {
            Session session = getSession();
            MimeMessage message = new MimeMessage(session);
            message.setSubject("[wangda-app]找回您的密码");
            message.setSentDate(new Date());
            message.setFrom(new InternetAddress(SMTP_AUTH_USER));
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(TO));
            message.setContent("新的密码:#$%#%1434wfrw4", "text/html;charset=utf-8");
            message.saveChanges();
            // 发送邮件
//            Transport transport = session.getTransport();
//            // Connect the transport object.
//            transport.connect("smtp.qq.com",587,SMTP_AUTH_USER,SMTP_AUTH_PWD);
//            // Send the message.
//            transport.sendMessage(message, message.getAllRecipients());
//            // Close the connection.
//            transport.close();
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Session getSession() throws GeneralSecurityException {
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", "smtp.qq.com");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.auth", "true");
//        props.setProperty("mail.debug", "true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        // or
        // sf.setTrustedHosts(new String[] { "my-server" });
        props.put("mail.smtp.ssl.enable", "true");
        // also use following for additional safety
        //props.put("mail.smtp.ssl.checkserveridentity", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);
        Session session = Session.getInstance(props, new SMTPAuthenticator(SMTP_AUTH_USER,SMTP_AUTH_PWD));
        return session;
    }

    class SMTPAuthenticator extends javax.mail.Authenticator {
        private String username;
        private String password;
        public SMTPAuthenticator(String user, String password) {
            this.username = user;
            this.password = password;
        }
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }


    }


}
