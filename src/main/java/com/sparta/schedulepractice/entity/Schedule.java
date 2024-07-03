package com.sparta.schedulepractice.entity;

import com.sparta.schedulepractice.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "schedule")
@NoArgsConstructor
public class Schedule extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String contents;
    private String manager;
    private String password;

    @Builder
    public Schedule(Long id, String title, String contents, String manager, String password) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.manager = manager;
        this.password = password;
        this.setCreatedAt();
    }

    public void update(ScheduleRequestDto scheduleRequestDto) {
        this.title = scheduleRequestDto.getTitle();
        this.contents = scheduleRequestDto.getContents();
        this.manager = scheduleRequestDto.getManager();
        this.password = scheduleRequestDto.getPassword();
    }
}

