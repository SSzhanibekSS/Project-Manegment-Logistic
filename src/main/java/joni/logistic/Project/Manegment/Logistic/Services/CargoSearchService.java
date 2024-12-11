package joni.logistic.Project.Manegment.Logistic.Services;

import joni.logistic.Project.Manegment.Logistic.Models.Cargo;
import joni.logistic.Project.Manegment.Logistic.Models.CargoSearch;
import joni.logistic.Project.Manegment.Logistic.Repositories.CargoSearchRepository;
import joni.logistic.Project.Manegment.Logistic.Util.GetClientID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class CargoSearchService {
    private CargoSearchRepository cargoSearchRepository;
    private CargoService cargoService;
    private GetClientID getClientID;
    @Autowired
    public CargoSearchService(CargoSearchRepository cargoSearchRepository, CargoService cargoService, GetClientID getClientID) {
        this.cargoSearchRepository = cargoSearchRepository;
        this.cargoService = cargoService;
        this.getClientID = getClientID;
    }

    @Transactional
    public void saveOrder(CargoSearch cargoSearch){
        cargoSearchRepository.save(cargoSearch);
    }

    public List<CargoSearch> findAll(){
        return cargoSearchRepository.findAll();
    }
    public List<CargoSearch> findCargoByObject(CargoSearch cargoSearch){
        return cargoSearchRepository.findByWeightInTonAndVolumeAndPoingAAndPointBAndPaymentTypeAndBodyType(
              cargoSearch.getWeightInTon(), cargoSearch.getVolume(),
              cargoSearch.getPoingA(),cargoSearch.getPointB(),
              cargoSearch.getPaymentType(), cargoSearch.getBodyType()
        );
    }
    public CargoSearch getCargoById(int id){
     return cargoSearchRepository.findById(id).get();
    }

    public List<CargoSearch> getCargosForSpecificClient(){
        List<CargoSearch> list = new ArrayList<>();

        List<Cargo> cargoMyName = cargoService.getCargoMyName(getClientID.getClientName());

        for(Cargo c:cargoMyName){
            list.add(getCargoById(c.getId()));
        }
        return list;

    }
}
