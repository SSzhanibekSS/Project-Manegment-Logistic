package joni.logistic.Project.Manegment.Logistic.Repositories;

import joni.logistic.Project.Manegment.Logistic.Models.CargoSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoSearchRepository extends JpaRepository<CargoSearch, Integer> {

    List<CargoSearch> findByWeightInTonAndVolumeAndPoingAAndPointBAndPaymentTypeAndBodyType(
            int weight, int vol, String pA, String pB, String pay, String body
    );
}
