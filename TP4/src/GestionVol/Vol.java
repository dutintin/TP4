package GestionVol;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Vol {

    private String numero;

    private Aeroport depart;

    private Aeroport arrivee;

    private Compagnie compagnie;

    private Date dateDepart;

    private Date dateArrive;

    private Boolean statut;

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateArrive() {
        return dateArrive;
    }

    public void setDateArrive(Date dateArrive) {
        this.dateArrive = dateArrive;
    }

    public Duration ObtenirDuree() {
        if (this.dateDepart != null & this.dateArrive != null){
            return Duration.of(dateArrive.getTime() - dateDepart.getTime(), ChronoUnit.MILLIS);
        }
        return null;
    }

    public Vol() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Aeroport getDepart() {
        return depart;
    }

    public void setDepart(Aeroport depart) {
        this.depart = depart;
    }

    public Aeroport getArrivee() {
        return arrivee;
    }

    public void setArrivee(Aeroport arrivee) {
        this.arrivee = arrivee;
    }

    public Compagnie getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(Compagnie compagnie) {
        if(compagnie!=null){
             compagnie.addVolEntreObj(this);
        }
        if(this.compagnie!=null){
            this.compagnie.removeVolEntreObj(this);
        }
        this.compagnie = compagnie;
    }

    protected void setCompagnieEntreObj(Compagnie compagnie) {
       this.compagnie = compagnie;
    }



    @Override
    public boolean equals(Object obj) {
       try {
           return ((Vol) obj).getNumero().equals(this.numero);
       }catch (Exception e) {
            return false;
        }

    }
}

