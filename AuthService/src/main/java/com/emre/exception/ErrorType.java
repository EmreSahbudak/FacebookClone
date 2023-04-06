package com.emre.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ErrorType {

    USER_NOT_FOUND(2004,"Aradığınız Kitap adı bulunamadı",HttpStatus.NOT_FOUND),

    ERROR_INVALID_TOKEN(3000,"Geçersiz Token",HttpStatus.UNAUTHORIZED),

    BAD_REQUEST(4000,"Geçersiz istek yada parametre",HttpStatus.BAD_REQUEST),

    ERROR(9000,"Beklenmeyen bir hata oluştu. Lütfen daha sonra deneyiniz",
            HttpStatus.INTERNAL_SERVER_ERROR);

    int code;

    String message;

    HttpStatus httpStatus;
}
