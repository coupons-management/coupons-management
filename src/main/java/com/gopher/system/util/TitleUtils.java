package com.gopher.system.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

public class TitleUtils {
	static List<String> list=new ArrayList<String>();
	public static Map<String,List<String>> messageMap=new HashMap<String,List<String>>();
	public static Map<String,String> keyWordsMap=new HashMap<String,String>();
	static String mark="$";
	static final String PERCENT ="%";
	static String type=null;
	static String keywords=null;
	static {
		list.add("$");
		list.add("€");
		list.add("￡");
		list.add("Rs ");
		list.add("Rs.");
		list.add("FR ");
		//List<String> a1List=new ArrayList<String>();
		//a1List.add("Save $ Any Oder");
		//messageMap.put("A1", a1List);
		
		
		
	}
	
	public static void main(String[] args) {
		String title="$50 off Jewelry orders over $150";
		System.out.println(getMessage(title));
		
	}
	public static String getMessage(String title) {
		if(StringUtils.isEmpty(title))
		{
			return null;
		}
		String key=null;
		keywords=null;
		if(A4(title))
		{
			key ="A4";
		}else if(A3(title))
		{
			key ="A3";
		}else if(A2(title))
		{
			key ="A2";
		}else if(A1(title))
		{
			key ="A1";
		}
		if(	key==null)
		{
			return title;
		}
		
		if(B2(title))
		{
		   key="B2"+key;
		}
		else if(B1(title)) {
		   key="B1"+key;
		}
		
		
		if(K2(title)||K1(title)) {
			key="K"+key;	
		}
		
	
		List<String> messageList=messageMap.get(key);
		if(messageList==null||messageList.size()<1)
		{
			return title;
		}
		String newMessage=messageList.get(getRandom(messageList.size()));
		if(key.equals("A4"))
		{
			 newMessage=getA4Message(title,newMessage,mark);
		}else if(key.equals("A3"))
		{
		newMessage=getA3Message(title,newMessage,mark); 
		}else if(key.equals("A2"))
		{
			 newMessage=getA2Message(title,newMessage);
		}else if(key.equals("A1"))
		{
			 newMessage=getA1Message(title,newMessage,mark);
		}
		if(key.indexOf("K")!=-1)
		{
			newMessage=newMessage.replace("[keyword]", keywords);	
		}
		
		
		if(newMessage.indexOf("free shiping")!=-1)
		{
			newMessage=newMessage.replace("free shiping", "+ Free Shiping");	
		}else if(newMessage.indexOf("free delivery ")!=-1)
		{
			newMessage=newMessage.replace("free delivery", "+ Free Delivery");	
		}
		return newMessage;
		

	}
	static int getRandom(int len)
	{
	SecureRandom random;
	try {
		random = SecureRandom.getInstance("SHA1PRNG");
		return 	random.nextInt(len);
	} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
	}
	String replaceTitle(String title)
	{
		
		//1 KB3A4   
		// Up to % Off Order Over $ at [keyword]
		//包括
		//keyword 包括keyword
		//sign 或者 up to
		
		//A系列
		//save $ 必须包含 顺序 save $ 
		//$只能是有一个空格或者没有空格（$必须代数字）
		//$只能是有一个空格或者没有空格（$必须代数字）
		
		
		//A2 代%，逻辑跟A1一样
		//A3 $,$包含这个优先A1，A2
		//A4 $,%包含这个 A类最优先
		
		//B类 
		//B1 符合A类规则，包括sign
		//B2 符合A类规则，包括up to
		//K类
		// k1 keywords A
		// k2 keywords B  k2优先K1
		
		//最后包括free shiping   转完后+ Free Shiping
		//     free delivery    转完后+ Free Delivery
		
		return null;
		

		
	}
	//save $  必须包含 顺序 save $ 
	static boolean A1(String title) {
		//(Save-...-$) 或 ($-空格-(off或discount)) 
		//1、包括Save 代有货币号
		//2、包括货币，并且代有off
		//3、包括货币，并且代有discount
		
		int beginIndex = title.indexOf("save");
		int endIndex = title.indexOf(mark);
		if(endIndex==-1)
		{
			return false;
		}
		if (beginIndex != -1  && endIndex > beginIndex) {
			return true;
		}
		
		
		
		
		
		int offIndex=title.indexOf("off");//$只能是有一个空格或者没有空格（$必须代数字）
		
		if(offIndex!=-1&&endIndex<offIndex)
		{
			return true;
		}
		
		int discountIndex=title.indexOf("discount");//$只能是有一个空格或者没有空格（$必须代数字）
		if(discountIndex!=-1&&endIndex<discountIndex)
		{
			return true;
		}
		
		
		return false;
	}
	
	
	
