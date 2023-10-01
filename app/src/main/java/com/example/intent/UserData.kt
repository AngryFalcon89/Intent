package com.example.intent

import java.io.Serializable

class UserData: Serializable{
    lateinit var name: String
    var age: Byte = -1
    lateinit var phone : String
    lateinit var email: String
}
