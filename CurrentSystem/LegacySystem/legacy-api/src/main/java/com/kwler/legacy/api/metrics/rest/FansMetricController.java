package com.kwler.legacy.api.metrics.rest;

import com.kwler.legacy.api.metrics.model.FactFans;
import com.kwler.legacy.api.metrics.repository.FactFansMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("metric/fans")
public class FansMetricController {

    @Autowired
    FactFansMapper factFansMapper;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public PagedResources<FactFans> showAll() {
        Collection<FactFans> fansmetrics = factFansMapper.findByDate(20170809, 20);

        PagedResources.PageMetadata meta = new PagedResources.PageMetadata(100, 100, 100 , 20);

        return new PagedResources<>(fansmetrics, meta, new Link("http://localhost:17081/metric/fans"));
    }

    @RequestMapping(method = RequestMethod.GET, path = "single")
    @ResponseBody
    public Resource<FactFans> showOne() {
        FactFans f = factFansMapper.findByDate(20170809, 10).get(0);
        return new Resource<>(f, new Link("http://localhost:17081"));
    }
}
