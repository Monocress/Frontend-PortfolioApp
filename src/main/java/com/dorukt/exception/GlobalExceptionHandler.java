package com.dorukt.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class GlobalExceptionHandler {

    private ErrorMesaj createErrorMesaj(EerrorType eerrorType) {
        return ErrorMesaj.builder().code(eerrorType.getCode())
                .mesaj(eerrorType.getMesaj())
                .status(eerrorType.getStatus())
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<String> handleException(Exception e) {
        e.printStackTrace();
        return ResponseEntity.badRequest().body("Beklenmeyen bir hata oluştu. Lütfen açıklamalara uygun giriş yaptığınıza emin olun." + e.getMessage());
    }


    @ExceptionHandler(ResultIsEmptyException.class)
    @ResponseBody
    public ResponseEntity<ErrorMesaj> handleResultIsEmptyException(ResultIsEmptyException e) {
        EerrorType eerrorType = e.getType();
        HttpStatus httpStatus = e.getType().getStatus();

        ErrorMesaj mesaj = createErrorMesaj(eerrorType);
        mesaj.setMesaj(e.getMessage());
        return new ResponseEntity<ErrorMesaj>(mesaj, httpStatus);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    public ResponseEntity<ErrorMesaj> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        EerrorType eerrorType = EerrorType.DATABASE_VERI_UYUMSUZLUGU;
        HttpStatus httpStatus = eerrorType.getStatus();

        ErrorMesaj mesaj = createErrorMesaj(eerrorType);
        return new ResponseEntity<ErrorMesaj>(mesaj, httpStatus);
    }


    @ExceptionHandler(IllegalStateException.class)
    @ResponseBody
    public ResponseEntity<ErrorMesaj> handleIllegalStateException(IllegalStateException e) {
        EerrorType eerrorType = EerrorType.UYGUNSUZ_GIRIS;
        HttpStatus httpStatus = eerrorType.getStatus();

        ErrorMesaj mesaj = createErrorMesaj(eerrorType);
        return new ResponseEntity<ErrorMesaj>(mesaj, httpStatus);
    }

}
