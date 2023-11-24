package com.zhr.wps.pdf.bean;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author jing.zhang31
 * @ClassName Text
 * @description: TODO
 * @date 2023年08月31日
 * @version: 1.0
 */
@Data
@Builder
public class Text {

    private Integer pageIndex;

    private String originText;

    private String compareText;

    private String diffType;

    private List<String> autoOriginTextList;

    private List<String> autoCompareTextList;

    private Integer originTotalHeight;

    private Integer compareTotalHeight;

    private boolean originTextMoreHigher;

}
