package com.sparta.schedulepractice.controller;

import com.sparta.schedulepractice.dto.ScheduleRequestDto;
import com.sparta.schedulepractice.dto.ScheduleResponseDto;
import com.sparta.schedulepractice.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto) {
        return scheduleService.createSchedule(scheduleRequestDto);
    }

    @GetMapping
    public List<ScheduleResponseDto> getSchedules() {
        return scheduleService.getSchedules();
    }

    @GetMapping("/check")
    public List<ScheduleResponseDto> findById(@RequestParam Long id) {
        return scheduleService.findById(id);
    }

    @PutMapping("/{id}")
    public ScheduleResponseDto updateSchedule(@PathVariable Long id,
                                              @RequestBody ScheduleRequestDto scheduleRequestDto) {
        return scheduleService.updateSchedule(id, scheduleRequestDto);
    }
}
