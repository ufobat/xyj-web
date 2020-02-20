package de.senfdax.xyjweb

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class UploadedDocument(
        @Id @GeneratedValue val id: Long,
        val content: String
)