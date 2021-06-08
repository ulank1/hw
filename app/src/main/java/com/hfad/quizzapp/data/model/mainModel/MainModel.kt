package com.hfad.quizzapp.data.model.mainModel

import java.io.Serializable


data class MainModel (
    var amount: Int = 0,
    var category: Int = 0,
    var difficulty: String = ""
) : Serializable
