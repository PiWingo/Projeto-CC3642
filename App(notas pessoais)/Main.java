import static java.lang.System.out; /// atalho para imprimir
import java.util.ArrayList;/// progama utiliza scanner


class Main {
	public static void main(String[] args) {
		
		int i,x,y,k;
		Mundo cidade = new Mundo();/// Instanciando o objeto Mundo.
		
		ArrayList <Moto> mot = new ArrayList<>();/// criando o ArrayList de motos.
		ArrayList <Carro> car = new ArrayList<>();/// criando o ArrayList de carros.
		ArrayList <Caminhao> cam = new ArrayList<>();/// criando o ArrayList de caminhões.
		
		for(i=0;i<10;i++){
			mot.add(i,new Moto((int)(Math.random()*28)+1,(int)(Math.random()*58)+1));/// criando 10 motos com posições aleatórias.
			car.add(i,new Carro((int)(Math.random()*28)+1,(int)(Math.random()*58)+1));/// criando 10 carros com posições aleatórias.
			cam.add(i,new Caminhao((int)(Math.random()*28)+1,(int)(Math.random()*58)+1));/// criando 10 caminhões com posições aleatórias.
		}
		
		cidade.criaMundo(mot, car, cam);/// passando as posições dos veiculos criados para o mapa.
		cidade.conInt2Str();/// gerando o mapa em formato de string.
		cidade.imprimeMundoS(mot, car, cam); /// imprimindo o mapa inicial em formato de string.
		
		
		while(true){/// while utilizado para o mundo continuar se movendo
			
			for(i=0; i<mot.size();i++){/// movendo as motos
				mot.get(i).move();
			}
	
			for(i=0; i<car.size();i++){/// movendo os carros
				car.get(i).move();
			}
	
			for(i=0; i<cam.size();i++){/// movendo os caminhões
				cam.get(i).move();
			}
			
			out.println();
			cidade.criaMundo(mot, car, cam);/// passando as posições dos veiculos movidos para o mapa.
			cidade.conInt2Str();/// gerando o mapa em formato de string.
			out.println("\n\n\n\n\n\n\n\n\n");
			cidade.imprimeMundoS(mot, car, cam); /// imprimindo o mapa com os veiculos movimentados em formato de string.
		}
	}
}