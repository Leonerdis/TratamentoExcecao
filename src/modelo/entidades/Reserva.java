package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer numeroQuarto;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numeroQuarto, Date checkin, Date checkout) {
		this.numeroQuarto = numeroQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duracao() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String atualizaData(Date checkin, Date checkout) {
		Date agora = new Date();
		if(checkin.before(agora) || checkout.before(agora)) {
			return "datas de atualização anterior a data atual";
		}if (!checkout.after(checkin)) {
			return "A data de check-out é anterior a data de check-in";
		}
			this.checkin = checkin;
			this.checkout = checkout;
			return null;
	}
	
	@Override
	public String toString() {
		return "Quarto "
			+  numeroQuarto
			+  ", check-in: "
			+  sdf.format(checkin)
			+  " , check-out: "
			+  sdf.format(checkout)
			+  ", "
			+  duracao()
			+  " noites";
				
	}
	
}
