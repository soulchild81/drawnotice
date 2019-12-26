package com.soulchild.drawnotice.util;

//import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
//
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;

import com.soulchild.drawnotice.model.Release;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoticeUtil {

    private final static String FROM = "soulchild@bugs.co.kr";
    private final static String[] TO = {"soulchild@bugs.co.kr" , "bbong32@naver.com" , "wozzzz@naver.com"};

    public static void send(String from, String[] to, String subject, String msg) throws IOException, MessagingException {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("ems.bugs.co.kr");

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

        helper.setTo(to);
        helper.setText(msg, true);
        helper.setSubject(subject);
        helper.setFrom(from);

        mailSender.send(message);
    }

      public static Map<String , Object> setMessage(List<Release> releaseList) {
        Map<String , Object> mailObject = new HashMap<>();

        String subject = "TODAY_NIKE_RELEASE";
        StringBuffer msg = new StringBuffer();
        msg.append("<html>");
        msg.append("<h1>TODAY NIKE RELEASE</h1>");

          for (Release release : releaseList) {
              msg.append("DATE: " + release.getMonth() + release.getDay() + "<br>")
                 .append("MODEL : " + release.getModel() + "<br>")
                 .append("RELEASE : " + release.getRelease_type() + "<br>")
                 .append("IMAGE :" + "<img src="+release.getImage()+" width=100/>" + "<br>");
          }
        msg.append("</html>");
        mailObject.put("subject" , subject);
        mailObject.put("msg" , msg);

        return mailObject;
    }

    public static void successMail(List<Release> releaseList){
        Map<String , Object> mailMap = setMessage(releaseList);
        try {
            send(FROM, TO, mailMap.get("subject").toString(), mailMap.get("msg").toString());
        }
        catch(Exception e){

        }
    }
//
//    public static void failedMail(JobExecution exec){
//        Map<String , Object> mailMap = setMessage(exec);
//        try {
//            send(FROM, TO, mailMap.get("subject").toString(), mailMap.get("msg").toString());
//        }
//        catch(Exception e){
//
//        }
//    }
}
