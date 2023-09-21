package com.zalopay.user.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultResponse<T> {
    private Long status;
    private String message;
    private T result;
}
