package com.example.socialnetwork.repository.impl;

import com.example.socialnetwork.entity.User;
import com.example.socialnetwork.entity.enums.Gender;
import com.example.socialnetwork.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Properties;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final JdbcTemplate jdbcTemplate;
    private final Properties userSqlQueries;

    @Override
    public UUID save(User user) {
        String sql = getQuery("insert_user");
        UUID generatedId = UUID.randomUUID();
        jdbcTemplate.update(sql,
                generatedId,
                user.getFirstName(),
                user.getLastName(),
                user.getBirthDate(),
                user.getGender().getValue(),
                user.getInterests(),
                user.getCity(),
                user.getEmail(),
                user.getPassword()
        );
        return generatedId;
    }

    @Override
    public Optional<User> findById(UUID userId) {
        String sql = getQuery("select_user_by_id");
        return findSingleResult(sql, userId);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        String sql = getQuery("select_user_by_email");
        return findSingleResult(sql, email);
    }

    private Optional<User> findSingleResult(String sql, Object... params) {
        try {
            return Optional.ofNullable(
                    jdbcTemplate.queryForObject(sql, userRowMapper(), params)
            );
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    private RowMapper<User> userRowMapper() {
        return (rs, rowNum) -> {
            User user = new User();
            String id = rs.getString("id");
            if (id != null) {
                user.setId(UUID.fromString(id));
            }
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setBirthDate(rs.getObject("birth_date", LocalDate.class));
            String genderStr = rs.getString("gender");
            if (genderStr != null) {
                user.setGender(Gender.fromString(genderStr));
            }
            user.setInterests(rs.getString("interests"));
            user.setCity(rs.getString("city"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            return user;
        };
    }

    private String getQuery(String key) {
        String query = userSqlQueries.getProperty(key);
        if (query == null) {
            throw new IllegalArgumentException("SQL query not found for key: " + key);
        }
        return query;
    }
}
