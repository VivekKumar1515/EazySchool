package org.eazybyte.com.eazybyteschool.Repository;

import org.eazybyte.com.eazybyteschool.Model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayRepository extends CrudRepository<Holiday, Integer> {
}
