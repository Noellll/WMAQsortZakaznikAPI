package com.example.demo;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ServiceZamestnanec {
    public Iterable<Zamestnanec> all();
    public String save(@RequestBody Zamestnanec z);
    public List<String> sort();
}
