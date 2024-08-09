package org.blb.service.adsInput;
import org.blb.models.advertising.Advertising;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.blb.models.advertising.Advertising;
import org.blb.repository.advertising.AdvertisingRepository;


@Service
public class CsvService {
    @Autowired
    private AdvertisingRepository reclamaRepository;

    public void saveAll(MultipartFile file) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            List<Advertising> advertisings = reader.lines()
                    .skip(1) // пропускаем заголовок
                    .map(line -> {
                        String[] fields = line.split(",");
                        Advertising advertising = new Advertising();
                        advertising.setTitle(fields[1]);
                        advertising.setDescription(fields[2]);
                        advertising.setAdvertiserName(fields[3]);
                        advertising.setAdvertiserEmail(fields[4]);
                        advertising.setAdvertiserPhone(fields[5]);
                        advertising.setDiscount(fields[6]);
                        advertising.setCreateData(LocalDate.parse(fields[7]));
                        advertising.setEndData(LocalDate.parse(fields[8]));
                        advertising.setAdvertisingCounter(Integer.parseInt(fields[9]));
                        advertising.setDescriptionOfTheCoupon(fields[10]);
                        return advertising;
                    })
                    .collect(Collectors.toList());
            reclamaRepository.saveAll(advertisings);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при сохранении данных из файла: " + e.getMessage());
        }
    }

}


/*
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import org.blb.models.advertising.Advertising;
import org.blb.repository.advertising.AdvertisingRepository;



    @Service
    public class CsvService {
        @Autowired
        private AdvertisingRepository reclamaRepository;

        public  List<Advertising> saveAll(MultipartFile file) {
            List<Advertising> reclamas = new ArrayList<>();
            try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()))) {
                String[] line;

                while ((line = reader.readNext()) != null) {


                    Advertising advertising = new Advertising();


                    advertising.setTitle(line[1]);
                    advertising.setDescription(line[2]);
                    advertising.setAdvertiserName(line[3]);
                    advertising.setAdvertiserPhone(line[5]);
                    advertising.setDiscount(line[6]);
                    advertising.setCreateData(LocalDate.parse(line[7]));
                    advertising.setEndData(LocalDate.parse(line[8]));
                    advertising.setAdvertisingCounter(Integer.parseInt(line[9]));
                    advertising.setDescriptionOfTheCoupon(line[10]);

                    reclamas.add(advertising);

                }


                //reclamaRepository.saveAll(reclamas);
            } catch (Exception e) {
                throw new RuntimeException("Ошибка чтения файла: " + e.getMessage());
                //e.printStackTrace();
            }
            return reclamas;
        }

        public void deleteAll() {
            reclamaRepository.deleteAll();
        }

        public void deleteById(Long id) {
            reclamaRepository.deleteById(id);
        }

    }

 */






