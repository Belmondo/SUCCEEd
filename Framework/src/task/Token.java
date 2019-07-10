package task;

public class Token {

	private int estadoAtual;
	private Object token;
	
	public Object getToken() {
		
		return this.token;
		
	}
	public void setToken(Object token) {
		this.token = token;
	}
	
	public int getEstadoAtual() {
		
		return this.estadoAtual;
	}
	
	public String getEstadoAtualString() {
		String retorno;
		
		switch(estadoAtual) {
		case 0:
			retorno = "Parado";
			break;
		case 1:
			retorno = "Executando";
			break;
		case 2:
			retorno = "Pausado";
			break;
		default:
			retorno = "Sem execução";
		
		}
		
		return retorno;
	}
	
	public void setEstadoAtual(int estadoAtual) {
		this.estadoAtual = estadoAtual;
	}
	
	

}
