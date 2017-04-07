package com.coderising.jvm.util;

public class ByteArryIterator implements MyInterator{

	byte[] codes;
	int position=0;
	
	public ByteArryIterator(byte[] codes) {
		this.codes = codes;
	}
	
	public boolean hasNext() {
		if(position>=codes.length)
			return false;
		return true;
	}

	public Object next() {
		byte code = codes[position];
		position++;
		return code;
	}
	public int getPos() {
		return position;
	}

}
