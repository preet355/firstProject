package in.hkcl.utils;

public class ApplicationLogFactory {

	/**
	 * Gets the application logger.
	 * 
	 * @param clazz
	 *            the invoking Class.
	 * @return the application logger.
	 */
	@SuppressWarnings("rawtypes")
	public static ApplicationLogger getLogger(Class clazz) {
		return new ApplicationLogger(clazz);
	}
}
