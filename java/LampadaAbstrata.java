
public abstract class LampadaAbstrata implements Iluminavel {
	private boolean acesa;
	int potencia;
	protected boolean funcionando;
	private static int qtdLampadasAbstratas = 0;

	// API
	public boolean getAcesa() {
		return this.acesa;
	}

	public void acender () {
		if (this.funcionando)
			this.acesa = true;
	}

	public void apagar () {
		this.acesa = false;
	}

	public void queimar () {
		this.funcionando = false;
		this.apagar();
	}

	public void consertar () {
		this.funcionando = true;
	}

	public int getPotenciaInstantanea () {
		return (this.getAcesa()) ? this.potencia : 0;
	}

	public static int getQtdLampadasAbstratas() {
		return qtdLampadasAbstratas;
	}

	//public abstract double getPreco();
	
	// Construtor (auxilia na construção de objetos)
	public LampadaAbstrata (boolean estado, int potencia, boolean funcionando) {
		this.acesa = estado;
		this.potencia = potencia;
		this.funcionando = funcionando;
		this.qtdLampadasAbstratas++;
	}
}