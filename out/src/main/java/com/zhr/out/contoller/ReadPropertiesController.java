package com.zhr.out.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ReadPropertiesController
 * @Date 2020-06-08 16:42
 * @description todo
 **/
@RestController
public class ReadPropertiesController {

    @Autowired
    private Environment env;


}
