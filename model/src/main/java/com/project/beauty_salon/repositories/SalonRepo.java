package com.project.beauty_salon.repositories;

import com.project.beauty_salon.domain.BeautySalon;
import com.project.beauty_salon.domain.GenderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class SalonRepo implements ISalonRepo {
    private static final BeanPropertyRowMapper<BeautySalon> ROW_MAPPER =
            new BeanPropertyRowMapper<>(BeautySalon.class);
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SalonRepo(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<BeautySalon> getAll() {
        return jdbcTemplate.query("SELECT * FROM salons;", ROW_MAPPER);
    }

    @Override
    public BeautySalon insert(final BeautySalon salon) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps =
                    connection.prepareStatement("insert into salons(salonname, address, hasgiftcertificate,gendertype,worktime,workersqnt) " +
                                    "values (?, ?, ?,?,?,?)",
                            new String[]{"id"});
            ps.setString(1, salon.getSalonName());
            ps.setString(2, salon.getAddress());
            ps.setBoolean(3, salon.getHasGiftCertificate());
            ps.setObject(4, GenderType.class);
            ps.setString(5, salon.getWorkTime());
            ps.setInt(6, salon.getWorkersQnt());
            return ps;
        }, keyHolder);
        long salonId = keyHolder.getKey().longValue();
        return getById(salonId);

    }

    @Override
    public BeautySalon getById(final Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM salons WHERE id = ?", ROW_MAPPER, id);
    }

    @Override
    public BeautySalon update(final Long id, final BeautySalon salon) {
        jdbcTemplate.update("update salons set salonname = ?," +
                        " address = ?," +
                        " hasgiftcertificate = ?," +
                        " gendertype =?," +
                        " worktime=?," +
                        " workersqnt=? where id = ?",
                salon.getSalonName(),
                salon.getAddress(),
                salon.getHasGiftCertificate(),
                salon.getGenderType(),
                salon.getWorkTime(),
                salon.getWorkersQnt(), id);
        return getById(id);

    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM salons where id = ?", id);
    }
}
