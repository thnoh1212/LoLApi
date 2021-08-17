package com.practice.web.bind;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ApiReslut<T> {

    private final T result;
    private final String error;

    public ApiReslut(T result, String error) {
        this.result = result;
        this.error = error;
    }

    // 성공시 반환 Result
    public static <T> ApiReslut<T> success(T result){
        return new ApiReslut<>(result, null);
    }

    // 실패시 반환 형식
    public static ApiReslut<?> failed(Throwable throwable){
        return new ApiReslut<>(null, throwable.getMessage());
    }

    public boolean hasData(){
        return result != null;
    }
}
