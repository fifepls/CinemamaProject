package com.cinema.core.controller;

import com.cinema.core.entity.Film;
import com.cinema.core.entity.Session;
import com.cinema.core.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/admin")
//дописать преауторайзы для методов
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/add/film")
    public Boolean addFilm(@RequestParam(value = "title")String title,
                          @RequestParam(value = "description") String description){
        return adminService.adminAddNewFilm(title,description);
    }

    @GetMapping("/get/films")
    public List<Film> getFilms(){
        return adminService.adminGetAllFilms();
    }

    @DeleteMapping("/rem/film")
    public Boolean removeFilm(@RequestParam(value = "id")Long id){
        adminService.adminRemoveFilmById(id);
        return adminService.adminRemoveFilmById(id);
    }

    @PostMapping("/update/film")
    public Boolean updateFilm(@RequestParam(value = "id") Long id,
                             @RequestParam(value = "title")String title,
                             @RequestParam(value = "description")String description){
        adminService.adminUpdateFilmById(id,title,description);
        return adminService.adminUpdateFilmById(id,title,description);
    }


    @PostMapping("/add/session")
    public Boolean addSession(@RequestParam(value = "filmId") Long id,
                             @RequestParam(value = "ticketPrice") BigDecimal ticketPrice,
                             @RequestParam(value = "hallId") Long hallId,
                             @RequestParam(value = "sessionTime") String sessionTime){
        return adminService.adminAddSession(id, ticketPrice, hallId, sessionTime);
    }

    @DeleteMapping("/rem/session")
    public Boolean removeSessionById(@RequestParam(value = "sessionId") Long sessionId){
        adminService.adminRemoveSessionById(sessionId);
        return adminService.adminRemoveSessionById(sessionId);
    }

    @GetMapping("/get/sessions")
    public List<Session> getAllSessionsByFilmId(@RequestParam(value = "filmId") Long filmId){
        adminService.adminGetAllSessionsByFilmId(filmId);
        return adminService.adminGetAllSessionsByFilmId(filmId);
    }

    @PostMapping("/add/hall")
    public Boolean addHall(){
        adminService.adminAddHall();
        return adminService.adminAddHall();
    }

    @DeleteMapping("/rem/hall")
    public Boolean removeHall(@RequestParam(value = "hallId") Long id){
        adminService.adminRemoveHall(id);
        return adminService.adminRemoveHall(id);
    }





}
