package com.example.testing_system.services;

import com.example.testing_system.model.Answer;
import com.example.testing_system.repositories.AnswersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Level;

@Service
@AllArgsConstructor
@Slf4j
public class AnswersService {
    private final AnswersRepository answersRepository;

    public List<Answer> findAll() {
        return answersRepository.findAll();
    }

    public Answer findById(int id) {
        return answersRepository.findById(id).orElseThrow();
    }

    public List<Answer> findAllCorrect() {
        return answersRepository.findByCorrectTrue();
    }

    public List<Answer> findByPrefix(String prefix) {
        return answersRepository.findByNameStartingWithIgnoreCase(prefix);
    }

    public Answer save(Answer answer) {
        return answersRepository.save(answer);
    }

    public void delete(int id) {
        answersRepository.deleteById(id);
    }

    @Transactional
    public Answer update(int id, Answer answer) {
        return answersRepository.findById(id)
                .map(ans -> {
                        ans.setName(answer.getName());
                        ans.setCorrect(answer.getCorrect());
                        ans.setQuestion(answer.getQuestion());
                        return ans;
        }).orElseThrow();
    }

    @Transactional
    public Answer partialUpdate(int id, Answer answer) {
        return answersRepository.findById(id)
                .map(ans -> {
                    log.info(ans.toString());
                    if(answer.getName() != null && !answer.getName().equals(""))
                        ans.setName(answer.getName());

                    if(answer.getCorrect() != null) {
                        ans.setCorrect(answer.getCorrect());
                    }


                    if(answer.getQuestion() != null)
                        ans.setQuestion(answer.getQuestion());
                    return ans;
                }).orElseThrow();
    }
}
