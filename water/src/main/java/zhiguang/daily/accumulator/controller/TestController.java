package zhiguang.daily.accumulator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestController {


    @RequestMapping(value = "a",method = RequestMethod.GET)
    @ResponseBody
    public String getSomething(){
        return "xyz";
    }
}
