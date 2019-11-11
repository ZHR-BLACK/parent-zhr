package com.zhr;

import com.jfinal.core.Controller;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName HelloController
 * @Date 2019-11-07 13:59
 * @description todo
 **/
public class HelloController extends Controller {

    public void index() {
        renderText("Hello JFinal World.");
    }
}
