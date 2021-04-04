package io.javabrains.coronavirustracker.controllers;


import io.javabrains.coronavirustracker.Services.coronaVirusDataService;
import io.javabrains.coronavirustracker.models.LocationStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//make this class a spring controller -> render a html uri
                // restController -> render a json response


@Controller
public class HomeController {
    @Autowired
    coronaVirusDataService coronaVirusDataService ;
    @GetMapping("/")
    public String home(Model model){
        List<LocationStats> allStats = coronaVirusDataService.getAllStats();
        int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        model.addAttribute("locationStats",allStats);
        model.addAttribute("totalReportedCases",totalReportedCases);
        return"home";
    }



}
