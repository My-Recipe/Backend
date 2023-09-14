package com.friedNote.friedNote_backend.domain.Email;

import com.friedNote.friedNote_backend.domain.alarm.application.dto.request.AlarmRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSendService {

    private final JavaMailSender javaMailSender;

    @Async
    public void sendEmail(AlarmRequest.AlarmCreateRequest alarmCreateRequest) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(alarmCreateRequest.getEmail());
        message.setSubject("FriedNote 알림");
        message.setFrom("FriedNote@gmail.com");
        message.setText("안녕하세요. FriedNote 입니다. \n" +
                "해당 재료의 유통기한이 얼마 남지 않았습니다. \n" +
                "기한 : " + alarmCreateRequest.getDeadline() + "\n" +
                "기한이 지난 물품은 폐기해주시길 바랍니다. \n" +
                "감사합니다. \n" +
                "FriedNote 드림.");
        try {
            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
