package com;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
1. SimpleController extends HttpServlet 
>> SimpleController  HttpServlet 파일을 상속하고 있어요 
>> SimpleController.java >> 웹에 사용되는 객체를 사용가능 >> 일반 자바파일이 아니라 웹용 자바파일(서블릿) 이라 하자

>> HttpServletRequest request = new HttpServletRequest();
>>  

>> HttpServletResponse response = new HttpServletResponse();
>> 객체가 자동 생성 .... response 객체를 가지고 놀 수 있어요

jsp 파일
주소창에 : http://..../default.jsp

servlet
주소창에 : http://..../SimpleController.java ...(x)

web.xml 파일에서 요청 주소를 설저
[어떤 요청 주소가] 들어오면 SimpleController 컴파일 하고 실행할 거냐 ..정의

*/
//@WebServlet("/SimpleController")
public class SimpleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SimpleController() {
        super();
        System.out.println("SimpleController 생성자 함수 실행 : 초기화");
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("클라이언트 요청 : GET");
		
		//JSP 사용했던 방식과 동일
		
		//1. 한글처리
		request.setCharacterEncoding("UTF-8");
		
		//2. 데이터 받기 (회원가입 , 게시판 글쓰기 ,로그아웃)
		String type = request.getParameter("type");
		
		//3. 로직(업무수행) >> 서비스 수행
		Object resultogj = null;
		
		if(type == null || type.equals("greeting")) {
			resultogj = "hollo world!";
		}else if(type.equals("date")) {
			resultogj = new Date();
		}else {
			resultogj = "invalid String type";
		}
		
		//MVC 패턴 흉내 . . . JSP 있는 시절
//		4. JSP (view) 데이터 출력 하려면 >> servlet이 가지고 있는 지원을 >> View에게 전달 (JSP)
//		   결과를 저장 : application , session(scope) , request(scope page한정) 
//		                                                                       객체 저장 (include , forward)
//		   내가 만든 자원이 모든 페이지에서 필요하지 않다면 . . . . request 사용 ...다른 페이지(forward)
		
		request.setAttribute("result", resultogj);
		
		//5. 저장한 결과를 JSP 페이지 전달 (UI 구성)
		//현재 : webapp > simpleview.jsp
		//개발 : webapp → WEB-INF → view → board → board.jsp 
		
		RequestDispatcher dis =  request.getRequestDispatcher("/simpleview.jsp");
		
		dis.forward(request, response); //현재 내가 가지고 있는 request 객체의 주소값을 forward . .  parameter로
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
