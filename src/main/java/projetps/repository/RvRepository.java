package projetps.repository;

import projetps.entities.Rv;

import java.util.List;

public interface RvRepository  extends Repository<Rv>{
    List<Rv> filtreByDate(String date);
}
