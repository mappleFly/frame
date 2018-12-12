package com.lms.wsim;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class Test {


    public static void main(String[] args) throws MalformedURLException {
        //测试远程调用QName
        URL url = new URL("http://localhost:8088/service/ServiceHello?wsdl");
        QName serviceName = new QName("http://webService.design.lms.com/","JwsServiceHelloService");
        Service ws = Service.create(url,serviceName);
        JwsServiceHello hello = ws.getPort(JwsServiceHello.class);
        String value = hello.getValue("333");
        System.out.println(value);
    }
}
