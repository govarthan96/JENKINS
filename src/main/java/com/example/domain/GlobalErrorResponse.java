package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GlobalErrorResponse {

    private HttpStatus httpStatus;

    private Timestamp timestamp;

    private int errorCode;

    private  String errorMsg;

}
