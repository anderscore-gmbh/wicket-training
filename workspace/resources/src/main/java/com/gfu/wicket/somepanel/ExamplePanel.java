package com.gfu.wicket.somepanel;

import org.apache.wicket.Application;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.resource.PackageResourceReference;

import com.gfu.wicket.JSLib;
import com.gfu.wicket.WicketApplication;

public class ExamplePanel extends Panel {
	
	private static final long serialVersionUID = 1L;

	
	public ExamplePanel(String id) {
		super(id);

	}

	@Override
	public void renderHead(IHeaderResponse response) {
		PackageResourceReference jsFile = new PackageResourceReference(this.getClass(), "panel.js");
		JavaScriptHeaderItem item = JavaScriptHeaderItem.forReference(jsFile);
		JavaScriptHeaderItem fromBundle = JavaScriptHeaderItem.forReference(JSLib.application);
		response.render(item);
		response.render(fromBundle);
	
	}


}
