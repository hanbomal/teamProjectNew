package calendar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.ibatis.session.SqlSession;

import util.MybatisConnector;

public class CalendarDAO extends MybatisConnector{
	private final String namespace = "cal.mybatis";
	private static CalendarDAO instance = new CalendarDAO();
	private CalendarDAO() {}
	
	public static CalendarDAO getInstance() {
		return instance;
	}
	
	SqlSession sqlSession;
	
	
	public List getCalendarList(int studynum) {
		
		sqlSession=sqlSession();
		Map map=new HashMap();
		map.put("studynum", studynum);
		
		List li=null;
		li=sqlSession.selectList(namespace+".getCalendarList",map);
		sqlSession.close();
		
		return li;
		
	}
	
	public int updateCalendar(CalendarVO calendar) {
		sqlSession=sqlSession();
		int ck=-1;
		ck=sqlSession.update(namespace+".updateCalendar",calendar);
		sqlSession.commit();
		sqlSession.close();
		return ck;

	}
	
	public void addCalendar(CalendarVO calendar) {
		sqlSession=sqlSession();
		int num=0;
		num=sqlSession.selectOne(namespace+".getNextNumber");
		calendar.setNum(num);
		sqlSession.insert(namespace+".addCalendar",calendar);
		sqlSession.commit();
		sqlSession.close();
		
	}
	
	
}
