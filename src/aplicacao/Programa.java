package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Entre com o número do quarto");
		int numeroQuarto = sc.nextInt();
		System.out.println("Data check-in (dd/MM/yyyy)");
		Date checkin = sdf.parse(sc.next());
		System.out.println("Data check-ou (dd/MM/yyyy)");
		Date checkout = sdf.parse(sc.next());
		
		if(!checkout.after(checkin)) {
			System.out.println("Erro na reserva: A data de check-out é anterior a data de check-in");
		}else {
			Reserva reserva = new Reserva(numeroQuarto, checkin, checkout);
			System.out.println(reserva);
			
			System.out.println();
			System.out.println("Entre com a atualização das datas");
			System.out.println("Data check-in (dd/MM/yyyy)");
			checkin = sdf.parse(sc.next());
			System.out.println("Data check-ou (dd/MM/yyyy)");
			checkout = sdf.parse(sc.next());
			
			Date agora = new Date();
			if(checkin.before(agora) || checkout.before(agora)) {
				System.out.println("Error na reserva: datas de atualização anterior a data atual");
			}else if (!checkout.after(checkin)) {
				System.out.println("Erro na reserva: A data de check-out é anterior a data de check-in");
			
				
			}else {
				reserva.atualizaData(checkin, checkout);
				System.out.println(reserva);
			}
			
		}
	}

}
