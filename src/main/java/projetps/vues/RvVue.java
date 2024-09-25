package projetps.vues;

import projetps.entities.Rv;
import projetps.services.MedecinService;

public class RvVue  extends View<Rv>{
    private  MedecinService medecinService;
    public RvVue(MedecinService medecinService) {
        this.medecinService = medecinService;
    }
    @Override
    public Rv saisie() {
        Rv rv = new Rv();
        do {
            System.out.println("Veuillez saisir la date");
            rv.setDate(scanner.nextLine());
            
        } while (rv.getDate() == "");

        do {
            System.out.println("Veuillez saisir l' id du medecin");
            rv.setMedecin(medecinService.selectById(scanner.nextInt()));
        } while (rv.getMedecin() ==  null);

        return rv;
    }
    
}
