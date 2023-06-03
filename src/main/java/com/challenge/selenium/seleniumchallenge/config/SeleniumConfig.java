package com.challenge.selenium.seleniumchallenge.config;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class SeleniumConfig {
  private WebDriver driver;

  @PostConstruct
  public void built() {

    String userDirectory = System.getProperty("user.dir");

    File driverFile = new File(userDirectory + "/src/main/resources/v/111/chromedriver");
    System.setProperty("webdriver.chrome.driver", driverFile.getAbsolutePath());


    try {
      driver = new ChromeDriver(getBroserConfig());
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  private ChromeOptions getBroserConfig() {
    Map<String, Object> chromePrefs = new HashMap<String, Object>();
    chromePrefs.put("profile.default_content_settings.popups", 0);
    chromePrefs.put("download.default_directory", "./tmp");

    chromePrefs.put("plugins.plugins_disabled", "Chrome PDF Viewer");
    chromePrefs.put("profile.default_content_settings.popups", 0);
    chromePrefs.put("download.prompt_for_download", false);
    chromePrefs.put("safebrowsing.enabled", true);
    ChromeOptions options = new ChromeOptions();

    options.addArguments("--window-size=1920,1080");
    options.addArguments("--test-type");
    options.addArguments("--disable-gpu");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--disable-software-rasterizer");
    options.addArguments("--disable-popup-blocking");
    options.addArguments("--disable-extensions");
    options.addArguments("--incognito");
    options.addArguments("--remote-allow-origins=*");
    options.addArguments("--disk-cache-size=0");

    options.setExperimentalOption("prefs", chromePrefs);
    return options;
  }
}
