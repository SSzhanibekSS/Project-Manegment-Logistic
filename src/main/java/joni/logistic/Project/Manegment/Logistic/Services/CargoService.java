package joni.logistic.Project.Manegment.Logistic.Services;

import joni.logistic.Project.Manegment.Logistic.Models.Cargo;
import joni.logistic.Project.Manegment.Logistic.Repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CargoService {

    private CargoRepository cargoRepository;


@Autowired
    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }
    @Transactional
    public void SaveCargoOrder(Cargo cargo){
    cargoRepository.save(cargo);
    }

    public List<Cargo> getCargoMyName(String name){
    return cargoRepository.findByDriverName(name);
    }
}
