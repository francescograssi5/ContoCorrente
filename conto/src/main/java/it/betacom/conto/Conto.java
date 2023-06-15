package it.betacom.conto;

import java.time.LocalDate;

class Conto {
    protected String titolare;
    protected LocalDate dataApertura;
    protected double saldo;

    public Conto(String titolare, LocalDate dataApertura, double saldo) {
        this.titolare = titolare;
        this.dataApertura = dataApertura;
        this.saldo = saldo;
    }

    public void preleva(double importo,LocalDate data) {
        if (importo <= saldo) {
            saldo -= importo;
            System.out.println("Hai prelevato " + importo + " euro.");
        } else {
            System.out.println("Saldo insufficiente.");
        }
    }

    public void versa(double importo,LocalDate data) {
        saldo += importo;
        System.out.println("Hai versato " + importo + " euro.");
    }

    public void generaInteressi(LocalDate data) {
        // Non implementato nella classe base
    }

    public void stampaDati() {
        System.out.println("Titolare: " + titolare);
        System.out.println("Data apertura: " + dataApertura);
        System.out.println("Saldo attuale: " + saldo + " euro.");
    }

}
