package joni.logistic.Project.Manegment.Logistic.Services;

import jakarta.validation.Valid;
import joni.logistic.Project.Manegment.Logistic.Models.DriverHistory;
import joni.logistic.Project.Manegment.Logistic.Repositories.DriverHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DriverHistoryService {
    private DriverHistoryRepository driverHistoryRepository;
    @Autowired
    public DriverHistoryService(DriverHistoryRepository driverHistoryRepository) {
        this.driverHistoryRepository = driverHistoryRepository;
    }
    @Transactional
    public void addHistory(DriverHistory history){
        driverHistoryRepository.save(history);
    }
    public List<DriverHistory> getHistoryForClient(String name){
        return driverHistoryRepository.findByClientNama(name);
    }


}
