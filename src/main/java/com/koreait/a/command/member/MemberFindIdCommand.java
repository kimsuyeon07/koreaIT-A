package com.koreait.a.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.a.dao.MemberDAO;
import com.koreait.a.dto.MemberDTO;

public class MemberFindIdCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String email = request.getParameter("email");
		
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		MemberDTO findUser = memberDAO.findId(email);
		
		if (findUser != null) {
			model.addAttribute("findUser", findUser);  // 검색결과를 표시할 JSP로 전달하기 위해서
		}
	}
}
