package jsonds.model;

public class Flight {
	private String from;
	private String to;
	private String dtDep;
	private String dtRet;
	private int adult;
	private int child;
	private double alertPrice;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getDtDep() {
		return dtDep;
	}

	public void setDtDep(String dtDep) {
		this.dtDep = dtDep;
	}

	public String getDtRet() {
		return dtRet;
	}

	public void setDtRet(String dtRet) {
		this.dtRet = dtRet;
	}

	public int getAdult() {
		return adult;
	}

	public void setAdult(int adult) {
		this.adult = adult;
	}

	public int getChild() {
		return child;
	}

	public void setChild(int child) {
		this.child = child;
	}

	public double getAlertPrice() {
		return alertPrice;
	}

	public void setAlertPrice(double alertPrice) {
		this.alertPrice = alertPrice;
	}

	@Override
	public String toString() {
		return "De: " + getFrom() + ", Para: " + getTo() + ", Partida: " + getDtDep() + ", Retorno: " + getDtRet()
				+ ", Adultos: " + getAdult() + ", Criancas: " + getChild() + ", Preço: " + getAlertPrice();
	}
}
