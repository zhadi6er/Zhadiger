package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        MyApplication application = new MyApplication();
        System.out.println("An application is about to start..");
        application.start();
    }
}
