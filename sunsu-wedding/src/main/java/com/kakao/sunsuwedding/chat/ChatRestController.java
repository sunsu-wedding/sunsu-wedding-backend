package com.kakao.sunsuwedding.chat;

import com.kakao.sunsuwedding._core.security.CustomUserDetails;
import com.kakao.sunsuwedding._core.utils.ApiUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chat")
public class ChatRestController {
    private final ChatServiceImpl chatServiceImpl;

    // 채팅방 생성
    @PostMapping("")
    public ResponseEntity<?> addChat(@AuthenticationPrincipal CustomUserDetails userDetails,
                                     @Valid @RequestBody ChatRequest.AddChatDTO request) {
        ChatResponse.ChatDTO response = chatServiceImpl.addChat(userDetails.getUser(), request);
        return ResponseEntity.ok().body(ApiUtils.success(response));
    }
}
