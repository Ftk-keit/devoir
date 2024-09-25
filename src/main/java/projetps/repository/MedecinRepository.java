package projetps.repository;

import projetps.entities.Medecin;

public interface MedecinRepository extends Repository<Medecin> {
    Medecin selectByID(int id);
} 