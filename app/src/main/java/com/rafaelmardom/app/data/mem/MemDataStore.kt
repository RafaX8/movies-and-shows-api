package com.rafaelmardom.app.data.mem

class MemDataStore <T>{
    private val dataStore: MutableMap<String, T> = mutableMapOf()

    fun put(id: String, model: T) {
        dataStore.put(id, model)
    }

    fun get(id: String) = dataStore[id]

    fun getAll() = dataStore.map{entry ->
        entry.value
    }
}