package com.example.jakartaee;


import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

import java.io.File;
import java.io.IOException;

public class Main {
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        Connector connector = tomcat.getConnector();
        connector.setPort(PORT);
        tomcat.setBaseDir(createTempDir());
        tomcat.setPort(PORT);

        tomcat.addWebapp("", new File( "jakarta-ee/src/main/webapp/").getAbsolutePath());

        String contextPath = "api";
        String docBase = new File(".").getAbsolutePath();
//
        Context context = tomcat.addContext(contextPath, docBase);

        tomcat.addServlet(contextPath, "helloServlet", new HelloServlet());
        context.addServletMappingDecoded("/hello-servlet", "helloServlet");

        tomcat.addServlet(contextPath, "mainServlet", new MainServlet());
        context.addServletMappingDecoded("/main", "mainServlet");

        tomcat.start();
        tomcat.getService().addConnector(connector);

        tomcat.getServer().await();
    }

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
