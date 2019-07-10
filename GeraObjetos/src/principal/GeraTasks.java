package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import sensor.Sensor;


public class GeraTasks {
	
	int numeroTasks;
	Object task;
	
	List<Object> listaTasks = new ArrayList<Object>();
	
	//List<String> listaChaves = new ArrayList<String>();
	
	Random random = new Random();
	
	public GeraTasks(int numero, Object task) {
		
		this.numeroTasks = numero;
		this.task = task;
		
		constroeTasks();
		
	}
	
	public void constroeTasks() {
		geraTasks();
	}
	public void geraTasks() {
		
		
		
		for(int i=0; i < numeroTasks; i++) {
			
			listaTasks.add(task);
			
		}
		
		
		
	}
	
	public List<Object> returnTasksGerados(){
		return listaTasks;
	}
	
	/*public int numeroAleatorio(int min, int max){
	    int randomNum = min + (int)(Math.random() * (max - min));
	    //System.out.println(randomNum);
	    return randomNum;
	}*/

}
