package combat.java.service;

import combat.java.entity.Announcement;
import combat.java.entity.User;
import combat.java.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AnnouncementService {

    @Autowired
    private AnnouncementRepository announcementRepository;


    public List<Announcement> listAnnouncement(){
        return announcementRepository.findAll();
    }

    public Announcement createAnnouncement(Announcement announcement){
        return announcementRepository.save(announcement);
    }

    public Optional<Announcement> listAnnouncement(Integer id){
        return announcementRepository.findById(id);
    }

    public void deleteAnnouncement(Integer id){
        announcementRepository.findById(id);
        announcementRepository.deleteById(id);
    }

    public void update (Integer id, Announcement announcementUpdated) {
        announcementRepository.
                findById(id)
                .map(announcement -> {
                    announcementUpdated.setId(announcement.getId());
                    announcementUpdated.setCreatedAt(announcement.getCreatedAt());
                    return announcementRepository.save(announcementUpdated);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não atualizado!"));
    }
}
