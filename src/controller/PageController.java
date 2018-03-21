package controller;

import java.io.File;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.msk.Action;

import studygroup.RelationDAO;
import studygroup.StudyDAO;
import studygroup.StudyVO;

public class PageController extends Action {

	public String main(HttpServletRequest req, HttpServletResponse res) throws Throwable {
	
		return "/view/main.jsp";
	}
	
	/*public String searchGroup(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		StudyDAO studyDB = StudyDAO.getInstance();
		List li= dbPro.resultList(studyName)
		List li= studyDB.getStudyList();
		//해당 list에 status값 가져오는 쿼리문 필요
	    req.setAttribute("room", li);
		return "/view/searchGroup.jsp";
	}*/
	
	
	
public String about(HttpServletRequest req, HttpServletResponse res) throws Throwable {

		return "/view/about.jsp";
	}


public String study_board(HttpServletRequest req, HttpServletResponse res) throws Throwable {
	
	return "/view/study_board.jsp";
}


public String study_album(HttpServletRequest req, HttpServletResponse res) throws Throwable {
	
	return "/view/study_album.jsp";
}
public String study_making(HttpServletRequest req, HttpServletResponse res) throws Throwable {
	
	return "/view/study_making.jsp";
}
public String makingPro(HttpServletRequest req, HttpServletResponse res) throws Throwable {
	
	String realFolder=""; 
	String encType = "utf-8"; 
	int maxSize= 10*1024*1024; 
	ServletContext context=req.getServletContext();
	realFolder=context.getRealPath("fileSave");
	MultipartRequest multi=null;
	multi=new MultipartRequest(req, realFolder,maxSize,encType,new DefaultFileRenamePolicy());
	Enumeration files=multi.getFileNames();
	
	 String[] filename=new String[2];
     File[] file = new File[2];
     int index=0;
    
	while(files.hasMoreElements()) {
		String name = (String) files.nextElement();
		System.out.println(index+";"+name);
        
		filename[index]=multi.getFilesystemName(name);
        System.out.println(multi.getContentType(name));
        file[index] = multi.getFile(name);
        index++;
	}
	
	StudyVO room = new StudyVO();
	room.setPeopleCount(1);
	room.setLeader("gon");
	room.setStudy_intro(multi.getParameter("study_intro"));
	room.setStudyName(multi.getParameter("studyName"));
	
	if(file[0]!=null){
		room.setStudy_pro(filename[0]);
		room.setProSize((int)file[0].length());
	}else {
		room.setStudy_pro("");
		room.setProSize(0);
	}
	if(file[1]!=null){
		room.setStudy_back(filename[1]);
		room.setBackSize((int)file[1].length());
	}else {
		room.setStudy_back("");
		room.setBackSize(0);
	}
	
	 //filename =0이 background 
    //=1 은 profile
	
    StudyDAO dbPro = StudyDAO.getInstance();
    dbPro.makingStudy(room);
	res.sendRedirect(req.getContextPath()+"/page/main");
	return null; 
}
public String requestJoin(HttpServletRequest req, HttpServletResponse res) throws Throwable {
	String reqNum=req.getParameter("reqNum");
	String studyName=req.getParameter("studyName");
	if(reqNum==null) {
		reqNum="0";
	}
	//reqNum을 받아왔을 때, relation 테이블에 추가
	RelationDAO dbPro = RelationDAO.getInstance();
	if(reqNum.equals("1")) {
		dbPro.requestJoin("gon", studyName);
	}
	String status=dbPro.getStatus("gon", studyName);
	req.setAttribute("status", status);
	res.sendRedirect(req.getContextPath()+"/page/main");
	return null;
}
public String cancelJoin(HttpServletRequest req, HttpServletResponse res) throws Throwable {
	String delNum=req.getParameter("reqNum");
	String studyName=req.getParameter("studyName");
	if(delNum==null) {
		delNum="0";
	}
	//delNum을 받아왔을 때, relation 테이블에 삭제
	RelationDAO dbPro = RelationDAO.getInstance();
	if(delNum.equals("1")) {
		dbPro.cancelJoin("gon", studyName);
	}
	String status=dbPro.getStatus("gon", studyName);
	req.setAttribute("status", status);
	res.sendRedirect(req.getContextPath()+"/page/main");
	return null;
}


}
