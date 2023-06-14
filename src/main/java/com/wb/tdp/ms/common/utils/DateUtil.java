package com.wb.tdp.ms.common.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class contains utility methods for date functionality
 * 
 * @author anangupt
 *
 */
public class DateUtil {
	
	private static final Logger LOGGER = LogManager.getLogger(DateUtil.class);
	private static final String EST_TIME_ZONE_ID = "America/New_York";

	private DateUtil() {

	}

	public static long getUTCTimeinMillis() {
		LOGGER.info("ENTER::DateUtil::getUTCTimeinMillis () ");
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		LOGGER.info("EXIT::DateUtil::getUTCTimeinMillis () ");
		return cal.getTimeInMillis();
	}

	/**
	 * This method converts the given string to the given date format
	 * 
	 * @param dateString
	 *            the string to convert into Date
	 * @param dateFormat
	 *            the date format
	 * @return Date in the given Date format
	 * 
	 */
	public static Date convertStringToDate(String dateString, String dateFormat) {
		LOGGER.info("ENTER::DateUtil::convertStringToDate () ");
		DateFormat df = new SimpleDateFormat(dateFormat);
		Date ds = null;
		try {
			ds = df.parse(dateString);
		} catch (ParseException e) {
			return ds;
		}
		LOGGER.info("EXIT::DateUtil::convertStringToDate () ");
		return ds;
	}


	/**
	 * returns the current EST date in a specific format.
	 * 
	 * @param format - input string date
	 * @return Date - 
	 */
	public static Date getFormattedCurrentDate(String format) {
		LOGGER.info("ENTER::DateUtil::getFormattedCurrentDate () ");
		String currentDate = getEstFormattedCurrentDate(format);
		LOGGER.info("EXIT::DateUtil::getFormattedCurrentDate () ");
		return convertStringToDate(currentDate, format);
	}


	/**
	 * takes a string in mm/dd/yy format and converts it to the Date in the provided
	 * format
	 * 
	 * @param dateString
	 *            string to be converted into Date
	 * @param dateFormat
	 *            date format
	 * @param startAndEndDateFormat
	 *            required date format
	 * @return the date in provided format
	 */
	public static Date convertStringToDate(String dateString, String dateFormat, String startAndEndDateFormat) {
		LOGGER.info("ENTER::DateUtil::convertStringToDate () ");
		DateFormat formatter = new SimpleDateFormat(startAndEndDateFormat);
		Date date = null;
		try {
			date = formatter.parse(dateString);
			formatter = new SimpleDateFormat(dateFormat);
			String converteddate = formatter.format(date);
			return formatter.parse(converteddate);
		} catch (ParseException e) {
			LOGGER.info("EXIT::DateUtil::convertStringToDate () ");
			return date;
		}
	}

	/**
	 * converts string from one format to the other format
	 * 
	 * @param inDate
	 *            string to be converted from one format to the other format
	 * @param inDateFormat
	 *            input date format
	 * @param outDateFormat
	 *            output date format
	 * 
	 *
	 * @return the string in provided output format
	 */
	public static String formatDate(String inDate, String inDateFormat, String outDateFormat) {
		LOGGER.info("ENTER::DateUtil::formatDate () ");
		SimpleDateFormat inSDF = new SimpleDateFormat(inDateFormat);
		SimpleDateFormat outSDF = new SimpleDateFormat(outDateFormat);
		String outDateString = null;
		if (inDate != null) {
			try {
				Date date = inSDF.parse(inDate);
				outDateString = outSDF.format(date);
			} catch (ParseException ex) {
				return outDateString;
			}
		}
		LOGGER.info("EXIT::DateUtil::formatDate () ");
		return outDateString;
	}

	/**
	 * This method converts the input string date to EST date
	 * 
	 * @param dateString - string to be converted from one format to the other format 
	 * @param sourceFormat - input date format 
	 * @param destFormat - output date format
	 * @return String -  the string in provided output format
	 */
	public static String convertToEST(String dateString, String sourceFormat, String destFormat) {
		LOGGER.info("ENTER::DateUtil::convertToEST () ");
		SimpleDateFormat sourceFormatter = new SimpleDateFormat(sourceFormat);
		SimpleDateFormat finalFormatter = new SimpleDateFormat(destFormat);

		Date parsedOktaDate = null;
		String convertedDateString = null;

		try {
			parsedOktaDate = sourceFormatter.parse(dateString);
			finalFormatter.setTimeZone(TimeZone.getTimeZone(EST_TIME_ZONE_ID));
			convertedDateString = finalFormatter.format(parsedOktaDate);
			LOGGER.info(convertedDateString);
			return convertedDateString;
		} catch (ParseException e) {
			LOGGER.info("EXIT::DateUtil::convertToEST () ");
			return convertedDateString;
		}
	}

	/**
	 * get current EST date in provided format
	 * 
	 * @param format
	 *            the required format
	 * @return current EST date in provided format
	 */
	public static String getEstFormattedCurrentDate(String format) {
		LOGGER.info("ENTER::DateUtil::getEstFormattedDate () ");
		DateFormat formatter = new SimpleDateFormat(format);
		// Set the formatter to use a EST timezone
		formatter.setTimeZone(TimeZone.getTimeZone(EST_TIME_ZONE_ID));
		LOGGER.info("EXIT::DateUtil::getEstFormattedDate () ");
		return formatter.format(new Date());
	}

	/**
	 * Get current OffsetDateTime in provided format in UTC format, clock
	 * @return current OffsetDateTime in provided format
	 */

	
	public static OffsetDateTime getUTCOffsetDateTime() {
		Clock clock=Clock.systemUTC();
		return OffsetDateTime.now(clock);
		
	}
	
	/**
	 * Get current ZonedDateTime in provided format in UTC format, clock
	 * @return current ZonedDateTime in provided format
	 */
	
	public static ZonedDateTime getUTCZonedDateTime() {
		Clock clock=Clock.systemUTC();
		return ZonedDateTime.now(clock);
	}	


}
