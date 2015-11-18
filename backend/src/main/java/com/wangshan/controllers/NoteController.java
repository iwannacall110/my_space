package com.wangshan.controllers;

import com.wangshan.service.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wangshan on 2015/11/18.
 */
@Controller
@RequestMapping("/backend/note")
public class NoteController {
    private static Logger log = LoggerFactory.getLogger(NoteController.class);
    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody       /*��ע��������ǽ����ص�����ֱ��д��h�http response body��*/
    public Object getUser(){
        return noteService.getNotes();
    }
}