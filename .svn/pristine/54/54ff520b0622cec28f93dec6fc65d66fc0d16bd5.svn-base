package in.hkcl.utils;

import org.springframework.context.ApplicationContext;



/**
 * <p>
 * <strong>Title:</strong>ServiceLocator.java
 * </p>
 * <p>
 * <strong>Description:</strong> This class is used to locate the spring
 * service.
 * </p>
 * 
 */
@SuppressWarnings("rawtypes")
public final class ServiceLocator {

	private static ApplicationLogger logger = ApplicationLogFactory
			.getLogger(ServiceLocator.class);
	/**
	 * Application context
	 */
	private ApplicationContext context;

	/**
	 * Application scheduler context
	 */
	private ApplicationContext schedulerContext;

	/**
	 * constant
	 */
	@SuppressWarnings("unused")
	private final String APPLICATION_CONTEXT_FILE_NAME = "applicationContext.xml";

	/**
	 * Service locator
	 */
	private static ServiceLocator serviceLocator;

	static {
		serviceLocator = new ServiceLocator();
	}

	/**
	 * Default constructor
	 */
	private ServiceLocator() {
		// context = new
		// ClassPathXmlApplicationContext(APPLICATION_CONTEXT_FILE_NAME);
	}

	/**
	 * Returns the instance of the Service Locator.
	 * 
	 * @return The instance of the Service Locator.
	 */
	public static ServiceLocator getInstance() {
		return serviceLocator;
	}

	/**
	 * Returns the instance of the specified class.
	 * 
	 * @param clazz
	 * @return
	 */
	public Object getObject(final Class clazz) {
		if (clazz == null) {
			throw new IllegalArgumentException("Argument is null");
		}
		return this.context.getBean(getClassName(clazz));
	}

	/**
	 * Returns the instance of the specified bean Name.
	 * 
	 * @param beanName
	 * @return
	 */
	public Object getObject(final String beanName) {
		if (beanName == null) {
			throw new IllegalArgumentException("Argument is null");
		}
		return this.context.getBean(beanName);
	}

	/**
	 * This method is used to return instance of the beans defined in context
	 * passed
	 * 
	 * @param appContext
	 * @param beanId
	 * @return
	 */
	public Object getBeanFromSchedulerContext(String beanId) {
		if (schedulerContext != null)
			return schedulerContext.getBean(beanId);
		return null;
	}

	/**
	 * @param schedulerContext
	 *            the schedulerContext to set
	 */
	public void setSchedulerContext(ApplicationContext schedulerContext) {
		this.schedulerContext = schedulerContext;
	}

	/**
	 * @return the schedulerContext
	 */
	public ApplicationContext getSchedulerContext() {
		return schedulerContext;
	}

	/**
	 * @param clazz
	 *            Class
	 * @return String
	 */
	private String getClassName(final Class clazz) {
		final String className = clazz.getName();
		return className.substring(className.lastIndexOf('.') + 1);
	}

	/**
	 * @param context
	 *            the context to set
	 */
	public void setContext(final ApplicationContext context) {
		logger.logInfo("setContext", "Context initialized in ServiceLocator");
		this.context = context;
	}

}
