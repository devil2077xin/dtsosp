package com.edu.dtsosp.controller;

import com.edu.dtsosp.domain.Score;
import com.edu.dtsosp.domain.Student;
import com.edu.dtsosp.service.ScoreService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;
    @Autowired
    private StudentService studentService;



    @GetMapping("/score_list")
    public String scoreList(){
        return "/score/scoreList";
    }


    /**
     * 异步加载成绩数据列表
     * @param page
     * @param rows
     * @param studentid
     * @param from
     * @param session
     * @return
     */
    @RequestMapping("/getScoreList")
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
            //学生权限，只能查询自己的信息
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


    /**
     * 添加成绩
     * @param score
     * @return
     */
    @PostMapping("/addScore")
    @ResponseBody
    public AjaxResult addScore(Score score){
        AjaxResult ajaxResult = new AjaxResult();
        //判断是否已录入成绩
        if(scoreService.isScore(score)){

            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("已录入，请勿重复录入！");
        }else{
            int count = scoreService.addScore(score);
            if(count > 0){
                ajaxResult.setSuccess(true);
                ajaxResult.setMessage("录入成功");
            }else{
                ajaxResult.setSuccess(false);
                ajaxResult.setMessage("系统错误，请重新录入");
            }
        }
        return ajaxResult;
    }


    /**
     * 修改学生成绩
     * @param score
     * @return
     */
    @PostMapping("/editScore")
    @ResponseBody
    public AjaxResult editScore(Score score){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = scoreService.editScore(score);
            if(count > 0){
                ajaxResult.setSuccess(true);
                ajaxResult.setMessage("修改成功");
            }else{
                ajaxResult.setSuccess(false);
                ajaxResult.setMessage("系统错误，请重新修改");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("系统错误，请重新修改");
        }
        return ajaxResult;
    }

    /**
     * 删除学生成绩
     * @param id
     * @return
     */
    @PostMapping("/deleteScore")
    @ResponseBody
    public AjaxResult deleteScore(Integer id){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = scoreService.deleteScore(id);
            if(count > 0){
                ajaxResult.setSuccess(true);
                ajaxResult.setMessage("删除成功");
            }else{
                ajaxResult.setSuccess(false);
                ajaxResult.setMessage("系统错误，请重新删除");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("系统错误，请重新删除");
        }
        return ajaxResult;
    }

}
