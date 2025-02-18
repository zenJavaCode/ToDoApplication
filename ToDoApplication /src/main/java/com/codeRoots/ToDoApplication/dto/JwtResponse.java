package com.codeRoots.ToDoApplication.dto;

import com.codeRoots.ToDoApplication.model.User;

public record JwtResponse(
        String accessToken,
        String refreshToken,
        User user
) {
}
