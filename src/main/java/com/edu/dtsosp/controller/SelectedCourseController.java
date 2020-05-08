package com.edu.dtsosp.controller;

import com.edu.dtsosp.domain.SelectedCourse;
import com.edu.dtsosp.domain.Student;
import com.edu.dtsosp.service.SelectedCourseService;
import com.edu.dtsosp.util.AjaxResult;
import com.edu.dtsosp.util.Const;
import com.edu.dtsosp.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/selectedCourse")
public class SelectedCourseController {

    @Autowired
    private SelectedCourseService selectedCourseService;



    @GetMapping("/selectedCourse_list")
    public String selectedCourseList(){
        return "course/selectedCourseList";
    }

    /**
     * 异步加载选课信息列表
     * @param page
     * @param rows
     * @param studentid
     * @param courseid
     * @param from
     * @return
     */
    @PostMapping("/getSelectedCourseList")
    @ResponseBody
    public Object getClazzList(@RequestParam(value = "page", defaultValue = "1")Integer page,
                               @RequestParam(value = "rows", defaultValue = "100")Integer rows,
                               @RequestParam(value = "userid", defaultValue = "0")String studentid,
                               @RequestParam(value = "courseid", defaultValue = "0")String courseid ,String from,HttpSession session){
        Map<String,Object> paramMap = new HashMap();
        paramMap.put("pageno",page);
        paramMap.put("pagesize",rows);
        if(!studentid.equals("0"))  paramMap.put("studentId",studentid);
        if(!courseid.equals("0"))  paramMap.put("courseId",courseid);
        //判断是老师还是学生权限
        Student student = (Student) session.getAttribute(Const.STUDENT);
        if(!StringUtils.isEmpty(student)){
            //是学生权限，只能查询自己的信息
            paramMap.put("studentid",student.getId());
        }
        PageBean<SelectedCourse> pageBean = selectedCourseService.queryPage(paramMap);
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
