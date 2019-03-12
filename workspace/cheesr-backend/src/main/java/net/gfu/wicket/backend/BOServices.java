package net.gfu.wicket.backend;

import java.util.*;

import javax.annotation.ManagedBean;

import net.gfu.wicket.backend.bo.Cart;
import net.gfu.wicket.backend.bo.Cheese;

@ManagedBean
public class BOServices {

	private static final HashMap<Integer, Cheese> cheeses = new HashMap<>();

	static {
		cheeses.put(1, new Cheese(1, "Gouda", "Gouda is a yellowish Dutch[...]", 1.65));

		cheeses.put(2, new Cheese(2, "Edam", "Edam (Dutch Edammer) is a D[...]",
				1.05));
		cheeses.put(3, new Cheese(3, "Maasdam", "Maasdam cheese is a Dutc[...]",
				2.35));
		cheeses.put(4, new Cheese(4, "Brie", "Brie is a soft cows' milk c[...]",
				3.15));
		cheeses.put(5, new Cheese(5, "Buxton Blue", "Buxton Blue cheese i[...]",
				0.99));
		cheeses.put(6, new Cheese(6, "Parmesan", "Parmesan is a grana, a [...]",
				1.99));
		cheeses.put(7, new Cheese(7, "Cheddar", "Cheddar cheese is a hard[...]",
				2.95));
		cheeses.put(8, new Cheese(8, "Roquefort", "Roquefort is a ewe's-m[...]",
				1.67));
		cheeses.put(9, new Cheese(9, "Boursin", "Boursin Cheese is a soft[...]",
				1.33));
		cheeses.put(10, new Cheese(10, "Camembert", "Camembert is a soft, c[...]",
				1.69));
		cheeses.put(11, new Cheese(11, "Emmental", "Emmental is a yellow, m[...]",
				2.39));
		cheeses.put(12, new Cheese(12, "Reblochon", "Reblochon is a French [...]",
				2.99));
	}

	public BOServices(){

	}

	
	/**
	 * Ermittet alle verfuegbaren Kaesesorten
	 * @return - Liste aller Sorten
	 */
	public List<Cheese> allCheeses(){
		return Collections.unmodifiableList(new ArrayList<>(cheeses.values()));
	}

	public void updateCheese(Cheese cheese, int baseLockingVersion) {
		Cheese c = load(cheese.getId());
		if(cheese.getLockingVersion() != baseLockingVersion) {
			throw new IllegalStateException(
					String.format("Trying to update old version. Base version is %d, current version is %d",
							baseLockingVersion,cheese.getLockingVersion()));
		}
		c.setName(cheese.getName());
		c.setDescription(cheese.getDescription());
		c.setPrice(cheese.getPrice());
		c.incrementLock();

	}

	public Cheese load(int id) {
		return cheeses.get(id);
	}


	/**
	 * Uebergibt eine Bestellung zur Abwicklung ins Backend-System
	 */
	public void proccessOrder(Cart cart){
		// Nichts passiert - das ist im Beispiel so. - Loggen:
		System.err.println(">>>> Start: Bearbeite Bestellung <<<<<");
		System.err.println(cart.getBillingAddress().toString());
		for(Cheese c : cart.getCheeses()){
			System.err.println(c.toString());
		}
		System.err.println(">>>> Ende: Bearbeite Bestellung <<<<<");
		
	}

	public static BOServices get(){
		return new BOServices();
	}
}