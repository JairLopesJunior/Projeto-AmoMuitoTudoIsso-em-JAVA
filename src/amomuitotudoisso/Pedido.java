package amomuitotudoisso;

public class Pedido {

	private int numero;
	private Double lanche;
	private Double bebida;
	private String total;
	private double satisfacao;
	
	public boolean validarLanche(double num) {
		if(num < 1 || num > 2) return true;
		return false;
	}

	public boolean validarBebida(double num) {
		if(num < 1 || num > 2) return true;
		return false;
	}
	
	public double somarPedido(double lanche, double bebida) {
		return lanche += bebida;
	}

	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Double getLanche() {
		return lanche;
	}

	public void setLanche(Double lanche) {
		this.lanche = lanche;
	}

	public Double getBebida() {
		return bebida;
	}

	public void setBebida(Double bebida) {
		this.bebida = bebida;
	}

	public double getSatisfacao() {
		return satisfacao;
	}

	public void setSatisfacao(double satisfacao) {
		this.satisfacao = satisfacao;
	}
}
