package com.edu.dtsosp.controller;

import com.edu.dtsosp.domain.Score;
import com.edu.dtsosp.domain.ScoreStats;
import com.edu.dtsosp.domain.Student;
import com.edu.dtsosp.service.CourseService;
import com.edu.dtsosp.service.ScoreService;
import com.edu.dtsosp.service.SelectedCourseService;
import com.edu.dtsosp.service.StudentService;
import com.edu.dtsosp.util.AjaxResult;
import com.edu.dtsosp.util.Const;
import com.edu.dtsosp.util.PageBean;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
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

    @RequestMapping("/getTraceList")
    @ResponseBody
    public Object getTraceList(@RequestParam(value = "studentid", defaultValue = "0") Integer studentid)
    {
        AjaxResult ajaxResult = new AjaxResult();

        Score score=new Score();
        score.setStudentId(studentid);
        List<Score> scoreList = scoreService.getAll(score);

        List<Double> numberList= new ArrayList<Double>();
        numberList.add(0.0);
        numberList.add(0.0);
        numberList.add(0.0);
        numberList.add(0.0);
        numberList.add(0.0);
        numberList.add(0.0);

        List<String> rangeStringList= new ArrayList<String>();
        rangeStringList.add("第一次");
        rangeStringList.add("第二次");
        rangeStringList.add("第三次");
        rangeStringList.add("第四次");
        rangeStringList.add("第五次");
        rangeStringList.add("第六次");

        String studentName= "";

        for(Score sc:scoreList){
            studentName=sc.getStudentName();
            numberList.set(0,sc.getScore1());
            numberList.set(1,sc.getScore2());
            numberList.set(2,sc.getScore3());
            numberList.set(3,sc.getScore4());
            numberList.set(4,sc.getScore5());
            numberList.set(5,sc.getScore6());
        }
        Map<String,Object> resultMap = new HashMap<String, Object>();
        resultMap.put("studentName",studentName);
        resultMap.put("numberList",numberList);
        resultMap.put("rangList",rangeStringList);
        resultMap.put("type","succes");
        return resultMap;
    }

}