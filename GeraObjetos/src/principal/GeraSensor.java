package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import sensor.Sensor;

public class GeraSensor {
	
	int numeroSensores;
	
	List<Sensor> listaSensores = new ArrayList<Sensor>();
	
	List<String> listaChaves = new ArrayList<String>();
	
	Random random = new Random();
	
	public GeraSensor(int numero) {
		
		this.numeroSensores = numero;
		
		constroeSensor();
		
	}
	
	public void constroeSensor() {
		listaChaves.add("context.device.proximity");
		listaChaves.add("context.device.soundlevel");
		listaChaves.add("context.device.accelerometer");
		listaChaves.add("context.ambient.luminosity");
		listaChaves.add("context.device.location");
		
		//listarecemadd
		
		listaChaves.add("context.device.wifi");
		listaChaves.add("context.ambient.weather");
		listaChaves.add("context.random");
		listaChaves.add("context.device.networklocation");
		listaChaves.add("context.ambient.magnetic");
		listaChaves.add("context.ambient.gravity");
		listaChaves.add("context.device.acceleration");
		listaChaves.add("context.device.gpslocation");
		
		geraSensores();
	}
	public void geraSensores() {
		
		// tenho que gerar o npumero de aleatórios que o usuário setou
		//baseado no que eu tenho de chaves
		
		for(int i=0; i < numeroSensores; i++) {
			
			//int randomNum = random.nextInt((listaChaves.size() - 0) + 1) + 0;
			
			//listaSensores.add(new Sensor().chave = listaChaves.get(randomNum));
			Sensor sensorAleatorio = new Sensor();
			sensorAleatorio.chave = listaChaves.get(numeroAleatorio(0, listaChaves.size()));
			listaSensores.add(sensorAleatorio);
			
		}
		
		
		
	}
	
	public List<Sensor> returnSensoresGerados(){
		return listaSensores;
	}
	
	//usado para gerar o número aleatório e para facilitar a visualização da aleatóriedade dos dados
	public int numeroAleatorio(int min, int max){
	    int randomNum = min + (int)(Math.random() * (max - min));
	    System.out.println(randomNum);
	    return randomNum;
	}

}
