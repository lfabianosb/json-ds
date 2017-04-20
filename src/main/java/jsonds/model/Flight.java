package jsonds.model;

public class Flight {
	private String from;
	private String to;
	private String dtDep;
	private String dtRet;
	private float price;

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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "De: " + getFrom() + ", Para: " + getTo() + ", Partida: " + getDtDep() + ", Retorno: " + getDtRet()
				+ ", Preço: " + getPrice();
	}
}
