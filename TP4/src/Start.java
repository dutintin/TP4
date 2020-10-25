import GestionVol.Compagnie;
import GestionVol.Vol;
import java.text.SimpleDateFormat;

public class Start {

    public static void main(String[] args){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        //Création d'une compagnie et de son nom
        Compagnie AirFrance = new Compagnie();
        AirFrance.setNom("Air France");
        // Creation de vols et attribution à une compagnie
        Vol vol1 = new Vol();
        vol1.setNumero("FR1");
        Vol vol2 = new Vol();
        vol2.setNumero("FR2");
        vol1.setCompagnie(AirFrance);
        vol2.setCompagnie(AirFrance);
        //Affectation du vol à un horaire de départ et d'arrivé
        try{
            vol1.setDateDepart(format.parse("24/10/2020 14:20"));
            vol1.setDateArrive(format.parse("24/10/2020 16:43"));
        } catch (Exception e){
            throw new RuntimeException("Erreur date");
        }
        // Affichage de la compagnie, du vol, des horaires et de la durée
        System.out.println(vol1.getNumero());
        System.out.println(vol1.getCompagnie().getNom());
        System.out.println(vol1.getDateDepart());
        System.out.println(vol1.getDateArrive());
        System.out.println(vol1.ObtenirDuree().toString().substring(2).replace("M"," minutes").replace("H", " heures "));
        //Affichage de l'état du vol (ouvert ou fermé à la réservation)
        vol1.setStatut(true);
        if (vol1.getStatut() == true)
            System.out.println("Le vol est ouvert");
        else {
            System.out.println("Le vol est fermé");
        }
        //Affichage de tous les vols de la compagnie
        System.out.println("Vol de Air France : ");
        for(Vol v : AirFrance.getVols()){
            System.out.println(v.getNumero());
        }
        // Changement de compagnie pour vol1 et affichage des vols de la nouvelle compagnie et de l'ancienne
        Compagnie Luftansa = new Compagnie();
        Luftansa.setNom("Luftansa");
        vol1.setCompagnie(Luftansa);
        vol1.setNumero("DE1");
        System.out.println("Vol de Luftansa : ");
        for(Vol v : Luftansa.getVols()){
            System.out.println(v.getNumero());
        }
        System.out.println("Vol de Air France : ");
        for(Vol v : AirFrance.getVols()){
            System.out.println(v.getNumero());
        }

    }


}
