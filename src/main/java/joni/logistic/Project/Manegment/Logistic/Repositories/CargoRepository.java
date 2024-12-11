package joni.logistic.Project.Manegment.Logistic.Repositories;

import joni.logistic.Project.Manegment.Logistic.Models.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {
    List<Cargo> findByDriverName(String name);
}
