package joni.logistic.Project.Manegment.Logistic.Repositories;

import joni.logistic.Project.Manegment.Logistic.Models.DriverHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverHistoryRepository extends JpaRepository<DriverHistory, Integer> {

    List<DriverHistory> findByClientNama(String name);
}
