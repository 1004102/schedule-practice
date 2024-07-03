package com.sparta.schedulepractice.dto;

import com.sparta.schedulepractice.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class ScheduleResponseDto {

    private Long id;
    private String title;
    private String contents;
    private String manager;
    private LocalDateTime createdAt;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.manager = schedule.getManager();
        this.createdAt = schedule.getCreatedAt();
    }
}
