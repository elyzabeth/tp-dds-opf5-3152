package dds.g14.tp.observers;

import dds.g14.tp.entities.Partido;

public abstract class Observer {
	
	public Partido partido;
	
	public Observer(Partido partido) {
		this.partido = partido;
	}
	
	public abstract void realizarObservacion();
	
}
