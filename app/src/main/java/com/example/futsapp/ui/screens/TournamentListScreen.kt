package com.example.futsapp.ui.screens

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brightness4
import androidx.compose.material.icons.filled.Brightness7
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TournamentListScreen(navController: NavController) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Clasificación", "Encuentros", "Goles", "Asistencias", "G + A")

    // ✅ Correcto: llamar aquí dentro de un contexto composable
    val systemDarkMode = isSystemInDarkTheme()
    var isDarkMode by remember { mutableStateOf(systemDarkMode) }

    // Usamos el tema dinámico
    MaterialTheme(colorScheme = if (isDarkMode) darkColorScheme() else lightColorScheme()) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Torneo FutsApp",
                            style = MaterialTheme.typography.headlineSmall.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )
                    },
                    actions = {
                        // 🌙☀️ Botón para cambiar tema
                        IconButton(onClick = { isDarkMode = !isDarkMode }) {
                            Icon(
                                imageVector = if (isDarkMode) Icons.Filled.Brightness7 else Icons.Filled.Brightness4,
                                contentDescription = "Cambiar tema"
                            )
                        }
                    }
                )
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                TabRow(selectedTabIndex = selectedTabIndex) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTabIndex == index,
                            onClick = { selectedTabIndex = index },
                            text = { Text(title) }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                when (selectedTabIndex) {
                    0 -> ClasificacionTab()
                    1 -> EncuentrosTab()
                    2 -> GolesTab()
                    3 -> AsistenciasTab()
                    4 -> GolAsistTab()
                }
            }
        }
    }
}

// ---------------------------
// 🏆 Pestaña de Clasificación
// ---------------------------
@Composable
fun ClasificacionTab() {
    data class Equipo(
        val puesto: Int,
        val nombre: String,
        val pj: Int,
        val pg: Int,
        val pe: Int,
        val pp: Int,
        val puntos: Int
    )

    val equipos = listOf(
        Equipo(1, "Los Galácticos", 5, 5, 0, 0, 15),
        Equipo(2, "Futsal United", 5, 3, 1, 1, 10),
        Equipo(3, "La Roja", 5, 2, 2, 1, 8),
        Equipo(4, "Street FC", 5, 1, 1, 3, 4),
        Equipo(5, "Atlético Indoor", 5, 0, 0, 5, 0)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Clasificación",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Cabecera de tabla
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Pos", fontWeight = FontWeight.Bold, modifier = Modifier.weight(0.5f))
            Text("Equipo", fontWeight = FontWeight.Bold, modifier = Modifier.weight(2f))
            Text("PJ", fontWeight = FontWeight.Bold, modifier = Modifier.weight(0.5f))
            Text("PG", fontWeight = FontWeight.Bold, modifier = Modifier.weight(0.5f))
            Text("PE", fontWeight = FontWeight.Bold, modifier = Modifier.weight(0.5f))
            Text("PP", fontWeight = FontWeight.Bold, modifier = Modifier.weight(0.5f))
            Text("Pts", fontWeight = FontWeight.Bold, modifier = Modifier.weight(0.7f))
        }

        Divider(thickness = 1.dp)

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(equipos) { equipo ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("${equipo.puesto}", modifier = Modifier.weight(0.5f))
                    Text(equipo.nombre, modifier = Modifier.weight(2f))
                    Text("${equipo.pj}", modifier = Modifier.weight(0.5f))
                    Text("${equipo.pg}", modifier = Modifier.weight(0.5f))
                    Text("${equipo.pe}", modifier = Modifier.weight(0.5f))
                    Text("${equipo.pp}", modifier = Modifier.weight(0.5f))
                    Text(
                        "${equipo.puntos}",
                        modifier = Modifier.weight(0.7f),
                        fontWeight = FontWeight.Bold
                    )
                }
                Divider()
            }
        }
    }
}

// ---------------------------
// 📅 Otras pestañas (placeholder)
// ---------------------------
@Composable fun EncuentrosTab() = Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { Text("Próximos encuentros 📅") }
@Composable fun GolesTab() = Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { Text("Tabla de goleadores ⚽") }
@Composable fun AsistenciasTab() = Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { Text("Tabla de asistentes 🎯") }
@Composable fun GolAsistTab() = Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { Text("Tabla combinada de G + A ⚡") }
