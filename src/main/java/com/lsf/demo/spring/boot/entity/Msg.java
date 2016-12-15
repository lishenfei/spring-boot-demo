package com.lsf.demo.spring.boot.entity;

import lombok.Data;
import lombok.experimental.Builder;

/**
 * Created by lishenfei on 2016-12-15.
 */
@Data
@Builder
public class Msg {

    private String title;
    private String content;
    private String etraInfo;

}
