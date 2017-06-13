package com.fanshe;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
 

public class Test implements Serializable {

	/**
	 * 
	 */
	
	private String pString = null;
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	public static void main(String[] args) throws Exception {
	
		
		Class<?>class1 = Class.forName("com.fanshe.Test");
		
		Class<?>parentClass = class1.getSuperclass();
		
		System.out.println( "class1的父类为：" + parentClass.getName());
		
		Class<?>intes[] = class1.getInterfaces();
		
		System.out.println("class1实现的接口有：");
		for (int i = 0; i < intes.length; i++) {
			System.out.println((i+1) + ":" + intes[i].getName());
		}
		
		
		Class<?>class2 = Class.forName("com.fanshe.User");
		
		User user = (User)class2.newInstance();
		
		user.setAge(20);
		user.setName("zhanghangzhen");
		System.out.println(user);
 
	 

		
		
		 System.out.println("类的属性：");
	        // 取得本类的全部属性
	        Field[] field = class2.getDeclaredFields();
	        for (int i = 0; i < field.length; i++) {
	            // 获取权限修饰符
	            int mo = field[i].getModifiers();
	            String priv = Modifier.toString(mo);
	            // 获取属性类型
	            Class<?> type = field[i].getType();
	            
	            System.out.println(priv + " " + type.getName() + " " + field[i].getName() + ";");
	        }

	        System.out.println("类的公开属性：");
	        // 获取类的public属性
	        Field[] filed1 = class2.getFields();
	        for (int j = 0; j < filed1.length; j++) {
	            // 获取权限修饰符
	            int mo = filed1[j].getModifiers();
	            String priv = Modifier.toString(mo);
	            // 获取属性类型
	            Class<?> type = filed1[j].getType();
	            System.out.println(priv + " " + type.getName() + " " + filed1[j].getName() + ";");
	        }	
		
		
	        Object object = class1.newInstance();
	        
	        Field field2 = class1.getDeclaredField("pString");
	        
	        field2.setAccessible(true);
	        field2.set(object, "Java反射机制");
	        System.out.println(field2.get(object));
	        
	        Method method[] = class1.getMethods();
//	        获取方法的签名：
	        for (int i = 0; i < method.length; i++) {
				
	        	 // 获取方法返回类型
	        	Class<?>returnType = method[i].getReturnType();
	        	 // 获取方法参数列表
	        	Class<?>para[] = method[i].getParameterTypes();
	            // 获取方法修饰符
	            int temp = method[i].getModifiers();
	        	
	            System.out.print(Modifier.toString(temp) + " ");
	            System.out.print(returnType.getName() + "  ");
	            System.out.print(method[i].getName() + " ");
	            System.out.print("(");
	        	for (int j = 0; j < para.length; j++) {
	        		System.out.print(para[j].getName() + " " + "arg" + j);
	        		if (j < para.length - 1) {
	        			System.out.print(",");
	        		}
				}
	        	
	        	Class<?> exce[] = method[i].getExceptionTypes();
	            if (exce.length > 0) {
	                System.out.print(") throws ");
	                for (int k = 0; k < exce.length; ++k) {
	                    System.out.print(exce[k].getName() + " ");
	                    if (k < exce.length - 1) {
	                        System.out.print(",");
	                    }
	                }
	            } else {
	                System.out.print(")");
	            }
	            System.out.println();
			}
	        
	        
	        
	        
	        
		
		
	}
	
	
	
	
	
}

