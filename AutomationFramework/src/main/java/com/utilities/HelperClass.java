package com.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HelperClass {

	
	public static Boolean EnterElementValues(WebElement element, String value){
		try{
			if(element.getTagName().equals("input")||element.getTagName().equals("textarea"))
				element.sendKeys(value);
			else if(element.getTagName().equals("select")){
				Select select = new Select(element);
				select.selectByVisibleText(value);
			}else
				element.click();
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
