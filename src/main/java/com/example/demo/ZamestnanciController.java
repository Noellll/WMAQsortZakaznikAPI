package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ZamestnanciController {
    private ServiceZamestnanec servis;
    public ZamestnanciController(ServiceZamestnanec servis){
        this.servis = servis;
    }

    @GetMapping("/all")
    public Iterable<Zamestnanec> getAll(){
        return servis.all();
    }

    @PostMapping("/save")
    public String saveZamestnanec(@RequestBody Zamestnanec z){
          return servis.save(z);

    }
    @GetMapping("/sort")
    public List<String> sort(){
        return servis.sort();
    }


}
