package combat.java.rest;

import combat.java.entity.Announcement;
import combat.java.service.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/announcements")
@RequiredArgsConstructor
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @GetMapping
    public List<Announcement> findAll(){
        return announcementService.listAnnouncement();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Announcement createAnnouncement(@RequestBody Announcement announcement){
        return announcementService.createAnnouncement(announcement);
    }

    @GetMapping("/{id}")
    public Optional<Announcement> listUser(@PathVariable Integer id){
        return announcementService.listAnnouncement(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAnnouncement(@PathVariable Integer id){
        announcementService.deleteAnnouncement(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateAnnouncement(@PathVariable Integer id, @RequestBody Announcement announcement){
        announcementService.update(id,announcement);
    }


}
