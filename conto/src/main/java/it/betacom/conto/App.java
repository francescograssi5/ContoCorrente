package it.betacom.conto;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */


public class App 
{
	  public static void main(String[] args) {
	        LocalDate dataApertura = LocalDate.of(2021, 1, 1);

	        ContoCorrente contoCorrente = new ContoCorrente("Mario Rossi", dataApertura, 1000);
	        ContoDeposito contoDeposito = new ContoDeposito("Luigi Verdi", dataApertura, 1000);
	        ContoInvestimento contoInvestimento = new ContoInvestimento("Giovanni Bianchi", dataApertura, 1000);

	        contoCorrente.stampaDati();
	        contoCorrente.preleva(900, LocalDate.of(2021, 07, 01));
	        contoCorrente.versa(400, LocalDate.of(2021, 8, 01));
	        contoCorrente.generaInteressi(LocalDate.of(2021, 12, 31));
	        System.out.println("----------------------");
	        contoCorrente.generaInteressi(LocalDate.now());


	        System.out.println();
	        contoCorrente.stampaDati();
	        System.out.println("------------------------------");
	        
	        contoDeposito.stampaDati();
	        contoDeposito.preleva(900, LocalDate.of(2021, 07, 01));
	        contoDeposito.versa(400, LocalDate.of(2021, 8, 01));
	        contoDeposito.generaInteressi(LocalDate.of(2021, 12, 31));
	        System.out.println("----------------------");
	        contoDeposito.generaInteressi(LocalDate.now());


	        System.out.println();
	        contoDeposito.stampaDati();
	        System.out.println("------------------------------");
	        
	        
	        contoInvestimento.stampaDati();
	        contoInvestimento.preleva(900, LocalDate.of(2021, 07, 01));
	        contoInvestimento.versa(400, LocalDate.of(2021, 8, 01));
	        contoInvestimento.generaInteressi(LocalDate.of(2021, 12, 31));
	        System.out.println("----------------------");
	        contoInvestimento.generaInteressi(LocalDate.now());


	        System.out.println();
	        contoInvestimento.stampaDati();
	        System.out.println("------------------------------");

	    }
}
