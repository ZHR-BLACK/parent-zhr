package com.zhr.wps.pdf.bean;

import lombok.Builder;
import lombok.Data;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

/**
 * @author jing.zhang31
 * @ClassName TeamVariable
 * @description: TODO
 * @date 2023年08月31日
 * @version: 1.0
 */
@Data
@Builder
public class TeamVariable {

    private PDPageContentStream stream;

    private float y;

    private Integer pageIndex;

}
