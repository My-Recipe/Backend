package com.friedNote.friedNote_backend.domain.user.presentation;

import com.friedNote.friedNote_backend.common.exception.dto.ErrorResponse;
import com.friedNote.friedNote_backend.domain.user.application.dto.request.UserRequest;
import com.friedNote.friedNote_backend.domain.user.application.service.UserCreateUseCase;
import com.friedNote.friedNote_backend.domain.user.application.service.UserUpdateUseCase;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserUpdateUseCase userUpdateUseCase;

    private final UserCreateUseCase userCreateUseCase;

    /**
     *  OAuth2로 사용하지 않는 API
     */
    @Hidden
    @PostMapping("/user")
    public void createUser(@RequestBody UserRequest.UserCreateRequest userCreateRequest) {
        userCreateUseCase.createUser(userCreateRequest);
    }
    @Operation(summary = "사용자 정보 수정", tags = {"UserController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "유저 정보 수정 성공"),
            @ApiResponse(responseCode = "404", description = "유저 정보 수정 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/user/update")
    public void updateUser(@Parameter(description = "유저 정보 수정 요청"
            , schema = @Schema(implementation = UserRequest.UserUpdateRequest.class))
                               @RequestBody UserRequest.UserUpdateRequest userUpdateRequest) {
        userUpdateUseCase.userUpdate(userUpdateRequest);
    }
}
