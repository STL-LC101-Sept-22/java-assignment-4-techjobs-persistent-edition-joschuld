package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private JobRepository jobRepository;

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("title", "My Jobs");

        return "index";
    }

    // add employers with .findAll on the repository
    // instructions didnt call for the skills, but I had an whitepage error
    // adding skills got rid of the error
    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        model.addAttribute("employers", employerRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                       Errors errors, Model model, @RequestParam int employerId, @RequestParam List<Integer> skills) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "add";
        }

        // how to save both employer and skills to a new Job instance?
        // use setters in Job class to set the employer, and skills
        // after they are set, just do something with jobRepository.save(newJob)?

        // replace the model.addAttribute with newJob.setEmployer(employer)

//        Optional optEmployer = employerRepository.findById(employerId); // taking in the methods argument)
//        if (optEmployer.isPresent()) {
//            Employer employer = (Employer) optEmployer.get();
//            model.addAttribute("employer", employer);

        Optional optEmployer = employerRepository.findById(employerId); // i really dont understand this code, but it works
        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            newJob.setEmployer(employer);
        }

        List<Skill> skillList = (List<Skill>) skillRepository.findAllById(skills);
        newJob.setSkills(skillList);

        jobRepository.save(newJob);

            return "redirect:";
        }


    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

        return "view";
    }


}
