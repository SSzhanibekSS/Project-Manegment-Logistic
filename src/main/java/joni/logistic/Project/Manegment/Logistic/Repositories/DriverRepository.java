package joni.logistic.Project.Manegment.Logistic.Repositories;

import joni.logistic.Project.Manegment.Logistic.Models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

    List<Driver> findByDriverName(String name);
}
