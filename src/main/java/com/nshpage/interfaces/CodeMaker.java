package com.nshpage.interfaces;

//코드를 만든다.
//코드를 암호화한다.
//암호를 해독한다.
public interface CodeMaker {
	public String makeCode();
	public String encode(String code);
	public String decode(String secretCode);
		
	
}
