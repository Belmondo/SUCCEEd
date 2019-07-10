package workflow;

import java.util.ArrayList;
import java.util.List;

import evaluators.Filter;
import primitives.IElement;
import primitives.IWorkflow;
import task.Token;

public class Workflow implements IWorkflow {
	

	List<IElement> listaParaExecutar = new ArrayList<IElement>();
	
	List<Filter> listaFiltros = new ArrayList<Filter>();
	
	public void receive(List<IElement> lista) {
		for (IElement element : lista) {
			listaParaExecutar.add(element);
		}
		
	}
	
	//new
	public void executeSequentially() {
		Token token = new Token();
		token.setToken(true);
		for(IElement element: listaParaExecutar) {
			
			element.recebeToken(token.getToken());
			//System.out.println("Tempo ao ser chamado: " + System.currentTimeMillis() );
			element.run();
			
			token.setToken(element.retornaToken());
			//System.out.println("Tempo ao fim da execução: " + System.currentTimeMillis() );
			
			
		}
	}
	
	//new
	public void executeBasedOnFilters() {
		for(Filter filter:listaFiltros) {
			
			if(filter.evaluate()) {
				filter.execute();
			}
		}
	}
	
	

}
