package com.kve.ems.controller;

import com.kve.ems.entity.Emp;
import com.kve.ems.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    /**
     * 查询所有
     * @param model
     * @return
     */
    @GetMapping("/findAll")
    public String findAll(Model model){
        List<Emp> emps = empService.findAll();
        model.addAttribute("emps", emps);
        return "empList";
    }

    /**
     * 增加员工信息
     * @param emp
     * @return
     */
    @PostMapping("/save")
    public String save(Emp emp) {
        empService.save(emp);
        return "redirect:/emp/findAll";
    }

    /**
     * 删除员工信息
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public String delete(String id) {
        empService.delete(id);
//        return "empList"; 如果直接跳转到页面，则不会对列表发起请求，即返回到原页面没有任何查询值（因为原页面本身就是一个接收页面，不会发起请求）
        return "redirect:/emp/findAll";
    }
}
