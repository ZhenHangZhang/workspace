package com.fanshe;

import java.lang.reflect.Method;

public class ReflectionTest {

	
	public static void main(String[] args) throws Exception {
		
		Class<?>class1 = null;
		Class<?>class2 = null;
		Class<?>class3 = null;
		
		
		class1 = Class.forName("com.fanshe.ReflectionTest");
		
		class2 = new ReflectionTest().getClass();
		
		class3 = ReflectionTest.class;
		
		
		System.out.println("类名称   " + class1.getName());
		System.out.println("类名称   " + class2.getName());
		System.out.println("类名称   " + class3.getName());
		
		
		ReflectionTest reflectionTest = new ReflectionTest();
		
		System.out.println(reflectionTest.getClass().getName());
		
		
Class<?> clazz = Class.forName("com.fanshe.ReflectionTest");
        
        // 通过反射获取方法并调用方法
        Method method = clazz.getMethod("reflect");
        method.invoke(clazz.newInstance());
        
        // 通过反射获取方法，并进行传参调用方法
        method = clazz.getMethod("reflect", int.class, String.class);
        method.invoke(clazz.newInstance(), 20, "张三");
    }
    
    public void reflect() {
        System.out.println("Java 反射机制 - 调用无参方法");
    }
    
    public void reflect(int age, String name) {
        System.out.println("Java 反射机制 - 调用有参数方法");
        System.out.println("age -> " + age + ". name -> " + name);
    }
	
	
	
}