	static boolean A2(String title) {
		//(Save-...-%)  或 (%-空格-(off或discount)) 
		//1、代有Save并且包括%
		//2、代有%并且代有 off
		//3、代有%并且代有 discount
	
		
		int beginIndex = title.indexOf("save");
		int endIndex = title.indexOf("%");
		if(endIndex==-1)
		{
			return false;
		}
		if (beginIndex != -1  && endIndex > beginIndex) {
			return true;
		}
		
		int offIndex=title.indexOf("off");//$只能是有一个空格或者没有空格（$必须代数字）
		
		if(offIndex!=-1&&endIndex<offIndex)
		{
			return true;
		}
		
		int discountIndex=title.indexOf("discount");//$只能是有一个空格或者没有空格（$必须代数字）
		if(discountIndex!=-1&&endIndex<discountIndex)
		{
			return true;
		}
		
		
		return false;
	}
	
	

	static boolean A3(String title) {
	   //代有2个相同的货币符号$,$
		int beginIndex = title.indexOf(mark);
		int endIndex = title.indexOf(mark);
		if(endIndex==-1&&beginIndex != -1)
		{
			return true;
		}
	
		return false;
	}
	
	static boolean A4(String title) {
		//代有2个符号$,%
		int beginIndex = title.indexOf(mark);
		int endIndex = title.indexOf("%");
		if(endIndex!=-1&&beginIndex != -1)
		{
			return true;
		}
	
		return false;
	}

	static boolean A(String title)
	{
		if(A4(title))
		{
			return true;
		}
		if(A3(title))
		{
			return true;
		}
		if(A2(title))
		{
			return true;
		}
		if(A1(title))
		{
			return true;
		}
		return false;
	}
	//B1 符合A类规则，包括sign
	//B2 符合A类规则，包括up to
	static boolean B1(String title) {
		//只做B１类判断，满足A类的基础上才有B类的
		
		if(title.indexOf("sign")!=-1)
		{
			return true;
		}
		return false;
		
	}
	static boolean B2(String title) {
		//只做B２类判断，满足A类的基础上才有B类的
		
		if(title.indexOf("up to")!=-1)
		{
			return true;
		}
		
		return false;
		
	}
	static boolean B(String title)
	{
		if(B2(title))
		{ 
			return true;
		}
		if(B1(title))
		{  
			return true;
		}
		return false;
	}
	
	static boolean K1(String title)
	{// 只做K1判断
		/*
		 * if(!B1(title)) { return false; }
		 */ 
		
		for (Map.Entry<String, String> entry : keyWordsMap.entrySet()) {
			if (title.indexOf(entry.getValue()) != -1) {
				System.out.println("我是K1系");
				keywords=entry.getValue();
				return true;
			}
		}
		return false;
	}

	static boolean K2(String title)
	{/*
		if(!B2(title))
		{
		return false;
		}*/
		
		for(Map.Entry<String, String> entry :keyWordsMap.entrySet())
		{
			if(title.indexOf(entry.getValue())!=-1)
			{
				System.out.println("我是K2系");
				keywords=entry.getValue();
				return true;
			}	
		}
		return false;
	}
	
	
	
