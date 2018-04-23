import static java.lang.System.out; /// atalho para imprimir
import java.util.ArrayList;/// progama utiliza ArrayLists

class Mundo {
	public int mapa[][] = new int[30][60]; ///< Atributo para representar o mundo em forma de inteiros.
	public String MapaS[][] = new String[30][60]; ///< Atributo para representar o mundo em forma de String(melhor visualização).
  
	public void criaMundo(ArrayList<Moto> mot,ArrayList<Carro> car, ArrayList<Caminhao> cam){ ///<Método que cria o mapa com os veiculos nele.
		int i,j;
		
		for(i=0; i<30;i++){ 	/// gerando uma matriz somente com zeros
			for(j=0;j<60;j++){
				mapa[i][j] = 0; 
			}
		}
		
		for(i=0; i<30;i++){ 	/// colocando as bordas da matiz como 1
			for(j=0;j<60;j++){
				
				mapa[i][0] = 1; 
				mapa[i][59] = 1;
				mapa[0][j] = 1;
				mapa[29][j] = 1;
				
			}
		}
		
		for(i=0;i<3;i++){		/// gerando as fabricas que ficam proximo as bordas, representando-as como 2
			for(j=0;j<5;j++){
				
				mapa[i+4][j+6] = 2;
				mapa[i+21][j+6] = 2;
				mapa[i+21][j+43] = 2;
				mapa[i+4][j+43] = 2;
				
			}
		}
		
		for(i=0;i<3;i++){		/// gerando a fabrica central(2), representanda com 2
			for(j=0;j<6;j++){
				
				mapa[i+13][j+26] = 2;
				
			}
		}
		
		for(i=0; i<mot.size();i++){		/// colocando as motos no mapa como 3.
			mapa[mot.get(i).getX()][mot.get(i).getY()] = 3; 
		}
		
		for(i=0; i<car.size();i++){		/// colocando os carros no mapa como 4.
			mapa[car.get(i).getX()][car.get(i).getY()] = 4;
			
		}

		for(i=0; i<cam.size();i++){		/// colocando as motos no mapa como 3.
			mapa[cam.get(i).getX()][cam.get(i).getY()] = 5;
		}
		
		
	}
	
	public void checkFab(ArrayList<Moto> mot,ArrayList<Carro> car, ArrayList<Caminhao> cam){ ///< Método que verifica se o veiculo está sobre uma fabrica, se sim, gera o veiculo em cima dela.
		int i,j;
		for(i=0; i<mot.size();i++){ /// verifica se o atributo fabrica é true, se sim, cria uma moto com posição aleatória no mapa.
			mot.get(i).checkFab();
			if(mot.get(i).fabrica == true){
				mot.add(mot.size(),new Moto((int)(Math.random()*28)+1,(int)(Math.random()*58)+1));
				mot.get(i).setFab(false);
			}
		}
		
		for(i=0; i<car.size();i++){ /// verifica se o atributo fabrica é true, se sim, cria um carro com posição aleatória no mapa.
			car.get(i).checkFab();
			if(car.get(i).fabrica == true){
				car.add(car.size(),new Carro((int)(Math.random()*28)+1,(int)(Math.random()*58)+1));
				car.get(i).setFab(false);
			}
		}

		for(i=0; i<cam.size();i++){ /// verifica se o atributo fabrica é true, se sim, cria um caminhão com posição aleatória no mapa.
			cam.get(i).checkFab();
			if(cam.get(i).fabrica == true){
				cam.add(cam.size(),new Caminhao((int)(Math.random()*28)+1,(int)(Math.random()*58)+1));
				cam.get(i).setFab(false);
			}
		}
	}
	
