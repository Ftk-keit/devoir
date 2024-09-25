package projetps.services;
import java.util.List;

import projetps.entities.Rv;
import projetps.repository.db.impl.RvRepositoryDbImpl;

public class RvService {
   private RvRepositoryDbImpl rvRepositoryDbImpl;

      public RvService(RvRepositoryDbImpl rvRepositoryDbImpl) {
    this.rvRepositoryDbImpl = rvRepositoryDbImpl;
}

    public void enregistre(Rv medecin){
        rvRepositoryDbImpl.insert(medecin);
    }

    public List<Rv> show() {
        return rvRepositoryDbImpl.selectAll();
    }
}
