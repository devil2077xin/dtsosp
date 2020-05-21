package com.edu.dtsosp.controller;

import com.edu.dtsosp.domain.Score;
import com.edu.dtsosp.domain.Student;
import com.edu.dtsosp.service.ScoreService;
import com.edu.dtsosp.service.StudentService;
import com.edu.dtsosp.util.Const;
import com.edu.dtsosp.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/trace")
public class TraceController {

    @Autowired
    private ScoreService scoreService;
    @Autowired
    private StudentService studentService;



    @GetMapping("/trace_list")
    public String traceList() {
        return "/trace/traceList";
    }

    @RequestMapping("/show")
    @ResponseBody
    public List<Score>  findById(Model model){
        List<Score> scores = scoreService.getAll();
        System.err.println(scores.toString());
        return scores;
    }

//    @RequestMapping("/getDynamicList")
//    @ResponseBody
//    public List<Score> getDynamicList(){
//
//        ArrayList<Score> dynamicArrayList = new ArrayList<Score>();
//        Score scorea= new Score();
//        scorea.setId(2);
//        scorea.setScore1(55);
//        scorea.setScore2(56);
//        scorea.setScore3(66);
//        scorea.setScore4(67);
//        scorea.setScore5(77);
//        scorea.setScore6(78);
//
//        dynamicArrayList.add(scorea);
//
//        return dynamicArrayList;
//
//    }

    @RequestMapping("/getTraceList")
    @ResponseBody
    public Object getScoreList(@RequestParam(value = "page", defaultValue = "1")Integer page,
                               @RequestParam(value = "rows", defaultValue = "100")Integer rows,
                               @RequestParam(value = "studentid", defaultValue = "0")String studentid,
                               String from, HttpSession session){
        Map<String,Object> paramMap = new HashMap();
        paramMap.put("pageno",page);
        paramMap.put("pagesize",rows);
        if(!studentid.equals("0"))  paramMap.put("studentid",studentid);

        //判断是老师还是学生权限
        Student student = (Student) session.getAttribute(Const.STUDENT);
        if(!StringUtils.isEmpty(student)){
            //是学生权限，只能查询自己的信息
            paramMap.put("studentid",student.getId());
        }
        PageBean<Score> pageBean = scoreService.queryPage(paramMap);
        if(!StringUtils.isEmpty(from) && from.equals("combox")){
            return pageBean.getDatas();
        }else{
            Map<String,Object> result = new HashMap();
            result.put("total",pageBean.getTotalsize());
            result.put("rows",pageBean.getDatas());
            return result;
        }
    }




}