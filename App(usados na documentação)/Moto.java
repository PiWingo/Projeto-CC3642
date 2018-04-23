/// Classe que representa uma Moto;

class Moto extends Veiculo{
	private String tipo;///< Atributo para representar o tipo de moto.
	
	public Moto(int x, int y){///< Construtor padrão que utiliza o contrutor padrão de veiculo e dá o valor 3 ao atributo velocidade.
		super(x,y);
		this.velocidade = 3;
	}
}
