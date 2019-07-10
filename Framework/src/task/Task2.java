package task;

import java.util.Map;

import evaluators.Assignment;
import evaluators.Filter;
import primitives.IElement;
import primitives.ITask;

public abstract class Task2 extends Thread implements ITask, IElement{
	
	long elapsed;

    String chaveInteresse;
    
    String name;
    
    Assignment assignment;// = new Assignment();

    Filter filter;// = new Filter();

    public void getAssignAndFilter( Assignment assignment, Filter filter  ) {
    	this.assignment = assignment;
    	this.filter = filter;
    }

	@Override
	public abstract void recebeToken(Object tokenRecebido);

	@Override
	public abstract Object retornaToken();

	@Override
	public abstract void executar();

	@Override
	public abstract Object retorno();
	
	public void run(Map<String,String> HashChaveValor) {
		evaluate(HashChaveValor.get(chaveInteresse));
	}

	 public abstract void evaluate(Object o);
	 public long retornatime(){
	        return elapsed;
	    }
}
