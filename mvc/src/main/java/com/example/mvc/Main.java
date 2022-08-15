package com.example.mvc;


import org.apache.catalina.startup.Tomcat;

import java.io.File;
import java.io.IOException;

public class Main {
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir(createTempDir());
        tomcat.setPort(PORT);
        tomcat.addWebapp("", new File( "mvc/src/main/").getAbsolutePath());
        tomcat.start();
        tomcat.getServer().await();
    }


    // based on AbstractEmbeddedServletContainerFactory
    private static String createTempDir() {
        try {
            File tempDir = File.createTempFile("tomcat.", "." + PORT);
            tempDir.delete();
            tempDir.mkdir();
            tempDir.deleteOnExit();
            return tempDir.getAbsolutePath();
        } catch (IOException ex) {
            throw new RuntimeException(
                    "Unable to create tempDir. java.io.tmpdir is set to " + System.getProperty("java.io.tmpdir"),
                    ex
            );
        }
    }
}
