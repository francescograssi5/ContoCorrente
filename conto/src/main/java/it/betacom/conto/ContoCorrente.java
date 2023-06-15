package it.betacom.conto;

import java.time.Duration;
import java.time.LocalDate;

class ContoCorrente extends Conto {
    private double tasso = 0.05;
    private LocalDate ultimaDataGenerazioneInteressi;


    public ContoCorrente(String titolare, LocalDate dataApertura, double tasso) {
        super(titolare, dataApertura, tasso);
        this.ultimaDataGenerazioneInteressi = dataApertura;
    }

    @Override
    public void generaInteressi(LocalDate data) {
        long giorniPassati = Duration.between(ultimaDataGenerazioneInteressi.atStartOfDay(), data.atStartOfDay()).toDays();
        double interessi = saldo * tasso / 365 * giorniPassati;
        saldo += interessi;
        System.out.println("Dal " + ultimaDataGenerazioneInteressi+ " al " + data + " per un totale di " + giorniPassati + " giorni sono stati generati interessi sul contocorrente per " + interessi + " euro su un saldo pari a " + (saldo-interessi));
        ultimaDataGenerazioneInteressi = data;
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

