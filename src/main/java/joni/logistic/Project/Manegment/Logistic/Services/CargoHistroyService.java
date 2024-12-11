package joni.logistic.Project.Manegment.Logistic.Services;

import joni.logistic.Project.Manegment.Logistic.Models.CargoHIstory;
import joni.logistic.Project.Manegment.Logistic.Repositories.CargoHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CargoHistroyService {

    private CargoHistoryRepository cargoHistoryRepository;

    @Autowired
    public CargoHistroyService(CargoHistoryRepository cargoHistoryRepository) {
        this.cargoHistoryRepository = cargoHistoryRepository;
    }
    @Transactional
    public void saveHistory(CargoHIstory cargoHIstory){
        cargoHistoryRepository.save(cargoHIstory);
    }
    public List<CargoHIstory> getCargoListByClientName(String name){
        return cargoHistoryRepository.findByClientNama(name);
    }


}
