package projetps.entities;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Medecin {
    private int id;
    private static int nb = 1;
    private String nom;
    private String prenom;
    public Medecin() {
        id = nb++;
    }
}
