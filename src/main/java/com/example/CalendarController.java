package com.example;

import com.example.vo.CalendarVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/Calendar")
public class CalendarController {

    @Autowired
    CalendarServiceImpl CalendarService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String Calendarlist(Model model) {
        model.addAttribute("list", CalendarService.getCalendarList());
        return "Calendar/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPost() {
        return "Calendar/addpostform";
    }

    @RequestMapping(value = "/addok", method = RequestMethod.POST)
    public String addPostOk(CalendarVO vo) {
        if (CalendarService.insertCalendar(vo) == 0)
            System.out.println("데이터 추가 실패 ");
        else
            System.out.println("데이터 추가 성공");
        return "redirect:list";
    }

    @RequestMapping(value = "/editform/{id}", method = RequestMethod.GET)
    public String editPost(@PathVariable("id") int id, Model model) {
        CalendarVO CalendarVO = CalendarService.getCalendar(id);
        model.addAttribute("u", CalendarVO);
        return "Calendar/editform";
    }

    @RequestMapping(value = "/editok", method = RequestMethod.POST)
    public String editPostOk(CalendarVO vo) {
        if (CalendarService.updateCalendar(vo) == 0)
            System.out.println("데이터 수정 실패 ");
        else
            System.out.println("데이터 수정 성공");
        return "redirect:list";
    }

    @RequestMapping(value = "/deleteok/{id}", method = RequestMethod.GET)
    public String deletePostOk(@PathVariable("id") int id) {
        if (CalendarService.deleteCalendar(id) == 0)
            System.out.println("데이터 삭제 실패 ");
        else
            System.out.println("데이터 삭제 성공");
        return "redirect:../list";
    }
}
