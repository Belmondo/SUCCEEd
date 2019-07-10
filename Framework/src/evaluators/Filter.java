package evaluators;

public abstract class Filter {
	
	public abstract boolean filter(Assignment assignment) throws EvaluationException;
	
	//new
	public abstract boolean evaluate();
	public abstract void execute();

}
