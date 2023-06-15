package it.betacom.conto;

import java.time.Duration;
import java.time.LocalDate;

class ContoDeposito extends Conto {
    private double tasso=0.10;
    private double limitePrelievo=1000;
    private LocalDate ultimaDataGenerazioneInteressi;

    public ContoDeposito(String titolare, LocalDate dataApertura, double saldo) {
        super(titolare, dataApertura, saldo);
        this.ultimaDataGenerazioneInteressi = dataApertura;
    }

    @Override
    public void preleva(double importo,LocalDate data) {
    	generaInteressi(data);
        if (importo <= saldo && importo <= limitePrelievo) {
            saldo -= importo;
            System.out.println("Hai prelevato " + importo + " euro.");
        } else {
            System.out.println("Importo di prelievo supera saldo o limite consentito.");
        }
    }
    
    

    @Override
	public void versa(double importo, LocalDate data) {
    	generaInteressi(data);
		super.versa(importo, data);
	}

	@Override
    public void generaInteressi(LocalDate data) {
        long giorniPassati = Duration.between(ultimaDataGenerazioneInteressi.atStartOfDay(), data.atStartOfDay()).toDays();
        double interessi = saldo * tasso/ 365 * giorniPassati;
        saldo += interessi;
        System.out.println("Dal " + ultimaDataGenerazioneInteressi+ " al " + data + " per un totale di " + giorniPassati + " giorni sono stati generati interessi sul contocorrente per " + interessi + " euro su un saldo pari a " + (saldo-interessi));
        ultimaDataGenerazioneInteressi = data;
    }

}