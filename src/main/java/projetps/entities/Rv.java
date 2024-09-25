package projetps.entities;


import lombok.Data;

@Data
public class Rv {
    private int id;
    private static int nb = 1;
    private String date;
    private String heure;
    private Medecin medecin;

    public Rv() {
        id = nb++;
    }
}
