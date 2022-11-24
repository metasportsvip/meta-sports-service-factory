package com.example.factory.service.impl;

import com.example.factory.service.EmailService;
import com.example.factory.utils.AwsSendEmail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: super
 * @Date: 2022/10/31 16:25
 */
@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    @Override
    public Boolean sendWarning(String email, String subject, String content) {
        log.info("Start sending warning mail, email: {}, subject: {}, content: {}", email, subject, content);
        try {
            AwsSendEmail.send(content, subject, email);
        } catch (Exception e) {
            log.error("sending_warning_mail_error:" + e.getMessage());
            return false;
        }
        return true;
    }
}
