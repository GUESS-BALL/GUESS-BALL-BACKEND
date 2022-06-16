package com.cricket.Services;

import com.cricket.Dao.TriviaDao;
import com.cricket.entities.Trivia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TriviaService {

    @Autowired
    private TriviaDao triviaDao;

    public static Integer question = 6;

    public void questionchange(){
        long n = triviaDao.count();
        int index = (int)(Math.random() * n);
        question = index;
    }

    public List<Trivia> getAll(){
        return triviaDao.findAll();
    }

    public Trivia getOne(){
        Page<Trivia> triviaPage = triviaDao.findAll(PageRequest.of(question,1));
        if(triviaPage.hasContent()){
            return triviaPage.getContent().get(0);
        }
        return null;
    }

    public void deleteOne(int id){
        triviaDao.deleteById(id);
    }

    public Trivia insertOne(Trivia trivia){
        return triviaDao.save(trivia);
    }

    public void deleteAll(){
        triviaDao.deleteAll();
    }
}
