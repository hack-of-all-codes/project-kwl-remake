package com.kwler.legacy.api.metrics.rest;

import com.kwler.legacy.api.metrics.dao.FactFanDAO;
import com.kwler.legacy.api.metrics.model.FactFan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("metric/fans")
public class FansMetricController {

    @Autowired
    FactFanDAO factFanDAO;

    @RequestMapping(method = RequestMethod.GET)
    public PagedResources<FactFan> findByArtistAndDate(
            @RequestParam("artist") String artist,
            @RequestParam("date") Integer date,
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size) {

        Page<FactFan> result = factFanDAO.findByArtistAndDate(artist, date, new PageRequest(page, size));
        PagedResources.PageMetadata meta = new PagedResources.PageMetadata(result.getSize(), result.getNumber(), result.getTotalElements());

        List<Link> links = new LinkedList<>();
        links.add(linkTo(methodOn(this.getClass()).findByArtistAndDate(artist, date, page, size)).withSelfRel());

        if (result.hasNext())
        links.add(linkTo(methodOn(this.getClass()).findByArtistAndDate(artist, date, page+1, size)).withRel("next"));

        if (result.hasPrevious())
        links.add(linkTo(methodOn(this.getClass()).findByArtistAndDate(artist, date, page-1, size)).withRel("prev"));

        return new PagedResources<>(result.getContent(), meta, links);
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public PagedResources<FactFan> showAll() {
//        Collection<FactFan> fansmetrics = factFansMapper.findByDate(20170809, 20);
//
//        PagedResources.PageMetadata meta = new PagedResources.PageMetadata(100, 100, 100 , 20);
//
//        return new PagedResources<>(fansmetrics, meta, new Link("http://localhost:17081/metric/fans"));
//    }
//
//    @RequestMapping(method = RequestMethod.GET, path = "single")
//    public Resource<FactFan> showOne() {
//        FactFan f = factFansMapper.findByDate(20170809, 10).get(0);
//        return new Resource<>(f, new Link("http://localhost:17081"));
//    }
}
