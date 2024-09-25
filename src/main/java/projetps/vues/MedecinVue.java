package projetps.vues;

import projetps.entities.Medecin;

public class MedecinVue  extends View<Medecin>{

    @Override
    public Medecin saisie() {
        Medecin medecin = new Medecin();

        do {
            System.out.println("Veuillez saisir le nom");
            medecin.setNom(scanner.nextLine());
            
        } while (medecin.getNom() == "");

        do {
            System.out.println("Veuillez saisir le prenom");
            medecin.setPrenom(scanner.nextLine());
        } while (medecin.getPrenom() ==  "");

        return medecin;
    }

    
}
