package net.gfu.wicket.cheesr.webapp.pages;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

public class Checkout extends WebPage{
	private static final long serialVersionUID = 1L;

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(CssHeaderItem.forReference(new CssResourceReference(Index.class, "../assets/bootstrap.min.css")));
		response.render(CssHeaderItem.forReference(new CssResourceReference(Index.class, "../assets/bootstrap-theme.min.css")));
		response.render(CssHeaderItem.forReference(new CssResourceReference(Index.class, "../assets/style.css")));
		response.render(CssHeaderItem.forReference(new JavaScriptResourceReference(Index.class, "../assets/bootstrap.min.js")));
		response.render(CssHeaderItem.forReference(new JavaScriptResourceReference(Index.class, "../assets/jquery-3.3.1.slim.min.js")));
		response.render(CssHeaderItem.forReference(new JavaScriptResourceReference(Index.class, "../assets/popper.min.js")));
	}
}
