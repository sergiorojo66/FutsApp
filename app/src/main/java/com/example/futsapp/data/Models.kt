package com.example.futsapp.data


import java.time.LocalDateTime


data class Player(
    val id: String,
    val name: String,
    val goals: Int = 0,
    val assists: Int = 0
) {
    val goalsPlusAssists: Int get() = goals + assists
}


data class Team(
    val id: String,
    val name: String,
    val players: List<Player>,
    val played: Int = 0,
    val wins: Int = 0,
    val draws: Int = 0,
    val losses: Int = 0,
    val goalsFor: Int = 0,
    val goalsAgainst: Int = 0
) {
    val points: Int get() = wins * 3 + draws
    val goalDifference: Int get() = goalsFor - goalsAgainst
}


data class Match(
    val id: String,
    val homeTeamId: String,
    val awayTeamId: String,
    val date: LocalDateTime,
    val homeGoals: Int? = null,
    val awayGoals: Int? = null
)


// Category contains teams and matches
data class Category(
    val id: String,
    val name: String, // "2º", "1º", "División de Honor"
    val teams: List<Team>,
    val matches: List<Match>
)


data class Province(
    val id: String,
    val name: String, // "Palencia"
    val categories: List<Category>
)