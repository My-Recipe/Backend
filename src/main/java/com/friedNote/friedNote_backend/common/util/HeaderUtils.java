package com.friedNote.friedNote_backend.common.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * ServletUtils을 이용해서 HttpServletRequest, HttpServletResponse 가져올때 시간이 얼마나 걸리는지 확인.
 * 시간이 너무 오래 걸리면 이 메소드를 사용하지 않고 파라미터로 HttpServletRequest, HttpServletResponse를 받아서 사용.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HeaderUtils {

    public static String getHeader(String headerName){
        HttpServletRequest request = ServletUtils.getRequest();
        return request.getHeader(headerName);
    }

    public static void setHeader(String headerName, String headerValue){
        HttpServletResponse response = ServletUtils.getResponse();
        response.setHeader(headerName, headerValue);
    }

}
