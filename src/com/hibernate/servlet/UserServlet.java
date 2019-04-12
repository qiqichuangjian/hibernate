package com.hibernate.servlet;

import com.hibernate.dao.UserDao;
import com.hibernate.dao.UserDaoImpl;
import com.hibernate.entity.User;
import com.hibernate.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Acthor:孙琪; date:2019/4/11;
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    UserService service=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        System.out.println(action);
        if ("query".equals(action)) {
            query(request, response);//不用
        } else if ("add".equals(action)) {
            add(request, response);
        } else if ("update".equals(action)) {
            update(request, response);
        } else if ("delete".equals(action)) {
            delete(request, response);
        } else if ("queryOne".equals(action)) {
            queryOne(request, response);
        }else if ("queryPage".equals(action)) {
            queryPage(request, response);
        }
    }
    //！！！在没有分页时用
    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> Users = service.findAll();
        request.setAttribute("Users",Users);
        request.getRequestDispatcher("/user.jsp").forward(request,response);
    }

    private void queryPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //页码
        int pageIndex =1; // 初始页码
        // 获取参数
        String index = request.getParameter("pageIndex");
        if(index!=null){
            pageIndex=Integer.parseInt(index);
        }
        // 每页条数
        int pageCount = 5;
        UserDao dao  =  new UserDaoImpl();
        int pages = dao.pages(pageCount);
        List<User> users = dao.queryPageUser(pageIndex, pageCount);
        request.setAttribute("pages",pages);
        request.setAttribute("users",users);
        request.getRequestDispatcher("/user.jsp").forward(request,response);
    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        int num = service.add(new User(name, sex, Integer.parseInt(age)));
        if(num>0){
            System.out.println("add success!");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }else{
            System.out.println("add fail!");
        }
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        int num = service.update(new User(Integer.parseInt(id), name, sex, Integer.parseInt(age)));
        if(num>0){
            System.out.println("update success!");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }else{
            System.out.println("update fail!");
        }
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        User user = service.findUserById(Integer.parseInt(id));
        if (user != null) {
            System.out.println("根据id查询成功");
            int num=service.delete(user);
            if(num>0){
                System.out.println("delete success!!");
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }else{
                System.out.println("delete success!!");

            }
        } else {
            System.out.println("根据id查询失败!");
        }
    }
    protected void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        User userById = service.findUserById(Integer.parseInt(id));
        if(userById!=null){
            System.out.println("根据id查询到对象");
            request.setAttribute("userById", userById);
            request.getRequestDispatcher("/update.jsp").forward(request, response);
        }else{
            System.out.println("没有根据id查询到对象");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
