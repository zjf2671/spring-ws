package com.example.demo.client;

import com.example.demo.entity.User;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import com.example.demo.service.UserService;

import javax.xml.namespace.QName;

/**
 * @ClassName:CxfClient
 * @Description:webservice客户端：
 * 			       该类提供两种不同的方式来调用webservice服务
 * 				1：代理工厂方式
 * 				2：动态调用webservice
 * @author Harry
 */
public class CxfClient {
	
	
	public static void main(String[] args) {
		CxfClient.main2();
	}

	/**
	 * 1.代理类工厂的方式,需要拿到对方的接口地址
	 */
	public static void main1() {
		try {
			// 接口地址
			String address = "http://127.0.0.1:8082/web/soap/user?wsdl";
			// 代理工厂
			JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
			// 设置代理地址
			jaxWsProxyFactoryBean.setAddress(address);
			// 设置接口类型
			jaxWsProxyFactoryBean.setServiceClass(UserService.class);
			// 创建一个代理接口实现
			UserService us = (UserService) jaxWsProxyFactoryBean.create();
			// 数据准备
			String userId = "Harry";
			// 调用代理接口的方法调用并返回结果
			String result = us.getUserName(userId);
			System.out.println("返回结果:" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 2：动态调用
	 */
	public static void main2() {
		// 创建动态客户端
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		Client client = dcf.createClient("http://127.0.0.1:8082/web/soap/user?wsdl");
		// 需要密码的情况需要加上用户名和密码
		// client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
		Object[] objects = new Object[0];
		try {
			// invoke("方法名",参数1,参数2,参数3....);

			//如果有命名空间需要加上这个，第一个参数为命名空间名称，第二个参数为WebService方法名称
//			QName operationName = new QName("http://service.demo.example.com","getUserName");

//			objects = client.invoke("getUserName", "Harry");
			objects = client.invoke("getUser", "4114ce4e66f54d2a8f24c24920651441");
			System.out.println("返回数据:" + objects[0]);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}
}
