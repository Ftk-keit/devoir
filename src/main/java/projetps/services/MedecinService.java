package projetps.services;

import java.util.List;

import projetps.entities.Medecin;
import projetps.repository.MedecinRepository;

public class MedecinService {
    private MedecinRepository medecinRepository;

    public MedecinService(MedecinRepository medecinRepository) {
        this.medecinRepository = medecinRepository;
    }

    public void enregistre(Medecin medecin) {
        medecinRepository.insert(medecin);
    }

    public Medecin selectById(int id) {
         return medecinRepository.selectByID(id);
    }

    public List<Medecin> show() {
        return medecinRepository.selectAll();
    }
}
