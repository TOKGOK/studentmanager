package com.wdd.studentManager.dto;

import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;

@Data
public class LoginDto {
    String username;
    String password;
    String code;
    String type;
    HttpSession session;
}
