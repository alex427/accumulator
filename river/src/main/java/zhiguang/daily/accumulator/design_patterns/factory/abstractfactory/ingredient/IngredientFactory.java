package zhiguang.daily.accumulator.design_patterns.factory.abstractfactory.ingredient;

public interface IngredientFactory {
	
	//用来生产原料	
	String createPepper();
	String createBarbe();
	String createGarlic();
	String createMint();
}
