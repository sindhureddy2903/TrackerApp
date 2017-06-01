package io.tracking.repository;


import com.sun.org.apache.regexp.internal.RE;
import io.tracking.entity.Readings;
import io.tracking.entity.tiress;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

public interface ReadingsRepository {
    List<Readings> findAll();

    Readings findOne(String vin);

    Readings create(Readings readings, tiress tire);

    Readings update(Readings readings);

    void delete(Readings readings);
}
