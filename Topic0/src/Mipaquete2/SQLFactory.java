package Mipaquete2;

public class SQLFactory extends AbstractFactory{

	@Override
	TipoSQL getType(String SQLType) {
		if(SQLType == null){
	         return null;
	      }		
	      
	      if(SQLType.equalsIgnoreCase("Tipo1")){
	         return new Tipo1();
	         
	      }else if(SQLType.equalsIgnoreCase("Tipo2")){
	         return new Tipo2();
	         
	      }else if(SQLType.equalsIgnoreCase("Tipo3")){
	         return new Tipo3();
	      }
	      
	      return null;
	}	
}