	static boolean judgeB1(String title) {
	
		if(title.indexOf("sign")!=-1)
		{
			return true;
		}
		return false;
		
	}
	static boolean judgeB2(String title) {
		if(title.indexOf("up to")!=-1)
		{
			return true;
		}
		return false;
		
	}
	static boolean judgek2(String title)
	{
		
		for(Map.Entry<String, String> entry :keyWordsMap.entrySet())
		{
			if(title.indexOf(entry.getValue())!=-1)
			{
				System.out.println("我是K2系");
				return true;
			}	
		}
		return false;
	}
	static boolean judgeK1(String title )
	{
		for(Map.Entry<String, String> entry :keyWordsMap.entrySet())
		{
			if(title.indexOf(entry.getValue())!=-1)
			{
				System.out.println("我是K1系");
				return true;
			}	
		}
		
		return false;
	}
	
	/**
	 * 替换模板消息A3类
	 * @param title
	 * @param mode
	 * @param mark
	 * @return
	 */
	 static String getA3Message(String  title,String mode,String mark) {
		String[] titles=title.split(" ");
		String[] values=new String[2];
		for(int i=0;i<titles.length;i++)
		{ 
		if(titles[i].indexOf(mark)!=-1)
		{
			if(StringUtils.isEmpty(values[0]))
			{
				values[0]=titles[i];	
			}else {
				values[1]=titles[i];
				break;
			}
		}
		}
		int index=mode.indexOf(mark);
		if(index==-1)
		{
			return null;
		}
		 mode=mode.substring(0, index)+values[0]+mode.substring(index+1);
		int last=mode.lastIndexOf(mark);
		if(last==-1)
		{
			return null;
		}
		String t=mode.substring(0, last)+values[1]+mode.substring(last+1);
		//System.out.println(t);
		return t;
	}

	/**
	 * 替换模板消息A2类
	 * @param title
	 * @param mode
	 * @param mark
	 * @return
	 */
	 static String getA2Message(String  title,String mode) {
		String[] titles=title.split(" ");
		String[] values=new String[1];
		for(int i=0;i<titles.length;i++)
		{ 
		
		if(titles[i].indexOf("%")!=-1&&StringUtils.isEmpty(values[0]))
		{
		  values[0]=titles[i];
		  break;
		
		}
		}
		
		mode=mode.replace("%", values[0]);
		
		//System.out.println(mode);
		return mode;
	}

	/**
	 * 替换模板消息A1类
	 * @param title
	 * @param mode
	 * @param mark
	 * @return
	 */
	 static String getA1Message(String  title,String mode,String mark) {
		String[] titles=title.split(" ");
		String[] values=new String[1];
		for(int i=0;i<titles.length;i++)
		{ 
		
		if(titles[i].indexOf(mark)!=-1&&StringUtils.isEmpty(values[0]))
		{
		  values[0]=titles[i];
		  break;
		
		}
		}
		
		mode=mode.replace(mark, values[0]);
		
		//System.out.println(mode);
		return mode;
	}

	/**
	 * 替换模板消息A4类
	 * @param title
	 * @param mode
	 * @param mark
	 * @return
	 */
	 static String getA4Message(String  title,String mode,String mark) {
		String[] titles=title.split(" ");
		String[] values=new String[2];
		for(int i=0;i<titles.length;i++)
		{ 
		if(titles[i].indexOf(mark)!=-1&&StringUtils.isEmpty(values[0]))
		{
				values[0]=titles[i];	
			
		}
		
		if(titles[i].indexOf("%")!=-1&&StringUtils.isEmpty(values[1]))
		{
		  values[1]=titles[i];
		
		}
		}
		
		mode=mode.replace(mark, values[0]);
		mode=mode.replace("%", values[1]);
		
		//System.out.println(mode);
		return mode;
	}
	
	
	
}
