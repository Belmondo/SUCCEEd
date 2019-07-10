package gateways;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import primitives.IElement;
import task.Task2;

public abstract class AInclusiveGateway implements IElement {
	
	protected ExecutorService service;
	protected static List<Task2> listaTasksParaExecutar = new ArrayList<Task2>();
	protected static List<Task2> listaTasksParaAvaliar = new ArrayList<Task2>();
	
	
	public AInclusiveGateway(List<Task2> listaTasks) {
		
		for(Task2 task: listaTasks) {
			listaTasksParaAvaliar.add(task);
		}
		
	}
	
	
	public abstract void coberturaCondicao();
	
	public void executaTasksValidas(List<Task2> listaTasksParaExecutar) {
		service = Executors.newFixedThreadPool(listaTasksParaExecutar.size());
		for (Task2 task : listaTasksParaExecutar) {
		    service.submit(task);	
		}
		service.shutdown();
	}
	
	public void run() {
		coberturaCondicao();
		executaTasksValidas(listaTasksParaExecutar);
	}

}
