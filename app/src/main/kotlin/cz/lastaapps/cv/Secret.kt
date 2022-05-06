package cz.lastaapps.cv

import java.time.LocalDate

interface Secret {
    val name: String
    val aboutMe: String
    val education: List<String>
    val experience: List<String>
    val projects: List<Pair<String, String?>>
    val other: List<String>
    val ending: String

    val bornWhen: LocalDate
    val bornWhere: String
    val email: String
    val phoneNumber: String
    val addressHouse: String
    val addressTown: String
    val weblinks: List<Pair<String, String?>>
}