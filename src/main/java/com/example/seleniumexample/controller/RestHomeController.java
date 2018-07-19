package com.example.seleniumexample.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (c) 2018 ZUM Internet, Inc.
 * All right reserved.
 * http://www.zum.com
 * This software is the confidential and proprietary information of ZUM
 * , Inc. You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with ZUM.
 * <p>
 * Revision History
 * Author                    Date                     Description
 * ------------------       --------------            ------------------
 * ryugwanghyen                2018-07-19
 */
@RestController
public class RestHomeController {

	@RequestMapping("/")
	public String home(){
		System.setProperty("webdriver.chrome.driver", "src/test/driver/chromedriver.exe"); // 다운받은 ChromeDriver 위치를 넣어줍니다.
		WebDriver driver = new ChromeDriver(); // Driver 생성
		driver.get("http://zum.com"); // URL로 접속하기
		WebElement bannerLefttop = driver.findElement(By.id("banner_lefttop"));             //빅 배너
		WebElement adxZumMainLeftwing = driver.findElement(By.id("adx_zum_main_leftwing")); //left wing  배너
		WebElement wrapAdMain = driver.findElement(By.id("wrap_ad_main"));                  //left wing  배너

		bannerLefttop.findElement(By.tagName("a")).findElement(By.tagName("img"));      //빅 배너
		adxZumMainLeftwing.findElement(By.tagName("a")).findElement(By.tagName("img")); //left wing  배너

		WebDriver wrapAdMainIframe = driver.switchTo().frame(wrapAdMain.findElement(By.id("wrap_ad_main_iframe")));  //오른쪽 배너
		WebDriver adIframe = driver.switchTo().frame(wrapAdMainIframe.findElement(By.tagName("iframe")));
		adIframe.findElement(By.tagName("a"))
				.findElement(By.tagName("img"));
		driver.quit();  // Driver 종료
		return "home";
	}
}
