package com.example;

import com.example.dao.UserDAO;
import com.example.vo.CalendarVO;
import com.example.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String Calendarlist(Model model, Model model2) {
        model.addAttribute("list", CalendarService.getCalendarList());
        String userName = UserVO.getUsername();
        model2.addAttribute("userName", userName);
        return "Calendar/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPost(Model model) {
        String userName = UserVO.getUsername();
        model.addAttribute("userName", userName);
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
    public String editPost(@PathVariable("id") int id, Model model, Model model2) {
        CalendarVO CalendarVO = CalendarService.getCalendar(id);
        model.addAttribute("u", CalendarVO);
        String userName = UserVO.getUsername();
        model2.addAttribute("userName", userName);
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

    @RequestMapping(value="/likeCalendar/{id}", method = RequestMethod.GET)
    public String likeCalendar(@PathVariable("id") int id) {
        if (CalendarService.likeCalendar(id) == 0)
            System.out.println("추천 수정 실패 ");
        else
            System.out.println("추천 수정 성공");
        return "redirect:../list";
    }

    @RequestMapping(value="/dislikeCalendar/{id}", method = RequestMethod.GET)
    public String dislikeCalendar(@PathVariable("id") int id) {
        if (CalendarService.dislikeCalendar(id) == 0)
            System.out.println("비추천 수정 실패 ");
        else
            System.out.println("비추천 수정 성공");
        return "redirect:../list";
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
