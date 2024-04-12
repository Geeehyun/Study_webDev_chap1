package org.fullstack4.chap1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BbsDTO {
    // @Data 어노테이션에는 Getter/Setter/ToString 까지 포함되어있음.
    // @NoArgsConstructor / @AllArgsConstructor 생성자 생성 필요 시 lombok 이 알아서 해줌.
    private int idx;
    private String user_id;
    private String title;
    private String content;
    private String display_date;
    private LocalDate reg_date;
    private LocalDate modify_date;
    private int readCnt;
}
