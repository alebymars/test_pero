package com.example.demo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;


abstract public class BaseTest {

    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @BeforeAll
    public static void setUp() {
        setUpAll();
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
