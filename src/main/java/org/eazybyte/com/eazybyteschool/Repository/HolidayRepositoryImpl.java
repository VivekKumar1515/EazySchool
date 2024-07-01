package org.eazybyte.com.eazybyteschool.Repository;

import org.eazybyte.com.eazybyteschool.Model.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class HolidayRepositoryImpl {

    @Autowired
    HolidayRepository holidayRepository;

    public List<Holiday> findAllHolidays() {
        Iterable<Holiday> holidays = holidayRepository.findAll();
        List<Holiday> holidaysList = StreamSupport.stream(holidays.spliterator(), false).collect(Collectors.toList());
        return holidaysList;
    }
}
