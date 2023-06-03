package com.challenge.selenium.seleniumchallenge;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.challenge.selenium.seleniumchallenge.config.SeleniumConfig;

@SpringBootTest
@AutoConfigureMockMvc
@Execution(ExecutionMode.CONCURRENT)
class SeleniumChallengeApplicationTests {
  @Autowired
  SeleniumConfig seleniumConfig;

  @Test
  void firtTest() throws InterruptedException {
    WebDriver driver = seleniumConfig.getDriver();

    driver.get("https://www.mdzol.com/");

    implicitlyWait(2, TimeUnit.SECONDS);

    WebElement okButtonWe = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[3]/div[2]/button[2]"));

    if (okButtonWe.isEnabled() && okButtonWe.isDisplayed()) {
      okButtonWe.click();
    }

    implicitlyWait(5, TimeUnit.SECONDS);

    WebElement portalSelectionWe = driver.findElement(By.xpath("//*[@id=\"portada-pp\"]/div/div[1]/a"));

    if (portalSelectionWe.isDisplayed() && portalSelectionWe.isEnabled()) {
      portalSelectionWe.click();
    }

    driver.close();

  }


  public static void implicitlyWait(long l, TimeUnit timeUnit) {
    try {
      Thread.sleep(timeUnit.toMillis(l));
    } catch (InterruptedException ex) {
      // Ignore exception
    }
  }

}
