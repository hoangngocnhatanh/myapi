package org.d.groovy.api

import com.fasterxml.jackson.databind.ObjectMapper
import io.swagger.annotations.ApiOperation
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import javax.validation.Valid

@Controller
@RequestMapping("\${base-path:/api/}")
class DemoController {
    ObjectMapper json = new ObjectMapper()

    @ApiOperation(value = "Lấy danh sách Số đối tác momo", notes = "", tags = ["demo"])
    @RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE], method = RequestMethod.GET, value = "get")
    ResponseEntity<?> getApi() {
        return ResponseEntity.ok().body("Hello")
    }
}
