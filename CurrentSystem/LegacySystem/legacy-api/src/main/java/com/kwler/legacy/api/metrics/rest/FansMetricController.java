package com.kwler.legacy.api.metrics.rest;

import com.kwler.legacy.api.metrics.model.FactFans;
import com.kwler.legacy.api.metrics.repository.FactFansMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("metric/fans")
public class FansMetricController {

    @Autowired
    FactFansMapper factFansMapper;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<FactFans> showAll() {
        return factFansMapper.findByDate(20170809, 10);
    }
}
