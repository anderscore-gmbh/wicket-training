package com.gfu.wicket.cheesr.webapp;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.settings.ExceptionSettings;

import com.gfu.wicket.cheesr.webapp.pages.Details;
import com.gfu.wicket.cheesr.webapp.pages.ErrorPage;
import com.gfu.wicket.cheesr.webapp.pages.Index;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see com.gfu.wicket.cheesr.webapp.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return Index.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init(){
		super.init();
		getExceptionSettings().setUnexpectedExceptionDisplay(ExceptionSettings.SHOW_INTERNAL_ERROR_PAGE);
		getApplicationSettings().setInternalErrorPage(ErrorPage.class);
		
		mountPage("/cheese/${name}", Details.class);
	}

	@Override
	public Session newSession(Request request, Response response) {
		return new CheesrSession(request);
	}
	
}