package com.charter.codingTest.controller;

import com.charter.codingTest.exception.CodingTestException;
import com.charter.codingTest.model.CodingTestResponse;
import com.charter.codingTest.model.CodingTestVO;
import com.charter.codingTest.service.CodingTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/codingTest")
public class CodingTestController {

    @Autowired
    private CodingTestService codingTestService;

    /**
     * Calculate rewards points.
     * @param purchasedList {@link CodingTestVO}
     * @return CodingTestResponse
     */
    @RequestMapping(value = "/calculate-rewards", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<CodingTestResponse> calculateRewards(@RequestBody List<CodingTestVO> purchasedList) {
        try {
            return new ResponseEntity<CodingTestResponse>(this.codingTestService.calculateRewards(purchasedList), HttpStatus.OK);
        } catch (CodingTestException ex) {
            return new ResponseEntity<CodingTestResponse>(HttpStatus.BAD_REQUEST);
        }
    }

}