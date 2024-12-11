package joni.logistic.Project.Manegment.Logistic.Repositories;

import jakarta.persistence.criteria.CriteriaBuilder;
import joni.logistic.Project.Manegment.Logistic.Models.DriverOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverOrderRepository extends JpaRepository<DriverOrder, Integer> {


    List<DriverOrder> findAllByWeightInTonAndVolumeAndBodyTypeAndCargoTypeAndPaymentTypeAndPointBAndPoingA(int weightInTon, int vol,String body, String cargo,String pay,String pb,String pa);
}
