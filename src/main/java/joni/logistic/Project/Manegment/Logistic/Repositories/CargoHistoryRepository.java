package joni.logistic.Project.Manegment.Logistic.Repositories;

import jakarta.persistence.criteria.CriteriaBuilder;
import joni.logistic.Project.Manegment.Logistic.Models.CargoHIstory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoHistoryRepository extends JpaRepository<CargoHIstory, Integer> {

    List<CargoHIstory> findByClientNama(String name);
}
