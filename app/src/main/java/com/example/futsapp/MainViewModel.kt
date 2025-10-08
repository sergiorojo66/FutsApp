package com.example.futsapp


import androidx.lifecycle.ViewModel
import com.example.futsapp.data.Province
import com.example.futsapp.data.SampleRepository


class MainViewModel: ViewModel() {
    var provinces: List<Province> = SampleRepository.getAllProvinces()
    // Simple auth state (mock)
    var loggedInUser: String? = null
    fun login(username: String, password: String): Boolean {
// Mock: accept any non-empty credentials
        if (username.isNotBlank() && password.isNotBlank()) {
            loggedInUser = username
            return true
        }
        return false
    }
    fun signup(username: String, password: String): Boolean {
// Mock: always succeed if non-empty
        if (username.isNotBlank() && password.isNotBlank()) {
            loggedInUser = username
            return true
        }
        return false
    }
    fun logout() { loggedInUser = null }
}