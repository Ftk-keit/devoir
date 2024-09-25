package projetps.services;

import java.util.List;

import projetps.entities.Medecin;
import projetps.repository.db.impl.MedecinRepositoryDbImpl;

public class MedecinService {
    private MedecinRepositoryDbImpl medecinRepositoryDbImpl;

    public MedecinService(MedecinRepositoryDbImpl medecinRepositoryDbImpl) {
        this.medecinRepositoryDbImpl = medecinRepositoryDbImpl;
    }

    public void enregistre(Medecin medecin) {
        medecinRepositoryDbImpl.insert(medecin);
    }

    public Medecin selectById(int id) {
         return medecinRepositoryDbImpl.selectByID(id);
    }

    public List<Medecin> show() {
        return medecinRepositoryDbImpl.selectAll();
    }
}
