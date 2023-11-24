package com.zhr.wps.pdf.bean;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author jing.zhang31
 * @ClassName CellText
 * @description: TODO
 * @date 2023年08月31日
 * @version: 1.0
 */
@Data
@Builder
public class CellText {

    private List<String> textList;

    private Integer totalHeight;
}
