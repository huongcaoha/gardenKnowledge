package com.ra.session01.service.answer;

import com.ra.session01.model.entity.Answer;
import com.ra.session01.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AnswerService implements IAnswerService{
    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    @Override
    public Answer findById(Long id) {
        return answerRepository.findById(id).orElseThrow(() ->  new NoSuchElementException("No Answer found with id: " + id));
    }

    @Override
    public Answer save(Answer answer) {
        try {
            return answerRepository.save(answer);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Answer update(Answer answer) {
        Answer answer1 = findById(answer.getId());
        if (answer1 != null) {
            try {
                return answerRepository.save(answer);
            }catch (Exception e){
                return null;
            }
        }else {
            return null;
        }

    }

    @Override
    public boolean delete(Long id) {
       Answer answer = findById(id);
       if (answer != null) {
           try {
               answerRepository.delete(answer);
               return true;
           }catch (Exception e){
               return false;
           }
       }else {
           return false;
       }
    }
}
