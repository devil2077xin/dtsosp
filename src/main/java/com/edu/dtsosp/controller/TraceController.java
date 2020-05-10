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
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

//    @RequestMapping("/getTraceList")
//    @ResponseBody
//    public Object getTraceList()
//    {
//        AjaxResult ajaxResult = new AjaxResult();
//
//        Score score=new Score();
//        List<Score> scoreList = scoreService.getAll(score);
//
//        List<Double> numberList= new ArrayList<Double>();
//        numberList.add(0.0);
//        numberList.add(0.0);
//        numberList.add(0.0);
//        numberList.add(0.0);
//        numberList.add(0.0);
//        numberList.add(0.0);
//
//        List<String> rangeStringList= new ArrayList<String>();
//        rangeStringList.add("第一次");
//        rangeStringList.add("第二次");
//        rangeStringList.add("第三次");
//        rangeStringList.add("第四次");
//        rangeStringList.add("第五次");
//        rangeStringList.add("第六次");
//
//        String studentName= "";
//
//        for(Score sc:scoreList){
//            studentName=sc.getStudentName();
//            numberList.set(0,sc.getScore1());
//            numberList.set(1,sc.getScore2());
//            numberList.set(2,sc.getScore3());
//            numberList.set(3,sc.getScore4());
//            numberList.set(4,sc.getScore5());
//            numberList.set(5,sc.getScore6());
//        }
//        Map<String,Object> resultMap = new HashMap<String, Object>();
//        resultMap.put("studentName",studentName);
//        resultMap.put("numberList",numberList);
//        resultMap.put("rangList",rangeStringList);
//        resultMap.put("type","succes");
//        return resultMap;
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