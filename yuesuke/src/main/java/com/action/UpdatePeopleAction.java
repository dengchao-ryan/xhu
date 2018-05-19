package com.action;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.action
 * @author dengchao
 * @date 2018/4/28 13:24
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.People;
import com.service.PeopleService;
import com.util.base.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dengchao
 * @ClassName UpdatePeopleAction
 * @Description 类描述
 * @date 2018/4/28
 */
@Action(value = "updatePeopleAction")
@Results({
        @Result(name = "adminUser",location = "/jsp/administrator_page.jsp")
})
//@AllowedMethods({"updatePeople"})
public class UpdatePeopleAction extends BaseAction {
    @Autowired
    private PeopleService peopleService;

    /**
     * @Title: updatePeople
     * @Description: 修改人员信息
     * @author dengchao
     * @date 2018/4/28
     * @throw YnCorpSysException
     * @return: String
     */

    public String updatePeople(){
        //设置编码方式
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("utf-8");
        //获取人员信息
//        String idString=req.getParameter("peopleId");
        Long id=Long.valueOf(req.getParameter("peopleId"));
        String name=req.getParameter("name");
        String cardId=req.getParameter("cardId");
        String sex=req.getParameter("sex");
        Integer age=Integer.valueOf(req.getParameter("age"));
        Double money=Double.valueOf(req.getParameter("money"));
        String address=req.getParameter("address");
        String userName=req.getParameter("username");
        String password=req.getParameter("password");
        //生成人员对象
        People people=new People();
        people.setId(id);
        people.setName(name);
        people.setCardId(cardId);
        people.setSex(sex);
        people.setAge(age);
        people.setMoney(money);
        people.setAddress(address);
        people.setUsreName(userName);
        people.setPassWord(password);
        //获取peopleService
//        PeopleService peopleService= (PeopleService) SpringContextUtil.getBean("peopleService");
        //更新人员信息
        peopleService.updatePeople(people);
        //更新peopleList信息
        List<People> peopleList=new ArrayList<People>();
        HttpSession session=req.getSession();
        peopleList=peopleService.getAllPeople();
        session.removeAttribute("peopleList");
        session.setAttribute("peopleList",peopleList);
        return "adminUser";
    }
}