package com.xiaoshi.web.controller;

import com.github.pagehelper.PageInfo;
import com.xiaoshi.Constants;
import com.xiaoshi.domain.Type;
import com.xiaoshi.service.iface.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("api/v1/type")
public class TypeController {

    @Resource
    TypeService typeService;

    @RequestMapping("/list/{pageNumber}")
    public ModelAndView getUsersByPage(@PathVariable int pageNumber){
        PageInfo<Type> page=typeService.getTypesByPage(pageNumber, Constants.PAGE_NUMBER);
        ModelAndView mav=new ModelAndView("views/type");
        mav.addObject("page",page);
        return mav;
    }

    @RequestMapping("/search/{id}")
    public @ResponseBody Type searchType(@PathVariable int id){
        Type type=typeService.getTypeById(id);
        return type;
    }
    @RequestMapping("/update")
    public void updateType(Type type,HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        if(typeService.updateType(type)){
            out.println("<script>alert('修改数据成功！');window.location.href='/api/v1/type/list/1'</script>");
        }else{
            out.println("<script>alert('修改数据失败！请稍候再试');window.location.href='/api/v1/type/list/1'</script>");
        }
        out.flush();
        out.close();
    }

    @RequestMapping("/delete/{ids}")
    public void deleteTypes(@PathVariable String ids,HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        if(typeService.deleteTypes(ids)){
            out.println("<script>alert('删除数据成功！');window.location.href='/api/v1/type/list/1'</script>");
        }else{
            out.println("<script>alert('删除数据失败！请稍候再试');window.location.href='/api/v1/type/list/1'</script>");
        }
        out.flush();
        out.close();
    }

    @RequestMapping("/add")
    public void addType(Type type, HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        PageInfo<Type> page=typeService.getTypesByPage(1, Constants.PAGE_NUMBER);
        boolean flag=typeService.addType(type);
        if(flag){
            out.println("<script>alert('新增数据成功！');window.location.href='/api/v1/type/list/1'</script>");
        }else{
            out.println("<script>alert('新增数据失败！请稍候再试');window.location.href='/api/v1/type/list/1'</script>");
        }
        out.flush();
        out.close();
    }
}
