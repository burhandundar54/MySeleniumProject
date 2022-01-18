package com.myfirstproject;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day08_FileExistTest {
    @Test
    public void isExist(){

        String homeDirectory= System.getProperty("user.home");//root path until Desktop-Downloads
        System.out.println(homeDirectory);

        //path of the image
        String pathOfImage= homeDirectory+"/Desktop/download.png";
        System.out.println(pathOfImage);

        boolean isExist=Files.exists(Paths.get(pathOfImage));
       Assert.assertTrue(isExist);

    }
}
