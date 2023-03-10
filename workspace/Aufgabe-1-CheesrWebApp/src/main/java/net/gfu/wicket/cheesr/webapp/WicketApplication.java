package net.gfu.wicket.cheesr.webapp;

import net.gfu.wicket.cheesr.webapp.pages.ClickCounterPage;
import net.gfu.wicket.cheesr.webapp.pages.EchoFormPage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import net.gfu.wicket.cheesr.webapp.pages.Index;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see net.gfu.wicket.cheesr.webapp.Start#main(String[])
 */
public class WicketApplication extends WebApplication {

	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return Index.class;
	}

	@Override
	public void init() {
		super.init();
		// getCspSettings().blocking().disabled();
		// add your configuration here
	}
}
