package com.lym.springbootmybatis.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lym.springbootmybatis.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.lym.springbootmybatis.pojo.Category;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryMapper categoryMapper;

    @RequestMapping("/listCategory")
    public String listCategory(Model model,@RequestParam(value="start",defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
        PageHelper.startPage(start, size,"id desc");
        List<Category> cs = categoryMapper.findAll();
        PageInfo<Category> categoryPageInfo = new PageInfo<>(cs);
        model.addAttribute("page", categoryPageInfo);
        return "listCategory";
    }


    @RequestMapping("/addCategory")
    public String listCategory(Category c) throws Exception{
        categoryMapper.save(c);
        return "redirect:listCategory";
    }

    @RequestMapping("/deleteCategory")
    public String deleteCategory(Category c) throws Exception{
        categoryMapper.delete(c.getId());
        return "redirect:listCategory";
    }

    @RequestMapping("/updateCategory")
    public String updateCategory(Category c) throws Exception {
        categoryMapper.update(c);
        return "redirect:listCategory";
    }

    @RequestMapping("/editCategory")
    public String listCategory(int id,Model model)throws Exception {
        Category category = categoryMapper.get(id);
        model.addAttribute("c", category);
        return "editCategory";
    }

}
