package com.michaelkatan.debtrecord.main;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class DebtRecordErrorController implements ErrorController
{
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request)
    {
        final Object attribute = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        return "error";
    }



    @Override
    public String getErrorPath() {
        return "/error";
    }
}
