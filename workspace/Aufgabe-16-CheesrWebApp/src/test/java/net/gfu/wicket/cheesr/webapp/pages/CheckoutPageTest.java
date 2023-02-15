package net.gfu.wicket.cheesr.webapp.pages;

import net.gfu.wicket.cheesr.webapp.TestWicketApplication;
import net.gfu.wicket.cheesr.webapp.components.ShoppingCartPanel;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckoutPageTest {

	private WicketTester tester;

	@BeforeEach
	public void setUp() {
		tester = new WicketTester(new TestWicketApplication());
		tester.startPage(Checkout.class);
	}
	
	@Test
	public void testPage(){
		tester.assertRenderedPage(Checkout.class);
		tester.assertComponent("form", Form.class);
		tester.assertComponent("cart", ShoppingCartPanel.class);
	}
	
	@Test
	public void testFeedbackPanel(){
		tester.assertComponent("feedback", FeedbackPanel.class);
		tester.assertNoInfoMessage();
		tester.assertNoErrorMessage();
	}
}