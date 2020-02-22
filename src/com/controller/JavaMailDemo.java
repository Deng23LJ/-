package com.controller;

import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailDemo {

//      public String send = "1522027162@qq.com";
//      public String receiveAcount = "2893678895@qq.com";
//

        public static void main(String[] args) throws Exception{
            Properties properties = new Properties();
            properties.setProperty("mail.transport.protocol", "smtp");//邮箱协议
            properties.setProperty("mail.smtp.host", "smtp.qq.com");//邮箱地址
            properties.setProperty("mail.smtp.port", "465");//邮箱端口
            properties.setProperty("mail.smtp.auth", "true");//邮箱授权
            //ssl安全认证
            properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            properties.setProperty("mail.smtp.socketFactory.fallback", "false");
            properties.setProperty("mail.smtp.socketFactory.port", "465");
            Session session = Session.getInstance(properties);
            session.setDebug(true);
            MimeMessage message = createMimeMessage(session,"1522027162@qq.com","1502629703@qq.com");
            Transport transport = session.getTransport();
            transport.connect("1522027162@qq.com","lyyvtabqkvmphgie");
            transport.sendMessage(message,message.getAllRecipients());
            transport.close();
        }
    public static MimeMessage createMimeMessage(Session session, String send,String receive) throws Exception {
        MimeMessage mimeMessage = new MimeMessage(session);
        //简单邮件
        Address address = new InternetAddress(send, "发件人的名字", "UTF-8");
        mimeMessage.setFrom(address);
        mimeMessage.setSubject("这是标题", "UTF-8");
       //收件人类型；普通
        mimeMessage.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(receive,"收件人邓居昌","UTF-8"));
        mimeMessage.setContent("hello", "text/html;charset=UTF-8");
        mimeMessage.setSentDate(new Date());//设置发送时间
        mimeMessage.saveChanges();
        return mimeMessage;


    }

}
