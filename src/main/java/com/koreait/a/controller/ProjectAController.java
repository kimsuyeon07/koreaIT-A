package com.koreait.a.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.a.command.fBoard.FBoardDeleteCommand;
import com.koreait.a.command.fBoard.FBoardDropListCommand;
import com.koreait.a.command.fBoard.FBoardInsertCommand;
import com.koreait.a.command.fBoard.FBoardListCommand;
import com.koreait.a.command.fBoard.FBoardSearchListCommand;
import com.koreait.a.command.fBoard.FBoardUpdateCommand;
import com.koreait.a.command.fBoard.FBoardViewCommand;
import com.koreait.a.command.fReply.FReplyDeleteCommand;
import com.koreait.a.command.fReply.FReplyInsertCommand;
import com.koreait.a.command.fReply.FReplyListCommand;
import com.koreait.a.command.notice.NoticeDeleteCommand;
import com.koreait.a.command.notice.NoticeInsertCommand;
import com.koreait.a.command.notice.NoticeUpdateCommand;
import com.koreait.a.command.notice.NoticeViewCommand;
import com.koreait.a.command.notice.NoticeListCommand;

@Controller
public class ProjectAController {

	// field
	private SqlSession sqlSession;
	private NoticeListCommand selectNoticeListCommand;
	private NoticeViewCommand noticeViewCommand;
	private NoticeUpdateCommand noticeUpdateCommand;
	private NoticeDeleteCommand noticeDeleteCommand;
	private NoticeInsertCommand noticeInsertCommand;
	private FBoardListCommand fBoardListCommand;
	private FBoardInsertCommand fBoardInsertCommand;
	private FBoardViewCommand fBoardViewCommand;
	private FBoardUpdateCommand fBoardUpdateCommand;
	private FBoardDeleteCommand fBoardDeleteCommand;
	private FBoardSearchListCommand FBoardSearchListCommand;
	private FBoardDropListCommand fBoardDropListCommand;
	private FReplyListCommand fReplyListCommand;
	private FReplyInsertCommand fReplyInsertCommand;
	private FReplyDeleteCommand fReplyDeleteCommand;
	
	
	// constructor
	@Autowired
	public ProjectAController(SqlSession sqlSession,
						      NoticeListCommand selectNoticeListCommand,
						      NoticeViewCommand noticeViewCommand,
						      NoticeUpdateCommand noticeUpdateCommand,
						      NoticeDeleteCommand noticeDeleteCommand,
						      NoticeInsertCommand noticeInsertCommand,
						      FBoardListCommand fBoardListCommand,
						      FBoardInsertCommand fBoardInsertCommand,
						      FBoardViewCommand fBoardViewCommand,
						      FBoardUpdateCommand fBoardUpdateCommand,
						      FBoardDeleteCommand fBoardDeleteCommand,
						      FBoardSearchListCommand FBoardSearchListCommand,
						      FBoardDropListCommand fBoardDropListCommand,
						      FReplyListCommand fReplyListCommand,
						      FReplyInsertCommand fReplyInsertCommand,
						      FReplyDeleteCommand fReplyDeleteCommand) {
		super();
		this.sqlSession = sqlSession;
		this.selectNoticeListCommand = selectNoticeListCommand;
		this.noticeViewCommand = noticeViewCommand;
		this.noticeUpdateCommand = noticeUpdateCommand;
		this.noticeDeleteCommand = noticeDeleteCommand;
		this.noticeInsertCommand = noticeInsertCommand;
		this.fBoardListCommand = fBoardListCommand;
		this.fBoardInsertCommand = fBoardInsertCommand;
		this.fBoardViewCommand =  fBoardViewCommand;
		this.fBoardUpdateCommand = fBoardUpdateCommand;
		this.fBoardDeleteCommand = fBoardDeleteCommand;
		this.FBoardSearchListCommand = FBoardSearchListCommand;
		this.fBoardDropListCommand = fBoardDropListCommand;
		this.fReplyListCommand = fReplyListCommand;
		this.fReplyInsertCommand = fReplyInsertCommand;
		this.fReplyDeleteCommand = fReplyDeleteCommand;
	}
	
	/*
	/* index ?????? 
	@GetMapping(value= {"/", "index.do"})
	public String index() {
		return "index" ;
	}
	*/
	
	
	// -----------------------------------------------------
	
	
	/* ???????????? ????????? */
	@GetMapping(value="noticePage.do")
	public String noticePage() {
		return "notice/notice";
	}
	
