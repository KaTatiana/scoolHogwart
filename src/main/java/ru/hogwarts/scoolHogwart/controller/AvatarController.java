package ru.hogwarts.scoolHogwart.controller;

import org.springframework.data.util.Pair;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.scoolHogwart.service.AvatarService;

import java.io.IOException;

@RestController
@RequestMapping("/avatar")
public class AvatarController {
    private final AvatarService avatarService;

    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }

    @PostMapping
    public void uploadAvatar(@RequestParam MultipartFile avatar) throws IOException {
        avatarService.uploadAvatar(avatar);
    }
    @GetMapping({"/{id}/from-db"})
   public ResponseEntity<byte[]> readAvatarFromDb(@PathVariable long id){
        return readAvatar((Pair<String, byte[]>) avatarService.readAvatarFromDb(id));
   }
    @GetMapping({"/{id}/from-fs"})
   public ResponseEntity<byte[]> readAvatarFromFs(@PathVariable long id)throws Exception{
        return readAvatar((Pair<String, byte[]>) avatarService.readAvatarFromFs(id));
    }
    private ResponseEntity<byte[]> readAvatar(Pair<String, byte[]> pair){
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(pair.getFirst()))
                .contentLength(pair.getSecond().length)
                .body(pair.getSecond());
}
}
