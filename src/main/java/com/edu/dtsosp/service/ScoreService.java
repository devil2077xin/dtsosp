package com.edu.dtsosp.service;

import com.edu.dtsosp.domain.Score;
import com.edu.dtsosp.domain.ScoreStats;
import com.edu.dtsosp.util.PageBean;

import java.util.List;
import java.util.Map;


public interface ScoreService {
    PageBean<Score> queryPage(Map<String, Object> paramMap);

    boolean isScore(Score score);

    int addScore(Score score);

    int editScore(Score score);

    int deleteScore(Integer id);

    List<Score> getAll(Score score);
}