	/* ???????????? ????????? ??????(ajax) */
	@GetMapping(value="noticeList.do",  produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> noticeList(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		return selectNoticeListCommand.execute(sqlSession, model);
	}
	
	/*???????????? ??????*/
	@GetMapping(value="noticeView.do")
	public String noticeView(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		noticeViewCommand.execute(sqlSession, model);
		return "notice/noticeView";
	}
	
	/*???????????? ??????*/
	@GetMapping(value="noticeUpdatePage.do")
	public String noticeUpdatePage(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		noticeViewCommand.execute(sqlSession, model);
		return "notice/noticeUpdate";
	}
	@PostMapping(value="noticeUpdate.do") 
	public void noticeUpdate(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		noticeUpdateCommand.execute(sqlSession, model);
	}
	
	/*???????????? ??????*/
	@GetMapping(value="noticeDelete.do")
	public void noticeDelete(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		noticeDeleteCommand.execute(sqlSession, model);
	}
	
	/*???????????? ??? ??? ????????? ??????*/
	@GetMapping(value="noticeInsertPage.do")
	public String noticeInsert(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		return "notice/noticeInsert";
	}
	@PostMapping(value="noticeInsert.do")
	public void noticeInsert(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		noticeInsertCommand.execute(sqlSession, model);
	}
	
	// -----------------------------------------------------
	
	
	
	/* ???????????????  ????????? */
	@GetMapping(value="fBoardPage.do")
	public String fBoardPage() {
		return "fBoard/fBoard";
	}
	
	/* ??????????????? ????????? ??????(ajax) */
	@GetMapping(value="fBoardList.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> fBoardList(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		return fBoardListCommand.execute(sqlSession, model);
	}
	
	
	/*??????????????? ?????? ??????*/
	@GetMapping(value="fBoardInsertPage.do")
	public String fBoardInsertPage() {
		return "fBoard/fBoardInsert";
	}
	@PostMapping(value="fBoardInsert.do")
	public void noticeInsert(MultipartHttpServletRequest multipartRequest, HttpServletResponse response, Model model) {
		model.addAttribute("multipartRequest", multipartRequest);
		model.addAttribute("response", response);
		fBoardInsertCommand.execute(sqlSession, model);
	}
	
	/*??????????????? ?????? ??????*/
	@GetMapping(value="fBoardView.do")
	public String fBoardView(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		fBoardViewCommand.execute(sqlSession, model);
		return "fBoard/fBoardView";
	}
	
	/*??????????????? ?????? ?????????*/
	@GetMapping(value="fBoardUpdatePage.do")
	public String fBoardUpdatePage(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		fBoardViewCommand.execute(sqlSession, model);
		return "fBoard/fBoardUpdate";
	}
	@PostMapping(value="fBoardUpdate.do") 
	public void fBoardUpdate(MultipartHttpServletRequest multipartRequest, HttpServletResponse response, Model model) {
		model.addAttribute("multipartRequest", multipartRequest);
		model.addAttribute("response", response);
		fBoardUpdateCommand.execute(sqlSession, model);
	}
	
	/*??????????????? ??????*/
	@GetMapping(value="fBoardDelete.do")
	public void fBoardDelete(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		fBoardDeleteCommand.execute(sqlSession, model);
	}
	
	/*??????????????? ????????????*/
	@GetMapping(value="searchFBoard.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> searchFBoard(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		return FBoardSearchListCommand.execute(sqlSession, model);
	}

	/*??????????????? ???????????? ?????? ??????*/
	@GetMapping(value="fBoardAutoDrop.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> fBoardAutoDrop(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		return fBoardDropListCommand.execute(sqlSession, model);
	}
	
	
	// -----------------------------------------------------


	/*?????? mapping*/
	
	/*?????? ????????? ??????*/
	@GetMapping(value="fReplyList.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> fReplyList(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		return fReplyListCommand.execute(sqlSession, model);
	}
	
	/* ?????? ?????? */
	@PostMapping(value="fReplyInsert.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> fReplyInsert(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		return fReplyInsertCommand.execute(sqlSession, model);
	}

	/* ?????? ?????? */
	@GetMapping(value="fReplyDelete.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> fReplyDelete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		return fReplyDeleteCommand.execute(sqlSession, model);
	}





	// --------------------------------------------------------------------------------------
	
	/* ?????? ?????? ?????? ??????  */
	@GetMapping(value="storeExist.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> storeExist(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		return fReplyDeleteCommand.execute(sqlSession, model);
	}





















}

