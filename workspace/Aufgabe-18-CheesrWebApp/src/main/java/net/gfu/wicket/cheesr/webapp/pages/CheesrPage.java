package net.gfu.wicket.cheesr.webapp.pages;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.FormComponentUpdatingBehavior;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import net.gfu.wicket.backend.bo.Cart;
import net.gfu.wicket.cheesr.webapp.CheesrSession;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

public abstract class CheesrPage extends WebPage {
	private static final long serialVersionUID = 1L;

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(CssHeaderItem.forReference(new CssResourceReference(Index.class, "../assets/bootstrap.min.css")));
		response.render(CssHeaderItem.forReference(new CssResourceReference(Index.class, "../assets/bootstrap-theme.min.css")));
		response.render(CssHeaderItem.forReference(new CssResourceReference(Index.class, "../assets/style.css")));
		response.render(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(Index.class, "../assets/jquery-3.3.1.slim.min.js")));
		response.render(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(Index.class, "../assets/bootstrap.min.js")));
		response.render(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(Index.class, "../assets/popper.min.js")));
	}

	public CheesrPage() {
		LocaleDropDown localeDropDown = new LocaleDropDown("localeSelect", Arrays.asList(Locale.US, Locale.GERMANY));
		localeDropDown.add(new FormComponentUpdatingBehavior());

		add(localeDropDown);
	}

	public Cart getCart() {
		return ((CheesrSession) getSession()).getCart();
	}
	
	public Model<Cart> getCartModel() {
		return new Model<Cart>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Cart getObject() {
				return getCart();
			}
		};
	}
	
	private static class LocaleDropDown extends DropDownChoice<Locale> {
		private static final long serialVersionUID = 1L;

		private class LocaleRenderer extends ChoiceRenderer<Locale> {
	      @Override
	      public String getDisplayValue(Locale locale) {
	        return ((Locale) locale).getDisplayName(getLocale());
	      }
	    }

	    LocaleDropDown(String id, List<Locale> supportedLocales) {
	      super(id, supportedLocales);
	      setChoiceRenderer(new LocaleRenderer());
	      setDefaultModel(new IModel() {

	        public Object getObject() {
	          return getSession().getLocale();
	        }

	        public void setObject(Object object) {
	          getSession().setLocale((Locale) object);
	        }

	        public void detach() {
	        }
	      });
	    }
	  }
}
