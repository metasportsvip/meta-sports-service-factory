package com.example.factory.service;

/**
 * @Author: super
 * @Date: 2022/10/31 16:25
 */
public interface EmailService {
    Boolean sendWarning(String email, String subject, String content);
}
