package com.virgosol.test;

import com.virgosol.utulities.ConfigurationReader;
import com.virgosol.utulities.Driver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(TestResultLogger.class)
public class TestBase {

    protected WebDriver driver;

        @BeforeAll
        public void setUpMethod(){
            driver = Driver.get();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(ConfigurationReader.get("url"));


        }

        @AfterAll
        public void afterMethod() throws InterruptedException {
            Thread.sleep(2000);
            Driver.closeDriver();
        }

    }
