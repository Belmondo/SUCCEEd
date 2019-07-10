package gateways;

import task.Task2;
import java.util.ArrayList;
import java.util.List;

import primitives.IElement;

public abstract class AExclusiveGateway implements IElement {
	
	protected static List<Task2> ListaTasksParaExecutar = new ArrayList<Task2>();
	
	public AExclusiveGateway(List<Task2> listaTasks) {
		
		for(Task2 task: listaTasks) {
			ListaTasksParaExecutar.add(task);
		}
		
		
	}
	
	public abstract void coberturaCondicao();
	
	public void run() {
		coberturaCondicao();
	}

}
