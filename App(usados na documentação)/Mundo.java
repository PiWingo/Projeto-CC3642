import static java.lang.System.out;
import java.util.ArrayList;

/// Classe que representa o mundo em que os veiculos se movem.

class Mundo {
	public int mapa[][] = new int[30][60]; ///< Atributo para representar o mundo em forma de inteiros.
	public String MapaS[][] = new String[30][60]; ///< Atributo para representar o mundo em forma de String(melhor visualização).
  
	public void criaMundo(ArrayList<Moto> mot,ArrayList<Carro> car, ArrayList<Caminhao> cam){ ///<Método que cria o mapa com os veiculos nele.
		int i,j;
		
		for(i=0; i<30;i++){
			for(j=0;j<60;j++){
				mapa[i][j] = 0; 
			}
		}
		
		for(i=0; i<30;i++){
			for(j=0;j<60;j++){
				
				mapa[i][0] = 1; 
				mapa[i][59] = 1;
				mapa[0][j] = 1;
				mapa[29][j] = 1;
				
			}
		}
		
		for(i=0;i<3;i++){
			for(j=0;j<5;j++){
				
				mapa[i+4][j+6] = 2;
				mapa[i+21][j+6] = 2;
				mapa[i+21][j+43] = 2;
				mapa[i+4][j+43] = 2;
				
			}
		}
		
		for(i=0;i<3;i++){
			for(j=0;j<6;j++){
				
				mapa[i+13][j+26] = 2;
				
			}
		}
		
		for(i=0; i<mot.size();i++){
			mapa[mot.get(i).getX()][mot.get(i).getY()] = 3; 
		}
		
		for(i=0; i<car.size();i++){
			mapa[car.get(i).getX()][car.get(i).getY()] = 4;
			
		}

		for(i=0; i<cam.size();i++){
			mapa[cam.get(i).getX()][cam.get(i).getY()] = 5;
		}
		
		
	}
	
	public void checkFab(ArrayList<Moto> mot,ArrayList<Carro> car, ArrayList<Caminhao> cam){ ///< Método que verifica se o veiculo está sobre uma fabrica, se sim, gera o veiculo em cima dela.
		int i,j;
		for(i=0; i<mot.size();i++){
			mot.get(i).checkFab();
			if(mot.get(i).fabrica == true){
				mot.add(mot.size(),new Moto((int)(Math.random()*28)+1,(int)(Math.random()*58)+1));
				mot.get(i).setFab(false);
			}
		}
		
		for(i=0; i<car.size();i++){
			car.get(i).checkFab();
			if(car.get(i).fabrica == true){
				car.add(car.size(),new Carro((int)(Math.random()*28)+1,(int)(Math.random()*58)+1));
				car.get(i).setFab(false);
			}
		}

		for(i=0; i<cam.size();i++){
			cam.get(i).checkFab();
			if(cam.get(i).fabrica == true){
				cam.add(cam.size(),new Caminhao((int)(Math.random()*28)+1,(int)(Math.random()*58)+1));
				cam.get(i).setFab(false);
			}
		}
	}
	
	public void checkDel(ArrayList<Moto> mot,ArrayList<Carro> car, ArrayList<Caminhao> cam){///< Método que verifica as posições dos veiculos, se estiverem, remove o que tem menor velocidade do mapa, se tiverem velocidade igual, remove os dois.
		int i,j;
		
		for(i=0; i<car.size();i++){
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
		
		for(i=0; i<mot.size();i++){
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
		
		for(i=0; i<cam.size();i++){
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
		
		for(i=0; i<cam.size();i++){
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
		
		for(i=0; i<car.size();i++){
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
		
		for(i=0; i<cam.size();i++){
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
				if (mapa[i][j] == 1){
					MapaS[i][j] = "O";
				}
				if (mapa[i][j] == 2){
					MapaS[i][j] = "F";
				}
				if (mapa[i][j] == 0){
					MapaS[i][j] = " ";
				}
				if (mapa[i][j] == 3){
					MapaS[i][j] = "M";
				}
				if (mapa[i][j] == 4){
					MapaS[i][j] = "C";
				}
				if (mapa[i][j] == 5){
					MapaS[i][j] = "T";
				}
			}
		}
	}
	
	public void imprimeMundoS(ArrayList<Moto> mot,ArrayList<Carro> car, ArrayList<Caminhao> cam){ ///< Método que imprime o mapa no formato de string.
		
		int i,j;
		
		for (i=0;i<30;i++){
			for(j=0;j<60;j++){
				
				out.print(MapaS[i][j]);
				
			}
			out.print("\n");
		}
		out.print("Motos(M): ");
		out.println(mot.size());
		out.print("Carros(C): ");
		out.println(car.size());
		out.print("Caminhões(T): ");
		out.println(cam.size());
		
		checkFab(mot, car, cam);
		checkDel(mot, car, cam);
		try{
    		Thread.sleep(750);
		} 
		catch(InterruptedException e){
		}
	}
}