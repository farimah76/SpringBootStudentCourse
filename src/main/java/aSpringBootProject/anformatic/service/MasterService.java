package aSpringBootProject.anformatic.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aSpringBootProject.anformatic.model.Master;
import aSpringBootProject.anformatic.repository.MasterRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MasterService {
    @Autowired
    MasterRepository masterRepository;

    public Master createMaster(String name) {
        Master master = new Master();
        master.setName(name);
        return masterRepository.save(master);
    }

    public List<Master> getAllMaster() {
        return masterRepository.findAll();
    }

    public Master getMasterById(Long id) {
        return masterRepository.findById(id).orElse(null);
    }
//    public List<Course> getMasterbyCourse(Long masterId){
//        Master master=masterRepository.findById(masterId).orElseThrow(()->new RuntimeException("master not found"));
//        return master.getCourse();
//    }

//    @Transactional
//    public Master save(Master master){return masterRepository.save(master);}
}
