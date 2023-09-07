package com.dorukt.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EerrorType {
    DATABASE_VERI_UYUMSUZLUGU(0000, "Databasedeki veriler database üzerinden değiştirilmiş!", INTERNAL_SERVER_ERROR),
    SORGULAMA_YAPILAN_LISTE_BOS(0001, "Sorgulama yapılan liste herhangi bir öğe içermiyor!", NOT_FOUND),
    GECERSIZ_PARAMETRE(0002, "Geçersiz parametre girişi yaptınız!", BAD_REQUEST),
    UYGUNSUZ_GIRIS(0003, "Uygun olmayan bir giriş yaptınız!", BAD_REQUEST),
    HATALI_GIRIS(1000, "Kullanıcı adı veya şifre hatalı!", BAD_REQUEST),
    USER_NOT_FOUND(1001, "İşlem yapılmaya çalışılan  kullanıcı sistemde kayıtlı değil!", NOT_FOUND),
    USER_ALREADY_EXIST(1002, "Yaratılmaya çalışılan kullanıcı zaten mevcut!", BAD_REQUEST),
    WORK_NOT_FOUND(2001, "İşlem yapılmaya çalışılan çalışma sistemde kayıtlı değil!", NOT_FOUND);


    private int code;
    private String mesaj;
    private HttpStatus status;


}
