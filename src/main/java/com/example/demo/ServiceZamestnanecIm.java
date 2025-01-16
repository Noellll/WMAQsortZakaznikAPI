package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ServiceZamestnanecIm implements ServiceZamestnanec {
    private Repo repo;
    @Autowired
    public ServiceZamestnanecIm(Repo repo){
        this.repo = repo;
    }
    public Iterable<Zamestnanec> all(){
        return repo.findAll();
    }
    public String save(@RequestBody Zamestnanec z){
        this.repo.save(z);
        return "Saved";
    }

    public List<String> sort() {
        QuickSortZamestnanciDatum ZamSort = new QuickSortZamestnanciDatum(repo);
        return ZamSort.sortAll();
    }
}
