/// Classe que representa um Carro;

class Carro extends Veiculo{
	private int num_passageiros;///< Atributo para representar o numero de passageiros que o carro suporta.
	
	public Carro(int x, int y){///< Construtor padrão que utiliza o contrutor padrão de veiculo e dá o valor 2 ao atributo velocidade.
		super(x,y);
		this.velocidade = 2;
	}
}
