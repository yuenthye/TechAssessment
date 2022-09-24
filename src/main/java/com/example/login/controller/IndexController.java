package com.example.login.controller;

import com.sun.istack.localization.Localizer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

@Controller
public class IndexController {
    @CrossOrigin
    @GetMapping("/")
    public String getRestricted(HttpServletRequest request ) throws UnsupportedEncodingException {
        Locale currentLocale = request.getLocale();
        String countryCode = currentLocale.getCountry();
        String countryName = currentLocale.getDisplayCountry();

        String langCode = currentLocale.getLanguage();
        String langName = currentLocale.getDisplayLanguage();

        System.out.println(countryCode + ": " + countryName);
        System.out.println(langCode + ": " + langName);

        System.out.println("=============");
        String[] languages = currentLocale.getISOLanguages();

        for (String language : languages) {
            Locale locale = new Locale(language);
            System.out.println(language + ": " + locale.getDisplayLanguage());
        }
        return "login";

    }
}

