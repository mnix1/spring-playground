package com.example.tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.Server;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws LifecycleException, IOException {
        Tomcat tomcat = new Tomcat();
        tomcat.setHostname("localhost");
        tomcat.getHost().setAppBase(".");

//        File docBase = new File(System.getProperty("java.io.tmpdir"));
//        Context context = tomcat.addContext("", docBase.getAbsolutePath());
        File war = new File("mvc/build/libs/mvc-0.0.1-all.jar");
        StandardContext ctx = (StandardContext) tomcat.addWebapp("/mvc", war.getAbsolutePath());
//        File additionWebInfClasses = new File("target/classes");
//        WebResourceRoot resources = new StandardRoot(ctx);
//        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
//                additionWebInfClasses.getAbsolutePath(), "/"));
//        ctx.setResources(resources);
//        File war = new File("jakarta-ee/build/libs/jakarta-ee-1.0.war");
//        tomcat.addWebapp("/jakarta-ee", war.getAbsolutePath());
//        tomcat.addServlet(context, HelloServlet.class.getSimpleName(), new HelloServlet());
//        tomcat.addServlet(context, MainServlet.class.getSimpleName(), new MainServlet());
//        context.addServletMappingDecoded("/*", MainServlet.class.getSimpleName());
//        context.addServletMappingDecoded("/hello-servlet/*", HelloServlet.class.getSimpleName());
        tomcat.init();
        tomcat.start();
        System.out.println("STARTED");
        Server server = tomcat.getServer();
        System.out.println("SERVER " + server.getAddress() + " " + server.getPort());
        server.setPort(8080);
        server.await();
    }
}
