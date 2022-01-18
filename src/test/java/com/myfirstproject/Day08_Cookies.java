package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Day08_Cookies extends TestBase {

    @Test
    public void handleCookies() throws InterruptedException {

        driver.get("https://www.amazon.com");

        Set<Cookie> allCookies= driver.manage().getCookies();
        int numberOfCookies=allCookies.size();
        System.out.println(numberOfCookies);

        //print all cookies
        for(Cookie eachCookie:allCookies){
            System.out.println("Each Cookie: "+eachCookie);
            System.out.println("Each Cookie Name: "+eachCookie.getName());
            System.out.println("Each Cookie Value: "+eachCookie.getValue());

            //get cookies by their name
            System.out.println("Cookie name i18n-prefs: "+driver.manage().getCookieNamed("i18n-prefs"));
            //Add new cookie
            //1.Create
            Cookie cookie=new Cookie("My-Fav-Cookie","White-Chocolate");
       //2.add
           driver.manage().addCookie(cookie);
            //check
            allCookies=driver.manage().getCookies();
            System.out.println(allCookies.size());//9
//5.Delete
            driver.manage().deleteCookieNamed("i18n-prefs");//delete last cookie
            driver.manage().deleteCookieNamed("session-id");
            allCookies=driver.manage().getCookies();
            System.out.println(allCookies.size());//9


   //6.Delete all of the Cookies
           driver.manage().deleteAllCookies();
           Thread.sleep(1000);
            System.out.println(allCookies.size());
        }


    }
}
