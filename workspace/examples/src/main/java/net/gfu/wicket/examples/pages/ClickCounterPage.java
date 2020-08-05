package net.gfu.wicket.examples.pages;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import java.util.Optional;

public class ClickCounterPage extends WebPage {
	private static final long serialVersionUID = 1L;

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(CssHeaderItem.forReference(new CssResourceReference(ClickCounterPage.class, "../assets/bootstrap.min.css")));
		response.render(CssHeaderItem.forReference(new CssResourceReference(ClickCounterPage.class, "../assets/bootstrap-theme.min.css")));
		response.render(CssHeaderItem.forReference(new CssResourceReference(ClickCounterPage.class, "../assets/style.css")));
		response.render(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(ClickCounterPage.class, "../assets/jquery-3.3.1.slim.min.js")));
		response.render(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(ClickCounterPage.class, "../assets/bootstrap.min.js")));
		response.render(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(ClickCounterPage.class, "../assets/popper.min.js")));
	}

	private int linkClicks, ajaxLinkClicks;

	private Label linkLabel;
	private Label ajaxLinkLabel;
	private Link<Void> link;
	private AjaxFallbackLink<Void> ajaxLink;

	public ClickCounterPage(){
		linkClicks = 0;
		ajaxLinkClicks = 0;

		Model<Integer> linkLabelModel = Model.of(linkClicks);
		Model<Integer> ajaxLinkLabelModel = Model.of(ajaxLinkClicks);

		linkLabel = new Label("link-label", linkLabelModel);

		ajaxLinkLabel = new Label("ajax-link-label", ajaxLinkLabelModel);
		ajaxLinkLabel.setOutputMarkupId(true);

		link = new Link<Void>("link-link"){
			@Override
			public void onClick() {
				linkClicks++;
				linkLabelModel.setObject(linkClicks);
			}
		};

		ajaxLink = new AjaxFallbackLink<Void>("ajax-link-link"){
			@Override
			public void onClick(Optional<AjaxRequestTarget> optional) {
				if (optional.isPresent()){
					ajaxLinkClicks++;
					ajaxLinkLabelModel.setObject(ajaxLinkClicks);

					optional.get().add(ajaxLinkLabel);
				}
			}
		};

		add(linkLabel, ajaxLinkLabel);
		add(link, ajaxLink);
	}
}
