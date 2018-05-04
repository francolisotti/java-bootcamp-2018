package Mipaquete2;

public class FactoryProducer {

	public static AbstractFactory getFactory(String choice) {
		if(choice.equalsIgnoreCase("SQL")){
	         return new SQLFactory();
	      }
		return null;
	}
}
