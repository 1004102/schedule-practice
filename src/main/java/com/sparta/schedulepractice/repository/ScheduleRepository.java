package com.sparta.schedulepractice.repository;

import com.sparta.schedulepractice.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
