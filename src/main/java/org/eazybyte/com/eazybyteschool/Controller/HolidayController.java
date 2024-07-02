package org.eazybyte.com.eazybyteschool.Controller;

import org.eazybyte.com.eazybyteschool.Model.Holiday;
import org.eazybyte.com.eazybyteschool.Repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class HolidayController {
    public final HolidayRepository holidayRepository;

    public HolidayController(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }


//
//     USING REQUEST PARAMS FOR FILTERING HOLIDAYS ACCORDING TO THE REQUEST PARAMETERS

//    @GetMapping("/holidays")
//    public String holidays(Model model, @RequestParam(required = false) boolean federal, @RequestParam(required = false) boolean festival) {
//        model.addAttribute("federal", federal);
//        model.addAttribute("festival", festival);
//        List<Holiday> holidays = Arrays.asList(
//                new Holiday(" Jan 1 ", "New Year's Day", Holiday.Type.FESTIVAL),
//                new Holiday(" Oct 31 ", "Halloween", Holiday.Type.FESTIVAL),
//                new Holiday(" Nov 24 ", "Thanksgiving Day", Holiday.Type.FESTIVAL),
//                new Holiday(" Dec 25 ", "Christmas", Holiday.Type.FESTIVAL),
//                new Holiday(" Jan 17 ", "Martin Luther King Jr. Day", Holiday.Type.FEDERAL),
//                new Holiday(" July 4 ", "Independence Day", Holiday.Type.FEDERAL),
//                new Holiday(" Sep 5 ", "Labor Day", Holiday.Type.FEDERAL),
//                new Holiday(" Nov 11 ", "Veterans Day", Holiday.Type.FEDERAL)
//        );
//
//        Holiday.Type[] types = Holiday.Type.values();
//        for (Holiday.Type type : types) {
//            model.addAttribute(type.toString(),
//                    holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList()));
//        }
//
//        return "holiday.html";
//    }
//}
////
    @GetMapping("/holidays/{display}")
    public String holidays(Model model, @PathVariable String display) {
        if(null != display && display.equals("all")){
            model.addAttribute("festival",true);
            model.addAttribute("federal",true);
        }else if(null != display && display.equals("federal")){
            model.addAttribute("federal",true);
        }else if(null != display && display.equals("festival")){
            model.addAttribute("festival",true);
        }

//        List<Holiday> holidays = Arrays.asList(
//                new Holiday(" Jan 1 ","New Year's Day", Holiday.Type.FESTIVAL),
//                new Holiday(" Oct 31 ","Halloween", Holiday.Type.FESTIVAL),
//                new Holiday(" Nov 24 ","Thanksgiving Day", Holiday.Type.FESTIVAL),
//                new Holiday(" Dec 25 ","Christmas", Holiday.Type.FESTIVAL),
//                new Holiday(" Jan 17 ","Martin Luther King Jr. Day", Holiday.Type.FEDERAL),
//                new Holiday(" July 4 ","Independence Day", Holiday.Type.FEDERAL),
//                new Holiday(" Sep 5 ","Labor Day", Holiday.Type.FEDERAL),
//                new Holiday(" Nov 11 ","Veterans Day", Holiday.Type.FEDERAL)
//        );

        Iterable<Holiday> holidays = holidayRepository.findAll();
        List<Holiday> holidayList = StreamSupport.stream(holidays.spliterator(), false).collect(Collectors.toList());

        Holiday.Type[] types = Holiday.Type.values();
        for(Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    holidayList.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList()));
        }

        return "holiday.html";
    }
}


