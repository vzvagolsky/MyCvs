package org.blb.controller.adsInput;
import org.blb.DTO.advertisingDto.AdvertisingResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.blb.service.adsInput.CsvService;




@RestController
    @RequestMapping("/file")
    public class AdsInputController {


        @Autowired
        private CsvService csvService;






        @PostMapping("/load")

        public String loadAll(@RequestParam("file") MultipartFile file)
        {
            csvService.saveAll(file);
            return "File loaded successfully" ;
        }




        @DeleteMapping("/deleteAll")
        public String deleteAll() {
           // csvService.deleteAll();
            return "All records deleted successfully";
        }

        @DeleteMapping("/delete/{id}")
        public String deleteById(@PathVariable Long id) {
          //  csvService.deleteById(id);
            return "Record with id " + id + " deleted successfully";
        }





}



