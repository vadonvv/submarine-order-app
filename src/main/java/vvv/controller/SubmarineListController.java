package vvv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vvv.domain.Submarine;
import vvv.domain.SubmarineList;

@Controller
public class SubmarineListController {

    @Autowired
    @Qualifier("1")
    SubmarineList submarineList;

    @GetMapping("/")
    public String printList(Model model) {
        model.addAttribute("submarineList",submarineList);
        return "SubList";
    }

    @GetMapping("/add")
    public String addSubmarine(Model model,
                               @RequestParam(name = "name", required = true)  String name) {
        submarineList.addSubmarine(new Submarine(name)); //TODO move to service
        model.addAttribute("submarineList",submarineList);
        return "SubList";
    }

    @GetMapping("/patchSub")
    public String editSubmarine(Model model,
                                @RequestParam(name = "index", required = true)  int index,
                                @RequestParam(name = "name", required = false)  String name) {
        //TODO move to service
        Submarine sub = submarineList.getByIndex(index);
        if(name!=null){
            sub.setName(name);
        }
        model.addAttribute("submarine",sub);
        model.addAttribute("index",index);
        return "SubDetails";
    }
    @GetMapping("/removePart")
    public String removePart(Model model,
                                @RequestParam(name = "subIndex", required = true)  int subIndex,
                                @RequestParam(name = "partIndex", required = true)  int partIndex) {
        //TODO move to service
        Submarine sub = submarineList.getByIndex(subIndex);
        submarineList.getByIndex(subIndex).removePart(partIndex);

        model.addAttribute("submarine",sub);
        model.addAttribute("index",subIndex);
        return "SubDetails";
    }

}
