package Mipaquete2;

public class App {

	public static void main(String[] args) {
		
		//get shape factory
	      AbstractFactory SQLFactory = FactoryProducer.getFactory("SQL");

	      //get an object of Shape Circle
	      TipoSQL tipo1 = SQLFactory.getType("Tipo1");

	      //call draw method of Shape Circle
	      tipo1.tipo();

	      //get an object of Shape Rectangle
	      TipoSQL tipo2 = SQLFactory.getType("Tipo2");

	      //call draw method of Shape Rectangle
	      tipo2.tipo();
	      
	      //get an object of Shape Square 
	      TipoSQL tipo3 = SQLFactory.getType("Tipo3");

	      //call draw method of Shape Square
	      tipo3.tipo();


	}

}
