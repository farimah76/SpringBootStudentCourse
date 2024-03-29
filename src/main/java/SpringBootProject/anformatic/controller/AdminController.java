package SpringBootProject.anformatic.controller;

import SpringBootProject.anformatic.model.Course;
import SpringBootProject.anformatic.model.Master;
import SpringBootProject.anformatic.model.Student;
import SpringBootProject.anformatic.service.CourseService;
import SpringBootProject.anformatic.service.MasterService;
import SpringBootProject.anformatic.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/admin")
public class AdminController {

    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;
    @Autowired
    MasterService masterService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String admin(){

        return "admin";
    }
    @RequestMapping(value = "/addStudent",method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addStudent(Model model){
        model.addAttribute("student",new Student());
        model.addAttribute("students",studentService.getAllStudent());
        return "/pages/addStudent";
    }

    @RequestMapping(value = "/addCourse",method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addCourse(Model model){
        model.addAttribute("course",new Course());
        model.addAttribute("courses",courseService.getAllCourse());
        model.addAttribute("masters",masterService.getAllMaster());

        return "/pages/addCourse";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/addMaster",method = RequestMethod.GET)
    public   String addProfessor(Model model){
        model.addAttribute("master",new Master());
        model.addAttribute("masters",masterService.getAllMaster());

        return "/pages/addProfessor";
    }

}
