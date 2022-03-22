package br.com.danepic.kafkakeycloakapi.resource;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class Period {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime start;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime end;
}
