package com.zhr.webselenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ChromeTest
 * @Date 2019-10-22 16:52
 * @description 简单demo
 **/
public class ChromeTest {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() {
        // Your test code here
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        driver.get("http://www.baidu.com");
        System.out.println("driver***************" + driver.getTitle());
        assertThat(driver.getTitle(), containsString("百度一下"));
    }
}
