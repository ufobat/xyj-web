package de.senfdax.xyjweb.controller

import de.senfdax.xyjweb.UploadedDocument
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@RestController
class HtmlController {

    @PostMapping("/upload")
    fun blog(@RequestBody doc: UploadedDocument): UploadedDocument {
        println("upload called");
        println(doc)
        return UploadedDocument(id = 1000, content = "<bla></bla>")
    }
}
