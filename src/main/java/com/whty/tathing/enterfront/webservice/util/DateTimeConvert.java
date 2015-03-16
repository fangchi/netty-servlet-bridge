package com.whty.tathing.enterfront.webservice.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

public class DateTimeConvert implements Converter {

	@Override
	public Object convert(Class type, Object value) {
		if (value == null) {
			throw new RuntimeException("value is null");
		}
		if (value.getClass() == Date.class) {
			return value;
		}
		if (value.getClass() != String.class) {
			throw new RuntimeException("type not match");
		}
		String valueStr = (String) value;
		
		try {
			return new SimpleDateFormat(Constant.DATE_TIME_FORMAT).parse(valueStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}