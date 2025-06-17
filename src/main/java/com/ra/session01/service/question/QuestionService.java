package com.ra.session01.service.question;

import com.ra.session01.model.entity.Question;
import com.ra.session01.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class QuestionService implements IQuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> findAll() {
        try {
            return questionRepository.findAll();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Question findById(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Not found question"));
    }

    @Override
    public Question save(Question question) {
        try {
            return questionRepository.save(question);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Question update(Question question) {
        Question question1 = findById(question.getId());
        if (question1 != null) {
            try {
               return questionRepository.save(question);

            }catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }else {
            return null;
        }
    }

    @Override
    public boolean delete(Long id) {
        Question question = findById(id);
        if (question != null) {
            try {
                questionRepository.delete(question);
                return true;
            }catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }else {
            return false;

        }
    }
}
