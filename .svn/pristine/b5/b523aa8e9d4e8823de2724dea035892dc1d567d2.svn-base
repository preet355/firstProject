package in.hkcl.utils;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DateFormatterUtility {

	/** The Year format **/
	public static final String YEAR_FORMAT_1 = "yy"; // 02
	public static final String YEAR_FORMAT_2 = "yyyy"; // 2002
	/** The Month format **/
	public static final String MONTH_FORMAT_1 = "M"; // 1
	public static final String MONTH_FORMAT_2 = "MM"; // 01
	public static final String MONTH_FORMAT_3 = "MMM"; // Jan
	public static final String MONTH_FORMAT_4 = "MMMM"; // January
	/** The Day Format **/
	public static final String DAY_FORMAT_1 = "d"; // 9
	public static final String DAY_FORMAT_2 = "dd"; // 09
	/** The day in week **/
	public static final String DAY_IN_WEEK_FORMAT_1 = "Wed"; // 9
	public static final String DAY_IN_WEEK_FORMAT_2 = "EEEE"; // 09
	/** The time **/
	public static final String TIME_FORMAT_1 = "hh:mm a"; // 12:08 PM
	public static final String TIME_FORMAT_2 = "hh 'o''clock' a, zzzz"; // 12
																		// o'clock
																		// PM,
																		// Pacific
																		// Daylight
																		// Time
	/** Date patterns **/
	public static final String FORMAT_PATTERN_1 = "dd MMMMM yyyy";
	public static final String FORMAT_PATTERN_2 = "dd.MM.yy";
	public static final String FORMAT_PATTERN_3 = "dd.MM.yyyy";
	public static final String FORMAT_PATTERN_4 = "MM/dd/yy";
	public static final String FORMAT_PATTERN_5 = "MM/dd/yyyy";
	public static final String FORMAT_PATTERN_6 = "dd/MM/yy";
	public static final String FORMAT_PATTERN_7 = "dd-MMM-yyyy";
	public static final String FORMAT_PATTERN_8 = "yyyy.MMMMM.dd";
	public static final String FORMAT_PATTERN_9 = "yyyy.MM.dd hh:mm:ss";
	public static final String FORMAT_PATTERN_10 = "dd-MM-yyyy hh:mm:ss";
	public static final String FORMAT_PATTERN_11 = "yyyy.MM.dd G 'at' hh:mm:ss z"; // 2009.07.10
																					// AD
																					// at
																					// 15:08:56
																					// PDT
	public static final String FORMAT_PATTERN_12 = "EEE, MMM d, ''yy"; // Wed,
																		// Jul
																		// 4,
																		// '01
	public static final String FORMAT_PATTERN_13 = "yyyy.MMMM.dd GGG hh:mm aaa"; // 2001.July.04
																					// AD
																					// 12:08
																					// PM
	public static final String FORMAT_PATTERN_14 = "dd-MMM-yyyy 'at' hh:mm aaa"; // 10-Jan-2010
																					// at
																					// 07:15
	public static final String FORMAT_PATTERN_15 = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_PATTERN_16 = "dd/MM/yyyy";
	public static final String FORMAT_PATTERN_17 = "yyyy-MM-dd";
	public static final String FORMAT_PATTERN_18 = "yyyyMMdd";
	public static final String FORMAT_PATTERN_19 = "EEE MMM dd hh:mm:ss z yyyy";// Tue
																				// Sep
																				// 08
																				// 00:00:00
																				// IST
																				// 1987
	public static final String FORMAT_PATTERN_20 = "yyyy-MM-dd-HH.mm.ss";
	
	public static final String FORMAT_PATTERN_21 = "EEE ,dd MMM yyyy hh:mm:ss z ";
	public static final String FORMAT_PATTERN_22 = "ddMMyyyy";
	public static final String FORMAT_PATTERN_23 = "dd-MMM-yyyy hh:mm:ss";
	public static final String FORMAT_PATTERN_24 = "dd-MMM-yyyy-hh-mm-ss";
	public static final String FORMAT_PATTERN_25 = "dd-MMM-yy";
	public static final String FORMAT_PATTERN_26 = "dd-MM-yyyy";
	
	// Constructor must be protected or private to prevent creating new object
	private DateFormatterUtility() {
	}

	/**
	 * Method to convert date in string to date type for a given format
	 * 
	 * @param stringDate
	 * @param dateFormat
	 * @return Date
	 * @throws ParseException
	 * @throws IllegalArgumentException
	 */
	public static Date stringtoDateConversion(String stringDate,
			String dateFormat) throws Exception {
		if (stringDate == null || stringDate.equals("")) {
			throw new IllegalArgumentException("The string date passed is null");
		}
		if (dateFormat == null || dateFormat.equals("")) {
			throw new IllegalArgumentException("The date format passed is null");
		}

		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		return formatter.parse(stringDate);
	}

	/**
	 * Method to convert a date to String for a specified format
	 * 
	 * @param date
	 * @param dateFormat
	 * @return Date as String
	 * @throws IllegalArgumentException
	 */
	public static String datetoStringConversion(Date date, String dateFormat)
			throws IllegalArgumentException {
		if (date == null || date.equals("")) {
			throw new IllegalArgumentException("The date passed is null");
		}
		if (dateFormat == null || dateFormat.equals("")) {
			throw new IllegalArgumentException("The date format passed is null");
		}
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		return formatter.format(date);
	}

	/**
	 * Method to convert a date from one format to another. Here the date
	 * dateString is converted from sourceDateFormat to destDateFormat. the
	 * converted date is newDateString which is returned
	 * 
	 * @param dateString
	 * @param sourceDateFormat
	 * @param destDateFormat
	 * @return new format of date as String
	 */
	public static String convertDateToFormat(String dateString,
			String sourceDateFormat, String destDateFormat)
			throws ParseException {
		// create SimpleDateFormat object with source string date format
		SimpleDateFormat sdfSource = new SimpleDateFormat(sourceDateFormat);
		// create SimpleDateFormat object with desired date format
		SimpleDateFormat sdfDestination = new SimpleDateFormat(destDateFormat);
		// parse the date into another format
		return sdfDestination.format(sdfSource.parse(dateString));
	}

	/**
	 * Use compareTo method of java Date class to compare two date objects.
	 * compareTo returns value greater than 0 if first date is after another
	 * date, returns value less than 0 if first date is before another date and
	 * returns 0 if both dates are equal.
	 * 
	 * @param date1
	 * @param date2
	 * @return int : 0 if dates are equal, greater than 0 if date1 is after
	 *         date2, less than 0 if date1 is before date2
	 */
	public static int compareDate(Date date1, Date date2) {
		return date1.compareTo(date2);
	}

	/**
	 * Method is used to check if date passed in string format future date or not.
	 * 
	 * @param date1
	 * @param date2
	 * @return true if future date and false if not
	 */
	public static boolean isFutureDate(final Date date1, final Date date2) {
		boolean status = false;
		if(date1.compareTo(date2) > 0){
			status = true;
		}
		return status;
	}
	
	/**
	 * Method is used to check if date passed in string format past date or not.
	 * 
	 * @param date1
	 * @param date2
	 * @return true if past date and false if not
	 */
	public static boolean isPastDate(final Date date1, final Date date2) {
		boolean status = false;
		try {
			//final Date date = stringtoDateConversion(date1, FORMAT_PATTERN_7);
			if(date1.compareTo(date2) < 0){
				status = true;
			}
		} catch (Exception e) {}
		return status;
	}
	
	public static int getCurrentYear() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR);
	}

	public static int getCurrentMonth() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.MONTH);
	}
	public static int getCurrentDay() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.DATE);
	}
	
	
	/**
	 * Method is used to get the difference of days.
	 * 
	 * @param accCreatDate - Date
	 * @return diffDays - long
	 */
	public static long getDiffDays(Date accCreatDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(accCreatDate);
		long milliseconds = cal.getTimeInMillis();
		long diff = System.currentTimeMillis() - milliseconds;
		long diffDays = diff / (24 * 60 * 60 * 1000);
		return diffDays;
	}
	
	public static boolean compareCalendars(Calendar calendar, Calendar calendar2) {

		boolean retresults = false;
		if ((calendar.get(Calendar.DATE) == calendar2.get(Calendar.DATE))
				&& (calendar.get(Calendar.MONTH) == calendar2
						.get(Calendar.MONTH))
				&& (calendar.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR))) {
			retresults = true;
		}

		return retresults;

	}
	
	public static Date[] getDate(String month , String year) {

		Date[] cnNmonth = null;
		try {
			cnNmonth = new Date[2];
			String currentMonth = "01/"+month+"/"+year;
			Date cMonth = stringtoDateConversion(currentMonth , "dd/MM/yyyy");
			Date calculatedDate = addMonths(cMonth, 1);
			cnNmonth[0] = cMonth;
			cnNmonth[1] = calculatedDate;
		} catch (Exception e) {
		
		}
		return cnNmonth;
	}
	
	/**
     * Adds the required number of months to the date
     */
    public static java.util.Date addMonths(Date date, int months) {
        java.util.Date calculatedDate = null;
        if (date != null) {
            final GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, months);
            calculatedDate = new java.util.Date(calendar.getTime().getTime());
        }

        return calculatedDate;
    }
    
    /**
	 * @param input
	 * @param pattern
	 * @return
	 */
	public static boolean isDateValid(String input, String pattern) {
		boolean returnVal = false;

		SimpleDateFormat sdf = new SimpleDateFormat();
		Date date = null;
		try {
			sdf.applyPattern(pattern);
			date = sdf.parse(input);
			if (sdf.format(date).equalsIgnoreCase(input)) {

				returnVal = true;
			}
		} catch (Exception ex) {
			returnVal = false;
		} finally {
			date = null;
			sdf = null;
		}
		return returnVal;
	}

	/**
	 * This method compares if one date is lying between two dates or is equal to any of these these dates
	 * @param dateToBeChecked
	 * @param dateFrom
	 * @param dateTo
	 * @return
	 */
	public static boolean isDayBetweenOtherTwo(Date dateToBeChecked, Date dateFrom, Date dateTo){
		return dateToBeChecked.compareTo(dateFrom) >= 0 && dateToBeChecked.compareTo(dateTo) <= 0;
	}
	
	/**
	 * This method returns the month name from the month number
	 * @param int - month number
	 * @return
	 */
	public static String getMonthName(Integer monthNo){
		 return new DateFormatSymbols().getMonths()[monthNo-1];
	}

	/**
	 * This method returns the number of days between two dates excluding the From Date but including the To Date
	 * @param Date - fromDate
	 * @param Date - toDate
	 * @return 
	 */
	public static long getDifferenceDays(Date fromDate, Date toDate) {
	   if(isDateEqualToGivenDate(fromDate,toDate))
	   {
		  return 0; 
	   }
	   else if(getDaysBetweenDates(fromDate, toDate).size()==2)
	   {
		   return 1;
	   }
	   else
	   {
		long diff = toDate.getTime() - fromDate.getTime();
	    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	   }
	}	

	/**
	 * This method would add the number of days passed to the date passed
	 * -ve number of days will decrement the dates
	 * @param Date - fromDate
	 * @param Date - toDate
	 * @return 
	 */
	public static Date addDays(Date date, float days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, CommonUtils.roundUpToInt(days, 0)); //minus number would decrement the days
        return cal.getTime();
    }

	/**
	 * This method would return the minimum of the two dates passed to it
	 * @param Date - date1
	 * @param Date - date2
	 * @return 
	 */
	public static Date minOfDates(Date date1, Date date2){
		return date1 == null ? date2 : (date2 == null ? date1 : (date1.before(date2) ? date1 : date2));
	}
	public static boolean isDateEqualToGivenDate(Date dateToBeChecked, Date dateGiven) {
		Calendar ck= Calendar.getInstance();
		ck.setTime(dateToBeChecked);
		int yearToBeChecked=ck.get(Calendar.YEAR);
		int monthToBeChecked=ck.get(Calendar.MONTH);
		int dayToBeChecked=ck.get(Calendar.DAY_OF_MONTH);
		
		Calendar givenCalendar= Calendar.getInstance();
		givenCalendar.setTime(dateGiven);
		int Year=givenCalendar.get(Calendar.YEAR);
		int Month=givenCalendar.get(Calendar.MONTH);
		int Day=givenCalendar.get(Calendar.DAY_OF_MONTH);
		if(yearToBeChecked==Year)
		{
			if(monthToBeChecked==Month)
			{
				if(dayToBeChecked==Day)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
			
		}
		else
		{
			return false;
		}
	}
	/**
	 * This method would return the minimum of the two dates passed to it
	 * @param Date - date1
	 * @param Date - date2
	 * @return 
	 */
	public static Date maxOfDates(Date date1, Date date2){
		return date1 == null ? date2 : (date2 == null ? date1 : (date1.after(date2) ? date1 : date2));
	}
	
	/**
	 * This method would calculate the overlap between two date ranges
	 * @param Date - dateFrom1
	 * @param Date - dateTo1
	 * @param Date - dateFrom2
	 * @param Date - dateTo2
	 * @return 
	 */
	public static long overlapBetween(Date dateFrom1, Date dateTo1, Date dateFrom2, Date dateTo2){
		return Math.max(0, getDifferenceDays(maxOfDates(dateFrom1, dateFrom2), minOfDates(dateTo1, dateTo2))+1);
	}
	
	public static boolean isDateGreaterThanGivenDate(Date dateToBeChecked, Date dateGiven)
	{
		Calendar ck= Calendar.getInstance();
		ck.setTime(dateToBeChecked);
		int yearToBeChecked=ck.get(Calendar.YEAR);
		int monthToBeChecked=ck.get(Calendar.MONTH);
		int dayToBeChecked=ck.get(Calendar.DAY_OF_MONTH);
		
		Calendar givenCalendar= Calendar.getInstance();
		givenCalendar.setTime(dateGiven);
		int Year=givenCalendar.get(Calendar.YEAR);
		int Month=givenCalendar.get(Calendar.MONTH);
		int Day=givenCalendar.get(Calendar.DAY_OF_MONTH);
		if(yearToBeChecked>Year)
		{
			return true;
		}
		else if(yearToBeChecked==Year)
		{
			if(monthToBeChecked>Month)
			{
				return true;
			}
			else if(monthToBeChecked==Month)
			{
				if(dayToBeChecked>Day)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
			
		}
		else
		{
			return false;
		}
	}
	public static List<Date> getDaysBetweenDates(Date startdate, Date enddate)
	{
	    List<Date> dates = new LinkedList<Date>();
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(startdate);

	    while (calendar.getTime().before(enddate))
	    {
	        Date result = calendar.getTime();
	        dates.add(result);
	        calendar.add(Calendar.DATE, 1);
	    }
	    dates.add(enddate);
	    return dates;
	}
}
