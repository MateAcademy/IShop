package ua.ishop.klunniy.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * code fyti gxvj egkc cctl
 *
 */
public class SendEmailTLS {

    public static void main(String[] args) {

        final String username = "matesttest22@gmail.com";
        final String password = "fyti gxvj egkc cctl";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("s.klunniy@gmail.com")
            );
            message.setSubject("Одноразовый код для подтверждения покупки");
            message.setText(RandomCodeToEmail.get4DigitCode());

            //Вам этот код надо сохранить что бы потом вы могли проверить верный ли код ввел юзер

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}