import java.util.Random;

/// Classe com os atributos gerais de um Veiculo, serve de pai para veiculos especificos(motos, carros, etc...).

class Veiculo{
	
	private int y;///< Atributo que representa o eixo y do veiculo no mapa.
	private int x;///< Atributo que representa o eixo x do veiculo no mapa.
	protected int velocidade;///< Atributo que representa a velocidade que o veiculo se movimenta no mapa.
	protected boolean fabrica;///< Atributo que representa se o veiculo está em cima de uma fábrica.
	private String cor; ///< Atributo que representa a cor do veiculo.
	
	public Veiculo(int x, int y){ ///< Método utilizado como construtor padrão.
		this.x = x;
		this.y = y;
		this.fabrica = false;
	}
	
	public void move(){///< Método que move os veiculos.
		
		Random z = new Random();
		int w = z.nextInt(4); 
		if(w==0){
			x-=velocidade;
			if(x < 1){
				x = 28;
			}
		}
		if(w==2){
			x+=velocidade;
			if(x > 28){
				x = 1;
			}
		}
		if(w==1){
			y+=velocidade;
			if(y > 58){
				y = 1;
			}
		}
		if(w==3){
			y-=velocidade;
			if(y < 1){
				y = 58;
			}
		}
	}
	
	public void checkFab(){ ///< Método que verifica se o veiculo está sobre uma fábrica, se estiver, muda o booleano fabrica pra true.
		int i,j;
		for(i=0;i<3;i++){
			for(j=0;j<5;j++){
				
				if(x == i+4 & y == j+6){ 
					this.fabrica = true; 
				}
				if(x == i+21 & y == j+6){
					this.fabrica = true; 
				}
				if(x == i+21 & y == j+43){
					this.fabrica = true; 
				}
				if(x == i+4 & y == j+43){
					this.fabrica = true; 
				}
			}
		}
		
		for(i=0;i<3;i++){
			for(j=0;j<6;j++){
				if(x == i+13 & y == j+26){
					this.fabrica = true; 
				}
			}
		}
	}
	
	public void setX(int x){ ///< Método set do atributo x
		this.x = x;
	}
	
	public void setVel(int vel){///< Método set do atributo velocidade
		velocidade = vel;
	}
	
	public void setY(int y){///< Método set do atributo y
		this.y = y;
	}
	
	public int getX(){///< Método get do atributo x
		return x;
	}
	
	public int getVel(){///< Método get do atributo velocidade
		return velocidade;
	}
	
	public int getY(){///< Método get do atributo y
		return y;
	}
	
	public boolean getFab(){///< Método get do atributo fabrica
		return fabrica;
	}
	
	public void setFab(boolean fab){///< Método get do atributo fabrica
		fabrica = fab;
	}
}
