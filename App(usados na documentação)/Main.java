import static java.lang.System.out; 
import java.util.ArrayList;
/// classe feita para executar o programa


class Main {
	public static void main(String[] args) {
		
		int i,x,y,k;
		Mundo cidade = new Mundo();
		
		ArrayList <Moto> mot = new ArrayList<>();
		ArrayList <Carro> car = new ArrayList<>();
		ArrayList <Caminhao> cam = new ArrayList<>();
		
		for(i=0;i<10;i++){
			mot.add(i,new Moto((int)(Math.random()*28)+1,(int)(Math.random()*58)+1));
			car.add(i,new Carro((int)(Math.random()*28)+1,(int)(Math.random()*58)+1));
			cam.add(i,new Caminhao((int)(Math.random()*28)+1,(int)(Math.random()*58)+1));
		
		cidade.criaMundo(mot, car, cam);
		cidade.conInt2Str();
		cidade.imprimeMundoS(mot, car, cam); 
		
		
		while(true){
			
			for(i=0; i<mot.size();i++){
				mot.get(i).move();
			}
	
			for(i=0; i<car.size();i++){
				car.get(i).move();
			}
	
			for(i=0; i<cam.size();i++){
				cam.get(i).move();
			}
			
			out.println();
			cidade.criaMundo(mot, car, cam);
			cidade.conInt2Str();
			out.println("\n\n\n\n\n\n\n\n\n");
			cidade.imprimeMundoS(mot, car, cam); 
		}
	}
}