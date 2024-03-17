package aSpringBootProject.anformatic.controller;

import aSpringBootProject.anformatic.AnformaticApplication;
import aSpringBootProject.anformatic.model.Course;
import aSpringBootProject.anformatic.model.Master;
import aSpringBootProject.anformatic.service.MasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/master")
public class MasterController {
    private static final Logger logger = LoggerFactory.getLogger(AnformaticApplication.class);
    @Autowired
   private MasterService masterService;
    @PostMapping
    public Master createMaster(@RequestParam String name){
        logger.info("createMaster : name:" + name);
        return masterService.createMaster(name);
    }

    @GetMapping("{id}")
    public Master getMasterById(@PathVariable Long id){
        return masterService.getMasterById(id);
    }

//    public MasterController(MasterService masterService) {
//        this.masterService = masterService;
//    }
//    @GetMapping("{masterId}/course")
//         public List<Course> getMasterByCourses(@PathVariable Long masterId)   {
//        return masterService.getMasterbyCourse(masterId);
//    }

}
