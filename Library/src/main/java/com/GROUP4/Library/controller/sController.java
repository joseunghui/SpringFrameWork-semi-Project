package com.GROUP4.Library.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.GROUP4.Library.dto.Spot;
import com.GROUP4.Library.service.sService;

@Controller
public class sController {
	
	@Autowired
	private sService ssvc;
	
	@Autowired
	private HttpSession session;
	
	private ModelAndView mav = new ModelAndView();
		
	// �ش� �¼��� �̿� �ð��밡 �����ϸ� �� �ð����� �¼��� ��� "empty�� ����"
	// S_mTimeOver : 13�ú��� ����
	@RequestMapping(value = "/S_mTimeOver")
	public @ResponseBody int mTimeOver(@RequestParam("hours") String hours) {
		int result = ssvc.mTimeOver(hours);
		return result;
	}
	// S_aTimeOver : 17�ú��� ����
	@RequestMapping(value = "/S_aTimeOver")
	public @ResponseBody int aTimeOver(@RequestParam("hours") String hours) {
		int result = ssvc.aTimeOver(hours);
		return result;
	}
	// S_eTimeOver : 21�ú��� ����
	@RequestMapping(value = "/S_eTimeOver")
	public @ResponseBody int eTimeOver(@RequestParam("hours") String hours) {
		int result = ssvc.eTimeOver(hours);
		return result;
	}
	
	
	// S_reservForm : ������ �¼� ���� �������� �̵�
	@RequestMapping(value = "/S_reservForm", method = RequestMethod.GET)
	public String sReservForm() {
		return "S_Reserv";
	}	
	
	
	// S_Reservation : �¼� �� ��������
	@RequestMapping(value="/S_Reservation", method = RequestMethod.POST)
	public @ResponseBody String sReservNo(@RequestParam("SNo") String SNo) {
		String result = ssvc.sReservNo(SNo);
		return result;
	}
	
	// �¼� �̿밡�� Ȯ��!
	// S_mtimeCheck : �ش� �¼��� 8-12 �ð��� �̿밡������ Ȯ��
	@RequestMapping(value="/S_mtimeCheck", method = RequestMethod.POST)
	public @ResponseBody String mtimeCheck(@RequestParam("SNo") String SNo, @RequestParam("MId") String MId) {
		String result = ssvc.mtimeCheck(SNo, MId);
		return result;
	}
	// S_atimeCheck : �ش� �¼��� 12-16 �ð��� �̿밡������ Ȯ��
	@RequestMapping(value="/S_atimeCheck", method = RequestMethod.POST)
	public @ResponseBody String atimeCheck(@RequestParam("SNo") String SNo, @RequestParam("MId") String MId) {
		String result = ssvc.atimeCheck(SNo, MId);
		return result;
	}
	// S_etimeCheck : �ش� �¼��� 16-20 �ð��� �̿밡������ Ȯ��
	@RequestMapping(value="/S_etimeCheck", method = RequestMethod.POST)
	public @ResponseBody String etimeCheck(@RequestParam("SNo") String SNo, @RequestParam("MId") String MId) {
		String result = ssvc.etimeCheck(SNo, MId);
		return result;
	}
	
	
	// S_reserv�ش�ð� : redirect�� ���� ���̵�, �¼���ȣ�� ���� �Ϸ��ϱ�
	// S_reservMTime
	@RequestMapping(value="/S_reservMTime", method = RequestMethod.GET)
	public String reservMTime(@RequestParam("SNo") String SNo, @RequestParam("MId") String MId) {
		String result = ssvc.reservMTime(SNo, MId);
		return result;	
	}
	// S_reservATime
	@RequestMapping(value="/S_reservATime", method = RequestMethod.GET)
	public String reservATime(@RequestParam("SNo") String SNo, @RequestParam("MId") String MId) {
		String result = ssvc.reservATime(SNo, MId);
		return result;	
	}
	// S_reservETime
	@RequestMapping(value="/S_reservETime", method = RequestMethod.GET)
	public String reservETime(@RequestParam("SNo") String SNo, @RequestParam("MId") String MId) {
		String result = ssvc.reservETime(SNo, MId);
		return result;	
	}
	
	// M_View ���� ����
	// S_myTime : �� ���� ��Ȳ ��ȸ( �¼� ��ȣ�� �ð��� ���θ� List�� �޾ƿ���)
	@RequestMapping(value="/S_myTime", method = RequestMethod.POST)
	public @ResponseBody List<Spot> sMyTime(@RequestParam("MId") String MId) {
		List<Spot> spotList = ssvc.myReserv(MId);
		return spotList;
	}
	// S_reservDelete : �� ���� ��Ȳ ��ȸ���� ���� ��� ��ư�� ������ �ش� ������ ����ϱ�
	@RequestMapping(value="/S_reservDelete")
	public ModelAndView reservDel(@RequestParam("MId") String MId) {
		mav = ssvc.reservDel(MId);
		return mav;	
	}
	

}
