package com.airconsole.wm_cms.listener.payload.request.auth;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.*;

@Data
@ToString
public class SignUpRequest {
    @NotBlank
    @Size(min = 4, max = 255)
    private String full_name;

    @NotBlank
    @Size(min = 5, max = 32)
    private String username;

    @NotBlank
    @Size(max = 255)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 32)
    private String password;
}