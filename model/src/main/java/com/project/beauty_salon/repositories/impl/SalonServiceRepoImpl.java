package com.project.beauty_salon.repositories.impl;

import com.project.beauty_salon.domain.SalonService;
import com.project.beauty_salon.repositories.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository
public class SalonServiceRepoImpl implements IRepository<SalonService> {
    private static final BeanPropertyRowMapper<SalonService> ROW_MAPPER =
            new BeanPropertyRowMapper<>(SalonService.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SalonServiceRepoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<SalonService> getAll() {
        return jdbcTemplate.query("SELECT * FROM salon_services;", ROW_MAPPER);
    }

    @Override
    public Optional<SalonService> create(SalonService salonService) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps =
                    connection.prepareStatement("insert into salon_services(service_name, price, duration) " +
                                    "values (?,?,?)",
                            new String[]{"id"});
            ps.setString(1, salonService.getServiceName());
            ps.setInt(2, salonService.getPrice());
            ps.setInt(3, salonService.getDuration());
            return ps;
        }, keyHolder);
        long salonId = keyHolder.getKey().longValue();
        return getById(salonId);
    }

    @Override
    public Optional<SalonService> getById(Long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT * FROM salon_services WHERE id = ?", ROW_MAPPER, id));
    }

    @Override
    public Optional<SalonService> update(Long id, SalonService salon) {
        jdbcTemplate.update("update salon_services set id = ?," +
                        " service_name = ?," +
                        " price = ?," +
                        " duration =? where id = ? ",
                salon.getServiceName(),
                salon.getPrice(),
                salon.getDuration(), id);
        return getById(id);
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM salon_services where id = ?", id);
    }
}
