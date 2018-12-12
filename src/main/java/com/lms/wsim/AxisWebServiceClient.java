package com.lms.wsim;
import java.rmi.RemoteException;
import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.encoding.XMLType;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

/**
 * JAVA Axis框架 动态调用C# WebService客户端
 * @author lms
 * @version 2017年9月15日
 */
public class AxisWebServiceClient {
    public void test() {
        String url = "http://192.168.200.30:58080/Service1.asmx";
        String namespace = "http://tempuri.org/";
        String methodName = "GetAllMecName";
        String soapActionURI = "http://tempuri.org/GetAllMecName";
        Service service = new Service();
        Call call;
        try {
            call = (Call) service.createCall();
            call.setTargetEndpointAddress(url);
            call.setUseSOAPAction(true);
            call.setSOAPActionURI(soapActionURI); // 设置远程调用的方法
            call.setOperationName(new QName(namespace, methodName)); // 设置远程调用的参数
            call.addParameter(new QName(namespace, "request"), XMLType.XSD_STRING, ParameterMode.IN); // 设置返回类型
            call.setReturnType(XMLType.XSD_STRING); // 获取提交的报文
            Object obj = call.invoke(new Object[] { "你好！我是客户端" });
            System.out.println(obj);
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AxisWebServiceClient().test();
    }
}
