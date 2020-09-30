package in.hkcl.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * This class maintains the properties for Application Logger used throughout
 * the application
 */
public class ApplicationLogger {
	private Logger logger;

	/**
	 * Constructor for the ApplicationLogger class.
	 * @param clazz the input class.
	 */
	@SuppressWarnings("rawtypes")
	public ApplicationLogger(final Class clazz){
		if(clazz == null){
			throw new IllegalArgumentException("class is null!!");
		}
		logger = LoggerFactory.getLogger(clazz);
	}

	/**
	 * Gets if trace is enabled.
	 * @return true if trace is enabled else false.
	 */
	public boolean isTraceEnabled() {
		return logger.isTraceEnabled();
	}

	/**
	 * Gets if debug is enabled.
	 * @return true if debug is enabled else false.
	 */
	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}
	/**
	 * Gets if Info is enabled.
	 * @return true if info is enabled else false.
	 */

	public boolean isInfoEnabled(){
		return logger.isInfoEnabled();
	}
	
	/**
	 * Gets if warn is enabled.
	 * @return true if warn is enabled else false.
	 */
	
	public boolean isWarnEnabled(){
		return logger.isWarnEnabled();
	}
	/**
	 * Gets if error is enabled.
	 * @return true if error is enabled else false.
	 */
	
	public boolean isErrorEnabled() {
		return logger.isErrorEnabled();
	}
	
	/**
	 * logs the debug message.
	 * @param methodName the method name.
	 * @param obj the details to be logged.
	 */
	public void logDebug(final String methodName, final Object obj) {
		if (isDebugEnabled()){
			logger.debug(logFormatMethod(methodName,obj));
		}
	}

	/**
	 * logs the debug message.
	 * @param methodName the method name.
	 * @param obj the details to be logged.
	 * @param t the instance of Throwable.
	 */	
	public void logDebug(final String methodName,final Object obj, final Throwable thrw) {
		if (isDebugEnabled()){
			logger.debug(logFormatMethod(methodName,obj),thrw);
		}
	}


	/**
	 * logs the info message.
	 * @param methodName the method name.
	 * @param obj the details to be logged.
	 */
	public void logInfo(final String methodName, final Object obj) {
		if (isInfoEnabled()){
			logger.info(logFormatMethod(methodName,obj));
		}
	}

	/**
	 * logs the info message.
	 * @param methodName the method name.
	 * @param obj the details to be logged.
	 * @param t the instance of Throwable.
	 */	
	public void logInfo(final String methodName,final  Object obj, final Throwable thrw) {
		if (isInfoEnabled()){
			logger.info(logFormatMethod(methodName,obj),thrw);
		}
	}

	/**
	 * logs the trace message.
	 * @param methodName the method name.
	 * @param obj the details to be logged.
	 * @param t the instance of Throwable.
	 */	
	public void logTrace(final String methodName,final Object obj,final Throwable thrw) {
		if (isTraceEnabled()){
			logger.trace(logFormatMethod(methodName,obj),thrw);
		}
	}
	/**
	 * logs the trace message.
	 * @param methodName the method name.
	 * @param obj the details to be logged.
	 */
	
	public void logTrace(final String methodName,final Object obj) {
		if (isTraceEnabled()){
			logger.trace(logFormatMethod(methodName,obj));
		}
	}

	/**
	 * logs the warn message.
	 * @param methodName the method name.
	 * @param obj the details to be logged.
	 * @param t the instance of Throwable.
	 */		
	public void logWarn(final String methodName,final Object obj, final Throwable thrw) {
		if (isWarnEnabled()){
			logger.warn(logFormatMethod(methodName,obj),thrw);
		}
	}
	/**
	 * logs the warn message.
	 * @param methodName the method name.
	 * @param obj the details to be logged.
	 */
	
	public void logWarn(final String methodName,final Object obj) {
		if (isWarnEnabled()){
			logger.warn(logFormatMethod(methodName,obj));
		}
	}


	/**
	 * logs the error message.
	 * @param methodName the method name.
	 * @param obj the details to be logged.
	 */	
	public void logError(final String methodName,final Object obj) {
		if (isErrorEnabled()){
			logger.error(logFormatMethod(methodName,obj));
		}
	}

	/**
	 * logs the error message.
	 * @param methodName the method name.
	 * @param obj the details to be logged.
	 * @param t the instance of Throwable.
	 */		
	public void logError(final String methodName,final Object obj, final Throwable thrw) {
		if (isErrorEnabled()){
			logger.error(logFormatMethod(methodName,obj),thrw);
		}
	}
	
	/**
	 * logs the exception message.
	 * @param methodName the method name.
	 * @param obj the details to be logged.
	 */	
	public void logException(final String methodName, final Throwable thrw){
		logger.error(logFormatMethodError(methodName,thrw));
	}

	/**
	 * logs the format method.
	 * @param str
	 * @param obj the details to be logged.
	 */
	private static String logFormatMethod(final String str,final  Object obj){
		StringBuffer sbf = new StringBuffer();
		sbf.append("[").append("Method: ").append(str).append("]");
		sbf.append("[").append(obj).append("]");
		return sbf.toString();
	}

	/**
	 * logs the format method.
	 * @param str
	 * @param obj the details to be logged.
	 */
	@SuppressWarnings("unused")
	private static String logFormatMethod(final String str,final String message, final  Object obj){
		StringBuffer sbf = new StringBuffer();
		sbf.append("[").append("Method: ").append(str).append("]");
		sbf.append("[").append(message).append("]");
		sbf.append("[").append(obj).append("]");
		return sbf.toString();
	}
	
	/**
	 * logs the format method error.
	 * @param str
	 * @param t the details to be logged.
	 */
	private static String logFormatMethodError(final String str,final Throwable thrw){
		StringBuffer sbf = new StringBuffer();
		StringWriter swri = null;
		PrintWriter pwri = null;
		try{
			swri = new StringWriter();
			pwri = new PrintWriter(swri);
			if (thrw != null){
				thrw.printStackTrace(pwri);
			}
			sbf.append("[").append("Method: ").append(str).append("]");
			sbf.append("[").append(swri.toString()).append("]");
		}
		finally{
			try{
				if (pwri != null){
					pwri.close();
				}				
				if (swri != null){
					swri.close();
				}
			}
			catch (Exception e){
				sbf.append("[").append("Method: ").append(e);
				sbf.append("[").append(swri.toString()).append("]");
			}
		}
		return sbf.toString();
	}

}
