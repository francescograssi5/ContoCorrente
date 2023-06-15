package it.betacom.conto;

import java.time.LocalDate;
import java.util.Random;

class ContoInvestimento extends Conto {
    private Random random;

    public ContoInvestimento(String titolare, LocalDate dataApertura, double saldo) {
        super(titolare, dataApertura, saldo);
        random = new Random();
    }

    @Override
    public void generaInteressi(LocalDate data) {
        double tassoInteresse = (random.nextDouble() * 2 - 1) * 100; // Genera un tasso di interesse tra -100% e 100%
        double interessi = saldo * tassoInteresse / 100;
        saldo += interessi;
        System.out.println("In data " + data + " Generati interessi sul conto di investimento per " + interessi + " euro.");
    }
    

    @Override
	public void versa(double importo, LocalDate data) {
    	generaInteressi(data);
		super.versa(importo, data);
	}
    
	@Override
	public void preleva(double importo, LocalDate data) {
		generaInteressi(data);
		super.preleva(importo, data);
	}

}

