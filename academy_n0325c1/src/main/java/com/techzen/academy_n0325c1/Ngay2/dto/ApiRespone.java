package com.techzen.academy_n0325c1.Ngay2.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.codec.ServerSentEvent;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
    public class ApiResponse<T> {
       private Integer code;
       private String message;
        T data;


}

