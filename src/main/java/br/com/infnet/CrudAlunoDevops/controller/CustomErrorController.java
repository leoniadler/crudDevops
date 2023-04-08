package br.com.infnet.CrudAlunoDevops.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        // Aqui você pode adicionar lógica para lidar com diferentes tipos de erros
        return "error";
    }

    public String getErrorPath() {
        return "/error";
    }
}

