package GestionVol;

import java.util.ArrayList;
import java.util.Collection;


public class Compagnie {

    private String nom;

    public Compagnie() {

    }

    public Collection<Vol> vols = new ArrayList<>();


    public Collection<Vol> getVols() {
        return vols;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setVols(Collection<Vol> vols) {
        for (Vol v : this.vols){
            v.setCompagnieEntreObj(null);
        }
        this.vols = vols;
        if (this.vols != null) {
            for (Vol v : this.vols) {
                v.setCompagnieEntreObj(this);
            }
        }
    }

    public void addVol(Vol vol){
        vol.setCompagnieEntreObj(this);
        this.vols.add(vol);
    }

    public void removeVol(Vol vol){
        vol.setCompagnieEntreObj(null);
        this.vols.remove(vol);
    }

    protected void setVolsEntreObj(Collection<Vol> vols) {
        this.vols = vols;
    }

    protected void addVolEntreObj(Vol vol){
        this.vols.add(vol);
    }

    protected void removeVolEntreObj(Vol vol){
        this.vols.remove(vol);
    }

}


