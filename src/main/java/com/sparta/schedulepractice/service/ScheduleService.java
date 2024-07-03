package com.sparta.schedulepractice.service;

import com.sparta.schedulepractice.dto.ScheduleRequestDto;
import com.sparta.schedulepractice.dto.ScheduleResponseDto;
import com.sparta.schedulepractice.entity.Schedule;
import com.sparta.schedulepractice.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto) {
        Schedule newSchedule = Schedule.builder()
                .title(scheduleRequestDto.getTitle())
                .contents(scheduleRequestDto.getContents())
                .manager(scheduleRequestDto.getManager())
                .password(scheduleRequestDto.getPassword())
                .build();

        scheduleRepository.save(newSchedule);

        return ScheduleResponseDto.builder()
                .id(newSchedule.getId())
                .title(newSchedule.getTitle())
                .contents(newSchedule.getContents())
                .manager(newSchedule.getManager())
                .createdAt(newSchedule.getCreatedAt())
                .build();
    }

    public List<ScheduleResponseDto> getSchedules() {
        List<Schedule> AllSchedules = scheduleRepository.findAll();
        return AllSchedules.stream().map(schedule -> ScheduleResponseDto.builder()
                .id(schedule.getId())
                .title(schedule.getTitle())
                .contents(schedule.getContents())
                .manager(schedule.getManager())
                .createdAt(schedule.getCreatedAt())
                .build())
                .toList();
    }

    public List<ScheduleResponseDto> findById(Long id) {

      /* Optional 목적 : 메소드가 반환할 결과 값이 '없음'을 명백하게 표현할 필요가 있고, null 을 반환하면
         에러가 발생할 가능성이 높은 상황에서 메소드의 반환 타입으로 Optional 을 사용하자는 것이 Optional 을 만든 주된 목적이다.
         Optional 타입의 변수의 값은 절대 null 이어서는 안 되며, 항상 Optional 인스턴스를 가리켜야 한다.

         * Optional 없이 적었더니 한 줄 다 빨간 줄 떠서 전구 눌렀더니 Optional 추가하라고 떴는데 왜 넣어야 하는지 ?
      */

        Optional<Schedule> ScheduleCheck = scheduleRepository.findById(id);
        return ScheduleCheck.stream().map(schedule -> ScheduleResponseDto.builder()
                .id(schedule.getId())
                .title(schedule.getTitle())
                .contents(schedule.getContents())
                .manager(schedule.getManager())
                .createdAt(schedule.getCreatedAt())
                .build())
                .toList();
    }

    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("찾는 일정이 없습니다."));

        schedule.update(scheduleRequestDto);

        return ScheduleResponseDto.builder()
                .id(schedule.getId())
                .title(schedule.getTitle())
                .contents(schedule.getContents())
                .manager(schedule.getManager())
                .createdAt(schedule.getCreatedAt())
                .build();
    }
}
