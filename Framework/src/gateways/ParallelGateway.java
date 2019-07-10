package gateways;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import primitives.IElement;
import task.Task2;




public class ParallelGateway implements IElement  {
	
	//Cria o pool com threads
	ExecutorService service;// = Executors.newFixedThreadPool(30);
	
	List<Task2> ListaTasksParaExecucao = new ArrayList<Task2>();
	
	
	//Para Multiplas entradas de Tasks
	public ParallelGateway(List<Task2> listaTasks) {
		
		
		for(Task2 task: listaTasks) {
			ListaTasksParaExecucao.add(task);
		}
		
		/*service = Executors.newFixedThreadPool(numeroTasks);
		
		for (Task task : listaTasks) {
		    service.submit(task);	
		
		}*/
		
	}
	
	
	
	//Para dois = Ta ok
	/*public ParallelGateway(Task taskUm, Task taskDois) {
		service = Executors.newFixedThreadPool(2);
							
		service.submit(taskUm);
		service.submit(taskDois);
		
		
		service.shutdown();
	}*/



	
	public void run() {
		// TODO Auto-generated method stub
		
		//dizendo ao ExecutorService quantas threads serão reservadas para executar
		//baseada no tamanho da lista de Tasks
		service = Executors.newFixedThreadPool(ListaTasksParaExecucao.size());
		
		//para cada task na lista
		for(Task2 task: ListaTasksParaExecucao) {
			//execucao simultânea
			service.submit(task);
		}
		//libera expaço
		service.shutdown();
		
		
	}



	@Override
	public void recebeToken(Object tokenRecebido) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Object retornaToken() {
		// TODO Auto-generated method stub
		return null;
	}

}
