package in.hkcl.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public final class ApplicationContextProvider implements ApplicationContextAware {

	public void setApplicationContext(final ApplicationContext ctx)
			throws BeansException {
		ServiceLocator.getInstance().setContext(ctx);
	}

}
