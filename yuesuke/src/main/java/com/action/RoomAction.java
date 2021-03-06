package com.action;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.action
 * @author dengchao
 * @date 2018/5/12 16:07
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.Room;
import com.domain.Students;
import com.opensymphony.xwork2.ActionContext;
import com.service.RoomService;
import com.service.StudentsService;
import com.util.base.BaseAction;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dengchao
 * @ClassName RoomAction
 * @Description 信息管理-宿舍信息
 * @date 2018/5/12
 */
@Action(value = "room")
@Results({
        @Result(name = "room",location = "/jsp/roomPage.jsp"),
        @Result(name = "roomAddPage",location = "/jsp/roomAddPage.jsp"),
        @Result(name = "roomUpdatePage",location = "/jsp/roomUpdatePage.jsp"),
        @Result(name = "404",location = "/jsp/404.jsp"),
        @Result(name = "failed",location = "/jsp/failed.jsp")
})
public class RoomAction extends BaseAction {
    @Autowired
    private RoomService roomService;
    @Autowired
    private StudentsService studentsService;

    private List<Room> roomList;

    private String roomArea;
    private String toUpRoomId;

    private String stuToRoomId;
    private String method;
    private String delRoomId;
    private String stuIdNum;

    HttpServletRequest request= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);

    /**
     * @Title: roomShow
     * @Description: 信息管理-宿舍信息
     * @author dengchao
     * @date 2018/5/12
     */
    public String roomShow() throws UnsupportedEncodingException {
        //设置请求/响应编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        Map<String,Object> mapRoom=new HashMap<String, Object>();
        if (this.roomArea != null && !("".equals(this.roomArea))) {
            mapRoom.put("AREA", this.roomArea);
        }else if (toUpRoomId != null){
            mapRoom.put("ROOM_ID",toUpRoomId);
        }else if (stuToRoomId != null){
            mapRoom.put("ROOM_ID",stuToRoomId);
        }
        if (roomService != null){
            roomList=roomService.findByCondition(mapRoom);
            req.setAttribute("roomList",roomList);
        }
        return "room";
    }

    /**
     * @Title: delClass
     * @Description: 删除操作
     * @author dengchao
     * @date 2018/5/13
     */
    public void delRoom(){
        Integer rows1=0;
        //接收用户登录成功的身份证号idNumber
        stuIdNum= String.valueOf(request.getSession().getAttribute("stuIdNum"));
        Map<String,Object> mapStu=new HashMap<String, Object>();
        List<Students> studentsList=null;
        Students students=null;
        if (stuIdNum != null){
            mapStu.put("ID_NUMBER",stuIdNum);
        }
        if (studentsService != null){
            studentsList=studentsService.findByCondition(mapStu);
        }
        if (studentsList.size() == 1){
            students=studentsList.get(0);
        }

        //判断登录学生操作权限为 2
        if ("del".equals(this.method) && this.delRoomId != null && students.getAuthority() == 2) {
            if (roomService != null) {
                rows1 = roomService.deleteById(Long.valueOf(this.delRoomId));
            }
        }
    }
    /**
     * @Title: roomAdd
     * @Description: 信息管理-宿舍信息-添加
     * @author dengchao
     * @date 2018/5/13
     */
    public String roomAdd() throws UnsupportedEncodingException {
        //设置请求/响应编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        //接收用户登录成功的身份证号idNumber
        stuIdNum= String.valueOf(request.getSession().getAttribute("stuIdNum"));
        Map<String,Object> mapStu=new HashMap<String, Object>();
        List<Students> studentsList=null;
        Students students=null;
        if (stuIdNum != null){
            mapStu.put("ID_NUMBER",stuIdNum);
        }
        if (studentsService != null){
            studentsList=studentsService.findByCondition(mapStu);
        }
        if (studentsList.size() == 1){
            students=studentsList.get(0);
        }

        String result="roomAddPage";
        Integer rows=0;
        Room room=null;

        String roomAreaAdd=req.getParameter("roomAreaAdd");
        String roomLouDongAdd=req.getParameter("roomLouDongAdd");
        String roomFloorAdd=req.getParameter("roomFloorAdd");
        String roomNumberAdd=req.getParameter("roomNumberAdd");
        String roomAuntieAdd=req.getParameter("roomAuntieAdd");
        String roomStuNumAdd=req.getParameter("roomStuNumAdd");
        String roomEmptyAdd=req.getParameter("roomEmptyAdd");

        //添加宿舍，判断学生操作权限为 2
        if (room == null && students.getAuthority() == 2){
                room=new Room();
                room.setArea(roomAreaAdd);
                room.setStudentsNumber(Integer.valueOf(roomStuNumAdd));
                room.setLoudong(roomLouDongAdd);
                room.setFloorNumber(roomFloorAdd);
                room.setRoomNumber(roomNumberAdd);
                room.setAuntieName(roomAuntieAdd);
                room.setEmptyRoom(Integer.valueOf(roomEmptyAdd));
                if (Integer.valueOf(roomEmptyAdd) > 0){
                    room.setIsFull((byte) 0);
                }else {
                    room.setIsFull((byte) 1);
                }
        }

            if (roomService != null && room != null){
                rows=roomService.save(room);
            }
            if (rows > 0 ){
                result="room";
            }
        return result;
    }

    /**
     * @Title: toRoomUpdate
     * @Description: 信息管理-宿舍信息->修改
     * @author dengchao
     * @date 2018/5/13
     */
    public String toRoomUpdate() throws UnsupportedEncodingException {
        //设置请求/响应编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        Room roomUp=null;
        if (roomService != null && toUpRoomId != null){
            roomUp=roomService.findById(Long.valueOf(toUpRoomId));
            if (roomUp != null){
                req.setAttribute("roomUp",roomUp);
            }
        }
        return "roomUpdatePage";
    }
    /**
     * @Title: roomUpdate
     * @Description: 信息管理-宿舍信息-修改
     * @author dengchao
     * @date 2018/5/13
     */
    public String roomUpdate() throws UnsupportedEncodingException {
        //设置请求/响应编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String result="roomUpdatePage";

        //接收用户登录成功的身份证号idNumber
        stuIdNum= String.valueOf(request.getSession().getAttribute("stuIdNum"));
        Map<String,Object> mapStu=new HashMap<String, Object>();
        List<Students> studentsList=null;
        Students students=null;
        if (stuIdNum != null){
            mapStu.put("ID_NUMBER",stuIdNum);
        }
        if (studentsService != null){
            studentsList=studentsService.findByCondition(mapStu);
        }
        if (studentsList.size() == 1){
            students=studentsList.get(0);
        }

        Integer rows=0;
        Room roomUp=null;

        String roomAreaUp=req.getParameter("roomAreaUp");
        String roomLouDongUp=req.getParameter("roomLouDongUp");
        String roomFlooeUp=req.getParameter("roomFloorUp");
        String roomNumberUp=req.getParameter("roomNumberUp");
        String roomAuntieUp=req.getParameter("roomAuntieUp");
        String roomStuNumUp=req.getParameter("roomStuNumUp");
        String roomEmptyUp=req.getParameter("roomEmptyUp");


        //修改宿舍
        roomUp.setArea(roomAreaUp);
        roomUp.setStudentsNumber(Integer.valueOf(roomStuNumUp));
        roomUp.setLoudong(roomLouDongUp);
        roomUp.setFloorNumber(roomFlooeUp);
        roomUp.setRoomNumber(roomNumberUp);
        roomUp.setAuntieName(roomAuntieUp);
        roomUp.setEmptyRoom(Integer.valueOf(roomEmptyUp));
        if (Integer.valueOf(roomEmptyUp) > 0){
            roomUp.setIsFull((byte) 0);
        }else {
            roomUp.setIsFull((byte) 1);
        }
        //判断登录学生操作权限为 2
        if (roomService != null && students.getAuthority() == 2){
            rows=roomService.update(roomUp);
        }
        if (rows > 0 && roomUp != null){
            result="room";
        }else {
            result="failed";
        }
        return result;
    }


    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDelRoomId() {
        return delRoomId;
    }

    public void setDelRoomId(String delRoomId) {
        this.delRoomId = delRoomId;
    }

    public String getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(String roomArea) {
        this.roomArea = roomArea;
    }

    public String getToUpRoomId() {
        return toUpRoomId;
    }

    public void setToUpRoomId(String toUpRoomId) {
        this.toUpRoomId = toUpRoomId;
    }

    public String getStuToRoomId() {
        return stuToRoomId;
    }

    public void setStuToRoomId(String stuToRoomId) {
        this.stuToRoomId = stuToRoomId;
    }

    public String getStuIdNum() {
        return stuIdNum;
    }

    public void setStuIdNum(String stuIdNum) {
        this.stuIdNum = stuIdNum;
    }
}