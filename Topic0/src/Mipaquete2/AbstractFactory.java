package Mipaquete2;

public abstract class AbstractFactory {
	abstract TipoSQL getType(String SQLtype);
}
