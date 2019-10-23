package com.zhr.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName FirstDemo
 * @Date 2019-10-22 11:36
 * @description 打开百度，并依次搜索第0次、第1次、第2次
 **/
public class FirstDemo {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "D://geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        // 打开百度
        driver.get("http://www.baidu.com");
        Thread.sleep(500);
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.id("kw")).clear();

            Thread.sleep(500);

            driver.findElement(By.id("kw")).sendKeys("第" + i + "次");

            Thread.sleep(500);

            driver.findElement(By.id("su")).click();

            Thread.sleep(5000);
        }

    }
}
