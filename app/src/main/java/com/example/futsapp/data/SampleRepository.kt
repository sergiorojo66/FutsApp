package com.example.futsapp.data

import java.time.LocalDateTime


object SampleRepository {
    // Simple sample data for Palencia
    private val playersTeamA = listOf(
        Player("p1","Carlos Gómez", 6, 3),
        Player("p2","Miguel Ruiz", 4, 1),
        Player("p3","Raúl Pérez", 2, 4)
    )
    private val playersTeamB = listOf(
        Player("p4","Jorge Díaz", 8, 2),
        Player("p5","Álvaro Soto", 3, 5)
    )
    private val playersTeamC = listOf(
        Player("p6","Sergio Lara", 5, 0),
        Player("p7","Pablo Martín", 1, 1)
    )


    private val teamA = Team("tA","Palencia CF A", playersTeamA, played=10, wins=7, draws=1, losses=2, goalsFor=34, goalsAgainst=18)
    private val teamB = Team("tB","UD Boedo", playersTeamB, played=10, wins=8, draws=0, losses=2, goalsFor=40, goalsAgainst=20)
    private val teamC = Team("tC","CD Norte", playersTeamC, played=10, wins=6, draws=2, losses=2, goalsFor=30, goalsAgainst=22)


    private val match1 = Match("m1","tA","tB", LocalDateTime.now().plusDays(2))
    private val match2 = Match("m2","tC","tA", LocalDateTime.now().plusDays(5))
    private val match3 = Match("m3","tB","tC", LocalDateTime.now().plusDays(7))


    val palencia = Province(
        id = "pal",
        name = "Palencia",
        categories = listOf(
            Category("cat3","2º", listOf(teamC, teamA), matches = listOf(match2)),
            Category("cat2","1º", listOf(teamA, teamC, teamB), matches = listOf(match1, match3)),
            Category("cat1","División de Honor", listOf(teamB, teamA), matches = listOf(match1))
        )
    )


    fun getAllProvinces(): List<Province> = listOf(palencia)


    fun getCategory(provinceId: String, categoryId: String): Category? {
        return getAllProvinces().find { it.id == provinceId }?.categories?.find { it.id == categoryId }
    }
}