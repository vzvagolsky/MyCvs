package org.blb.controller.advertising;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.blb.DTO.advertisingDto.AdditionalResponseDto;
import org.blb.DTO.advertisingDto.AdvertisingRequestDto;
import org.blb.DTO.advertisingDto.AdvertisingResponseDto;
import org.blb.DTO.advertisingDto.ShortAdvertisingResponseDto;
import org.blb.DTO.appDTO.StandardResponseDto;
import org.blb.controller.api.advertising.AdvertisingApi;
import org.blb.controller.api.advertising.AddAdvertising;
import org.blb.controller.api.advertising.DeleteAdvertising;
import org.blb.service.advertising.CreateAdvertisingService;
import org.blb.service.advertising.DeleteAdvertisingService;
import org.blb.service.advertising.FindAdvertisingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


///////////////////////////////////////////////////////////////////////////////////////////

//@RestController
//
//@RequiredArgsConstructor
//public class AdvertisingController
//     implements AdvertisingApi, DeleteAdvertising, AddAdvertising
//{
//
//    private final CreateAdvertisingService createAdvertisingService;
//    private final DeleteAdvertisingService deleteAdvertisingService;
//    private final FindAdvertisingService findAdvertisingService;
//
////    @PostMapping
//    public ResponseEntity<AdvertisingResponseDto> addAdvertising(@RequestBody AdvertisingRequestDto requestDto) {
//        AdvertisingResponseDto responseDto = createAdvertisingService.addAdvertising(requestDto);
//        return ResponseEntity.ok(responseDto);
//    }
//
////    @DeleteMapping("/{id}")
//    public ResponseEntity<StandardResponseDto> deleteAdvertising(@PathVariable Long id) {
//        deleteAdvertisingService.deleteAdvertising(id);
//        return ResponseEntity.noContent().build();
//    }
//
////    @GetMapping("/email/{email}")
//    public ResponseEntity<AdvertisingResponseDto> findByAdvertiserEmail(@PathVariable String email) {
//        AdvertisingResponseDto responseDto = findAdvertisingService.findByAdvertiserEmail(email);
//        return ResponseEntity.ok(responseDto);
//    }
//
////    @GetMapping
////    public ResponseEntity<List<ShortAdvertisingResponseDto>> findAll() {
////        List<ShortAdvertisingResponseDto> responseDtos = findAdvertisingService.findAll();
////        return ResponseEntity.ok(responseDtos);
////    }
//
////    @GetMapping("/{id}")
//    public ResponseEntity<AdditionalResponseDto> findAdvertisingById(@PathVariable Long id) {
//        AdditionalResponseDto responseDto = findAdvertisingService.findAdvertisingById(id);
//        return ResponseEntity.ok(responseDto);
//    }
//
////    @GetMapping()
//    public ResponseEntity<List<ShortAdvertisingResponseDto>> findFiveRandomAdvertisings() {
//        List<ShortAdvertisingResponseDto> responseDtos = findAdvertisingService.findFiveRandomAdvertisings();
//        return ResponseEntity.ok(responseDtos);
//    }
//}

////////////////////////////////////////////////////////////////////////////////////////////////////



//@RestController
//
//@RequiredArgsConstructor
//@RequestMapping("/ads")
//public class AdvertisingController
//        //implements AdvertisingApi, DeleteAdvertising, AddAdvertising
//{
//
//    private final CreateAdvertisingService createAdvertisingService;
//    private final DeleteAdvertisingService deleteAdvertisingService;
//    private final FindAdvertisingService findAdvertisingService;
//
//    //    @PutMapping
//    public ResponseEntity<AdvertisingResponseDto> addAdvertising(@RequestBody AdvertisingRequestDto requestDto) {
//        AdvertisingResponseDto responseDto = createAdvertisingService.addAdvertising(requestDto);
//        return ResponseEntity.ok(responseDto);
//    }
//
//       @DeleteMapping("/{id}")
//    public ResponseEntity<StandardResponseDto> deleteAdvertising(@PathVariable Long id) {
//        deleteAdvertisingService.deleteAdvertising(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/email/{email}")
//    public ResponseEntity<AdvertisingResponseDto> findByAdvertiserEmail(@PathVariable String email) {
//        AdvertisingResponseDto responseDto = findAdvertisingService.findByAdvertiserEmail(email);
//        return ResponseEntity.ok(responseDto);
//    }
//
//
//
//    // @CrossOrigin(origins = "http://localhost:5173")
//    @GetMapping("/{id}")
//    public ResponseEntity<AdditionalResponseDto> findAdvertisingById(@PathVariable Long id) {
//        AdditionalResponseDto responseDto = findAdvertisingService.findAdvertisingById(id);
//        return ResponseEntity.ok(responseDto);
//    }
//
//
//    // @CrossOrigin(origins = "http://localhost:5173")
//    @GetMapping()
//    public ResponseEntity<List<ShortAdvertisingResponseDto>> findFiveRandomAdvertisings() {
//        List<ShortAdvertisingResponseDto> responseDtos = findAdvertisingService.findFiveRandomAdvertisings();
//        return ResponseEntity.ok(responseDtos);
//    }
//
//
//}
//
//
@RestController
@RequiredArgsConstructor
public class AdvertisingController implements AdvertisingApi, DeleteAdvertising, AddAdvertising {
    private final CreateAdvertisingService createAdvertisingService;
    private final DeleteAdvertisingService deleteAdvertisingService;
    private final FindAdvertisingService findAdvertisingService;

    @Override
    public ResponseEntity<AdvertisingResponseDto> addAdvertising(@RequestBody @Valid AdvertisingRequestDto requestDto) {
        AdvertisingResponseDto responseDto = createAdvertisingService.addAdvertising(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<StandardResponseDto> deleteAdvertising(@PathVariable Long id) {
        deleteAdvertisingService.deleteAdvertising(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<AdvertisingResponseDto> findByAdvertiserEmail(@PathVariable String email) {
        AdvertisingResponseDto responseDto = findAdvertisingService.findByAdvertiserEmail(email);
        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<AdditionalResponseDto> findAdvertisingById(@PathVariable Long id) {
        AdditionalResponseDto responseDto = findAdvertisingService.findAdvertisingById(id);
        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<List<ShortAdvertisingResponseDto>> findFiveRandomAdvertisings() {
        List<ShortAdvertisingResponseDto> responseDtos = findAdvertisingService.findFiveRandomAdvertisings();
        return ResponseEntity.ok(responseDtos);
    }

    @Override
    public ResponseEntity<List<AdvertisingResponseDto>> findAll() {
        List<AdvertisingResponseDto> responseDtos = findAdvertisingService.findAll();
        return ResponseEntity.ok(responseDtos);
    }
}