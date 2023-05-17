package co.gov.heqc.healthcite.controllers;

import co.gov.heqc.healthcite.dto.request.PersonRequestDto;
import co.gov.heqc.healthcite.dto.response.PersonResponseDto;
import co.gov.heqc.healthcite.services.PeopleService;
import co.gov.heqc.healthcite.utils.constants.GlobalConstants;
import co.gov.heqc.healthcite.utils.constants.PeopleConstants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PeopleRestController {

    private final PeopleService peopleService;

    @PostMapping("/")
    public ResponseEntity<Map<String, String>> createPerson(@Valid @RequestBody PersonRequestDto personRequest) {
        peopleService.createPerson(personRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Collections.singletonMap(
                        GlobalConstants.RESPONSE_MESSAGE_KEY,
                        PeopleConstants.PERSON_CREATED_MESSAGE));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponseDto> getPersonById(@PathVariable Long id) {
        return ResponseEntity.ok(peopleService.getPersonById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<PersonResponseDto>> getAllPeople() {
        return ResponseEntity.ok(peopleService.getAllPeople());
    }

}