package com.coderising.jvm.loader;

import com.coderising.jvm.clz.AccessFlag;
import com.coderising.jvm.clz.ClassFile;
import com.coderising.jvm.clz.ClassIndex;
import com.coderising.jvm.constant.ConstantPool;
import com.coderising.jvm.util.ByteArryIterator;
import com.coderising.jvm.util.Util;

public class ClassFileParser {
	public ClassFile parse(byte[] codes) {
		ClassFile classFile = new ClassFile();
		//获取此版本号--首先忽略前四个字节
		ByteArryIterator byteArryIterator = new ByteArryIterator(codes);
		byte[] cfbb = new byte[4];
		byte[]minorVersionByte = new byte[2];
		byte[]majorVersionByte = new byte[2];
		int minorVersion= 0;
		int majorVersion = 0;
		for(int i =byteArryIterator.getPos();i<cfbb.length;i++) {
			byte next = (Byte) byteArryIterator.next();
			cfbb[i]=next;
		}
		
		for(int i = 0;i<2;i++) {
			byte next = (Byte) byteArryIterator.next();
			minorVersionByte[i]=next;
		}
		for(int i = 0;i<2;i++) {
			byte next = (Byte) byteArryIterator.next();
			majorVersionByte[i]=next;
		}
		minorVersion=Util.byteToInt(minorVersionByte);
		majorVersion=Util.byteToInt(majorVersionByte);
		
		
		classFile.setMajorVersion(majorVersion);
		classFile.setMinorVersion(minorVersion);
		
		
		
		

		return classFile;
	}

	
	
	private AccessFlag parseAccessFlag(ByteCodeIterator iter) {

		return null;
	}

	private ClassIndex parseClassInfex(ByteCodeIterator iter) {

		return null;

	}

	private ConstantPool parseConstantPool(ByteCodeIterator iter) {

		return null;
	}

	
}
