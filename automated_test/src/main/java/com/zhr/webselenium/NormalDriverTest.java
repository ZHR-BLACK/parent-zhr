package com.zhr.webselenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName NormalDriverTest
 * @Date 2019-10-22 17:11
 * @description 自定义浏览器的properties
 **/
public class NormalDriverTest {

    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        // 自定义浏览器properties
        WebDriverManager.firefoxdriver().config().setProperties("D://geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.baidu.com");
    }
}
