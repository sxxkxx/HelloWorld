package co.san.noticeprj;

import java.util.ArrayList;
import java.util.List;

import co.san.miniprj.menu.MainMenu;
import co.san.noticeprj.board.service.BoardService;
import co.san.noticeprj.board.service.BoardVO;
import co.san.noticeprj.board.serviceImpl.BoardServiceImpl;

public class App {
	public static void main(String[] args) {
		
		MainMenu menu = new MainMenu();
		menu.run();
	}
}
