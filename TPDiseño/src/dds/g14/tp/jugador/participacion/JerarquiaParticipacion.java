package dds.g14.tp.jugador.participacion;
public enum JerarquiaParticipacion{
	ESTANDAR(3), SOLIDARIO(2), CONDICIONAL(1);
	
	private int value;
	
	private JerarquiaParticipacion(int i){
		this.value = i;
	}
	
	public int getValue(){
		return value;
	}
}