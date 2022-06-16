package com.cricket.controller;

import com.cricket.Services.TriviaService;
import com.cricket.entities.Trivia;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class TriviaController {

    @Autowired
    private TriviaService triviaService;

    public static boolean statusEnabled = true;

    @GetMapping("/getTriviaStatus")
    public boolean getStatus(){
        return statusEnabled;
    }

    @PostMapping("/changeTriviaStatus/{status}")
    public boolean setStatus(@PathVariable(value = "status") String status){
        if(status.equals("true")){ triviaService.questionchange(); statusEnabled = true;}
        else{ statusEnabled = false;}
        return statusEnabled;
    }

    @GetMapping("/AllTrivia")
    public List<Trivia> getAll(){
        return triviaService.getAll();
    }

    @GetMapping("/Trivia")
    public Trivia getOne(){
        return triviaService.getOne();
    }

    @DeleteMapping("/Trivia/{id}")
    public void deleteOne(@PathVariable(value = "id") int id){
        triviaService.deleteOne(id);
    }

    @PostMapping("/Trivia")
    public Trivia insertOne(@RequestBody Trivia trivia){
        return triviaService.insertOne(trivia);
    }

    @PostMapping("/AllTrivia")
    public List<Trivia> insertAll(@RequestBody List<Trivia> triviaList){
        ArrayList<Trivia> trivias = new ArrayList<>();
        for(Trivia trivia:triviaList){
            trivias.add(insertOne(trivia));
        }
        return trivias;
    }

    @DeleteMapping("/AllTrivia")
    public void deleteAll(){
        triviaService.deleteAll();
    }
}
