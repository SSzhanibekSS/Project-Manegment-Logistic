package joni.logistic.Project.Manegment.Logistic.Services;

import joni.logistic.Project.Manegment.Logistic.Models.Driver;
import joni.logistic.Project.Manegment.Logistic.Models.DriverOrder;
import joni.logistic.Project.Manegment.Logistic.Repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DriverService {

    private DriverRepository repository;
    @Autowired
    public DriverService(DriverRepository repository) {
        this.repository = repository;
    }
    @Transactional
    public void addOrder(Driver driver){
        repository.save(driver);
    }
    public List<Driver> getOrder(){
        return repository.findAll();
    }
    public List<Driver> getOrderByName(String name){
       return repository.findByDriverName(name);
    }
}
