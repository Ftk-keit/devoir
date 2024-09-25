package projetps.services;

import java.util.List;

import projetps.entities.Rv;
import projetps.repository.RvRepository;
import projetps.repository.db.impl.RvRepositoryDbImpl;

public class RvService {
    private RvRepository rvRepository;

    public RvService(RvRepositoryDbImpl rvRepository) {
        this.rvRepository = rvRepository;
    }

    public void enregistre(Rv medecin) {
        rvRepository.insert(medecin);
    }

    public List<Rv> show() {
        return rvRepository.selectAll();
    }
}
