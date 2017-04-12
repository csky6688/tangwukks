package com.esunward.androidUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReflectionUtils {
	/**
	 * 获取属性并且过滤掉静态变量
	 * @param clazz	目标类
	 * @return
	 */
	public static List<Field> getFields(Class<?> clazz){
		return getFields(clazz,null,true);
	}
	/**
	 * 获取包含注解的属性并且过滤掉静态变量
	 * @param clazz	目标类
	 * @return
	 */
	public static List<Field> getFields(Class<?> clazz,Class<? extends Annotation> annotation){
		return getFields(clazz,annotation,true);
	}
	public static List<Field> getFields(Class<?> clazz,Class<? extends Annotation> annotation,boolean containParent){
		List<Field> fields = new ArrayList<Field>();
		Field[] fieldArray = clazz.getDeclaredFields();
		for (Field field : fieldArray) {
			if(Modifier.isStatic(field.getModifiers())){	//过滤掉静态变量
				continue;
			}
			if(annotation==null||field.getAnnotation(annotation)!=null){
				fields.add(field);
			}
			
		}
		if(containParent){
			Class<?> clazz1 = clazz.getSuperclass();
			if(!clazz1.equals(Object.class)){	//递归向上获取
				fields.addAll(getFields(clazz1,annotation,true));
			}
		}
		return fields;
	}
	
	/**
	 * 将一个实体类通过反射转化成一个map集合,其非static属性值以键值对的形式存放
	 */
	public static <T>Map<String,Object> entity2HashMap(T t){
		Map<String,Object>newmap = new HashMap<String,Object>();
		try {
			List<Field>fieldList = ReflectionUtils.getFields(t.getClass());
			for(Field field:fieldList){
				field.setAccessible(true);
				String name = field.getName();
				Object obj = field.get(t);
				newmap.put(name, obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return newmap;
	}
}
