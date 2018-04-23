import static java.lang.System.out; /// atalho para imprimir

class Caminhao extends Veiculo{
	private int capacidade_carga;///< Atributo para representar a quantidade de carga que o Caminhao suporta.
	
	public Caminhao(int x, int y){///<Construtor padrão que utiliza o contrutor padrão de veiculo e dá o valor 1 ao atributo velocidade.
		super(x,y);
		this.velocidade = 1;
	}
}
