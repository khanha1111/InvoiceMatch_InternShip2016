package com.mrv.intern.invoicematch.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.sun.org.apache.regexp.internal.recompile;

import oracle.net.aso.s;

public class Helper {
	/**
	 * parse string to timestamp
	 * @param date
	 * @param format
	 * @param locale
	 * @return
	 */
	public static Timestamp parseStringToTimeStamp(String date, String format, Locale locale) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date parsedDate = null;
		try {
			parsedDate = dateFormat.parse(date);
		} catch (ParseException e) {
			System.out.println(e);
		}
		Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());

		return timestamp;
	}
	/**
	 * return "" for null string
	 * @param str
	 * @return
	 */
	public static String trim(String str) {
		return str != null ? str.trim() : "";
	}
	/**
	 * parse timestamp to string
	 * @param timestamp
	 * @return
	 */
	public static String parseTimeStampToString(Timestamp timestamp) {
		String string;
		if (timestamp == null) {
			string = "";

		} else {
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			string = dateFormat.format(timestamp);
		}
		return string;

	}

	public static String dateConvert(String str) {

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = null;
		String dateString = null;
		if (str.equals("")) {
			dateString = null;
		} else {
			try {
				date = format1.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			dateString = format2.format(date);
		}

		return dateString;
	}

}
