package com.coderising.jvm.loader;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.coderising.jvm.clz.ClassFile;



public class ClassFileLoader {

	private List<String> clzPaths = new ArrayList<String>();
	/**
	 * 将目标文件读成字节数组
	 * @param className
	 * @return
	 */
	public byte[] readBinaryCode(String className) {
		ClassFileLoader loader = new ClassFileLoader();
		className = "/"+className.replaceAll("\\.", "/")+".class";
		System.out.println(className);
		byte[] byteArray = null;
		try {
			InputStream is = loader.getClass().getResourceAsStream(className);
			System.out.println(is);
			int len = 0;
			byte[] buff = new byte[1024];
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			while((len = is.read(buff))!=-1) {
				bos.write(buff,0, len);
			}
			
			
			byteArray = bos.toByteArray();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return byteArray;	
		
		 
	}
	
	
	public void addClassPath(String path) {
		clzPaths.add(path);
	}
	
	
	
	public String getClassPath(){
		StringBuilder sb = new StringBuilder();
		for (String string : clzPaths) {
			
			sb.append(string+";");
			
		}
		String result = sb.toString();
		System.out.println(result);
		result=result.substring(0,result.lastIndexOf(";"));
		System.out.println(result);
		
		return result;
	}

	public ClassFile loadClass(String className) {
		
		byte[] codes = this.readBinaryCode(className);
		ClassFileParser parser = new ClassFileParser();
		return parser.parse(codes);
		
	}

	

}