	public void checkDel(ArrayList<Moto> mot,ArrayList<Carro> car, ArrayList<Caminhao> cam){///< Método que verifica as posições dos veiculos, se estiverem, remove o que tem menor velocidade do mapa, se tiverem velocidade igual, remove os dois.
		int i,j;
		
		for(i=0; i<car.size();i++){ /// verifica se existe alguma moto na mesma posição de um carro, se tiver, remove a moto do mapa.
			for(j=0;j<mot.size();j++){
				if(mot.get(j).getX() == car.get(i).getX() & mot.get(j).getY() == car.get(i).getY()){
					
					mot.remove(j);
					if(i>0){
						i--;
					}	
					if(j>0){
						j--;
					}
				}
			}
		}
		
		for(i=0; i<mot.size();i++){ /// verifica se existe alguma moto na mesma posição de uma outra moto, se tiver, remove as duas.
			for(j=i+1;j<mot.size()-1;j++){
				if(mot.get(i).getX() == mot.get(j).getX() & mot.get(i).getY() == mot.get(j).getY()){
					
					mot.remove(i);
					mot.remove(j);
					if(i>0){
						i--;
					}	
					if(j>0){
						j--;
					}
				}
			}
		}
		
		for(i=0; i<cam.size();i++){/// verifica se existe alguma moto na mesma posição de um Caminhão, se tiver, remove a moto do mapa.
			for(j=0;j<mot.size();j++){
				if(mot.get(j).getX() == cam.get(i).getX() & mot.get(j).getY() == cam.get(i).getY()){
					
					mot.remove(j);
					if(i>0){
						i--;
					}	
					if(j>0){
						j--;
					}
				}
			}
		}
		
		for(i=0; i<cam.size();i++){/// verifica se existe alguma carro na mesma posição de um Caminhão, se tiver, remove o carro.
			for(j=0;j<car.size();j++){
				if(car.get(j).getX() == cam.get(i).getX() & car.get(j).getY() == cam.get(i).getY()){
					
					car.remove(j);
					if(i>0){
						i--;
					}	
					if(j>0){
						j--;
					}
				}
			}
		}
		
		for(i=0; i<car.size();i++){/// verifica se existe alguma carro na mesma posição de um outro carro, se tiver, remove os dois.
			for(j=i+1;j<car.size()-1;j++){
				if(car.get(i).getX() == car.get(j).getX() & car.get(i).getY() == car.get(j).getY()){
					
					car.remove(i);
					car.remove(j);
					if(i>0){
						i--;
					}	
					if(j>0){
						j--;
					}
				}
			}
		}
		
		for(i=0; i<cam.size();i++){ /// verifica se existe alguma carro na mesma posição de um outro carro, se tiver, remove os dois.
			for(j=i+1;j<cam.size()-1;j++){
				if(cam.get(i).getX() == cam.get(j).getX() & cam.get(i).getY() == cam.get(j).getY()){
					
					cam.remove(i);
					cam.remove(j);
					if(i>0){
						i--;
					}
					if(j>0){
						j--;
					}
				}
			}
		}
	}
	
	public void conInt2Str(){///< Método que gera um mapa no formato string apartir do mapa no formato de inteiros.
		
		int i,j;
		
		for(i=0;i<30;i++){
			for(j=0;j<60;j++){
				if (mapa[i][j] == 1){ /// os 1 viram Obstáculos ("O").
					MapaS[i][j] = "O";
				}
				if (mapa[i][j] == 2){ /// os 2 viram Fabricas ("F").
					MapaS[i][j] = "F";
				}
				if (mapa[i][j] == 0){ /// os 0 representam espaços vazios (" ").
					MapaS[i][j] = " ";
				}
				if (mapa[i][j] == 3){ /// os 3 viram Motos ("M").
					MapaS[i][j] = "M";
				}
				if (mapa[i][j] == 4){ /// os 4 viram Carros ("C").
					MapaS[i][j] = "C";
				}
				if (mapa[i][j] == 5){ /// os 4 viram Caminhões ("T").
					MapaS[i][j] = "T";
				}
			}
		}
	}
	
	public void imprimeMundoS(ArrayList<Moto> mot,ArrayList<Carro> car, ArrayList<Caminhao> cam){ ///< Método que imprime o mapa no formato de string.
		
		int i,j;
		
		for (i=0;i<30;i++){ /// imprime mapa.
			for(j=0;j<60;j++){
				
				out.print(MapaS[i][j]);
				
			}
			out.print("\n");
		}
		out.print("Motos(M): "); /// imprime quantidade de Motos.
		out.println(mot.size());
		out.print("Carros(C): ");/// imprime quantidade de Carros.
		out.println(car.size());
		out.print("Caminhões(T): ");/// imprime quantidade de Caminhões.
		out.println(cam.size());
		
		checkFab(mot, car, cam); /// verifica se tem alguem em cima de uma fabrica.
		checkDel(mot, car, cam);/// verifica se tem alguem em colidiu.
		try{
    		Thread.sleep(750); /// pausa entre os prints
		} 
		catch(InterruptedException e){
		}
	}
}