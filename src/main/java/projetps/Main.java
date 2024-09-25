package projetps;

import java.util.Scanner;

import projetps.entities.Medecin;
import projetps.repository.db.impl.MedecinRepositoryDbImpl;
import projetps.services.MedecinService;
import projetps.vues.MedecinVue;


public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MedecinRepositoryDbImpl medecinRepositoryDbImpl = new MedecinRepositoryDbImpl();

        MedecinService medecinService = new MedecinService(medecinRepositoryDbImpl);
        MedecinVue medecinVue = new MedecinVue();
        
        int choice;
        do {
            choice = showMenu();
            clear();
            
            scanner.nextLine();
            switch (choice) {
                case 1:
                      medecinService.enregistre(medecinVue.saisie());
                    break;

                    case 2:
                    medecinVue.liste(medecinService.show());
                    break;
                    case 3:
                    medecinVue.liste(medecinService.show());
                    break;
                    default:
                    break;
            }
        }while (choice != 12);
    }


    public static int showMenu() {
        System.out.println("1-Ajouter un medecin");
        System.out.println("2-Lister les medecins");
        System.out.println("3-Ajouter un rv");
        System.out.println("4-Lister les rv");
        System.out.println("5-filtre rv par date");
        System.out.println("6-filtre rv medecin");

        
        return scanner.nextInt();
    }

    public static void clear() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}