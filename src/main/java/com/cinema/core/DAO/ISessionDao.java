package com.cinema.core.DAO;

import com.cinema.core.entity.Session;

import java.math.BigDecimal;
import java.util.List;

public interface ISessionDao {
    public boolean addSession(Long filmId, BigDecimal ticketPrice, Long hallId, String sessionTime) throws DAOException;
    public  boolean removeSessionById(Long id) throws DAOException;
    public List<Session> getAllSessionsByFilmId(Long filmId) throws DAOException;
}
