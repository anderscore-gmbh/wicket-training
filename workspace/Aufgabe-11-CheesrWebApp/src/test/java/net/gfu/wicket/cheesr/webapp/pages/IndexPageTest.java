package net.gfu.wicket.cheesr.webapp.pages;

import net.gfu.wicket.cheesr.webapp.TestWicketApplication;
import net.gfu.wicket.cheesr.webapp.components.ShoppingCartPanel;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

public class IndexPageTest {

	private WicketTester tester;

	@Before
//	@BeforeEach
	public void setUp() {
		tester = new WicketTester(new TestWicketApplication());
		tester.startPage(Index.class);
	}
	
	@Test
	public void testPage(){
		tester.assertRenderedPage(Index.class);
	}

	@Test
	public void testCheeseList() {
		tester.assertComponent("cheeses", ListView.class);
		tester.assertModelValue("cheeses:0:name", "Gouda");
		tester.assertLabel("cheeses:0:name", "Gouda");
	}
	
	@Test
	public void testCart(){
		tester.assertComponent("cart", ShoppingCartPanel.class);
		tester.assertInvisible("checkout");
		
		tester.clickLink("cheeses:0:add");
		tester.assertVisible("checkout");
	}
}