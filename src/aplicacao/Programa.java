package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reserva;
import modelo.excecoes.ExcecaoDeDominio;


public class Programa {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			
			System.out.print("Entre com o número do quarto:");
			int numeroQuarto = sc.nextInt();
			System.out.print("Data check-in (dd/MM/yyyy)");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Data check-out (dd/MM/yyyy)");
			Date checkout = sdf.parse(sc.next());
			
		
			Reserva reserva = new Reserva(numeroQuarto, checkin,checkout);
			System.out.println();
			System.out.println(reserva);
			
			System.out.println();
			System.out.print("Entre com a atualização das datas:");
			System.out.println();
			System.out.print("Data check-in (dd/MM/yyyy)");
			checkin = sdf.parse(sc.next());
			System.out.print("Data check-out (dd/MM/yyyy)");
			checkout = sdf.parse(sc.next());
			
			reserva.atualizaData(checkin, checkout);
			System.out.println("Reserva: " + reserva);
		}
		catch(ParseException e) {
			System.out.println("Formato de data inválido");
		}
		catch(ExcecaoDeDominio e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		
		sc.close();
	}
}
