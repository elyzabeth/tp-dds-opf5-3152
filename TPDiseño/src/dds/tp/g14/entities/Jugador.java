package dds.tp.g14.entities;

public class Jugador {
	
	public Confiabilidad confiabilidad;
	
	public Jugador(Confiabilidad conf){
		this.confiabilidad = conf;
	}
	
	public boolean retirarseDelPartido(){
		return confiabilidad.isConfiable();
	}
	
	public void changeConfiabilidad(Confiabilidad conf){
		this.confiabilidad = conf;
	}
}
