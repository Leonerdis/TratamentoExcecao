package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import modelo.excecoes.ExcecaoDeDominio;

public class Reserva {
	private Integer numeroQuarto;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
	}
	
	public Reserva(Integer numeroQuarto, Date checkin, Date checkout) throws ExcecaoDeDominio{
	 if (!checkout.after(checkin)) {
		throw new ExcecaoDeDominio("A data de check-out é anterior a data de check-in");
	}else
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
	
	public void cadastraData(Date checkin, Date checkout, Integer numeroQuarto) {
		Date agora = new Date();
		if(checkin.before(agora) || checkout.before(agora)) {
			throw new IllegalArgumentException("Data de entrada é anterior a data atual");
		}
		if(checkout.after(checkin)) {
			throw new IllegalArgumentException("A data de check-out é anterior a data de check-in");
		}
		this.checkin = checkin;
		this.checkout= checkout;
		this.numeroQuarto = numeroQuarto;
	}
	public void atualizaData(Date checkin, Date checkout) throws ExcecaoDeDominio {
		Date agora = new Date();
		if(checkin.before(agora) || checkout.before(agora)) {
			throw new ExcecaoDeDominio("Datas de atualização anterior a data atual");
		}if (!checkout.after(checkin)) {
			throw new ExcecaoDeDominio("A data de check-out é anterior a data de check-in");
		}
			this.checkin = checkin;
			this.checkout = checkout;
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
			+  " noite(s)";
				
	}
	
}
