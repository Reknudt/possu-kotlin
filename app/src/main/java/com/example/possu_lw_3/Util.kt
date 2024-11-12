package com.example.possu_lw_3

import java.security.MessageDigest

class Util {

    val REG_EX_PASS = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}\\[\\]:;<>,.?/~_+-=|])[A-Za-z0-9*.!@$%^&(){}\\[\\]:;<>,.?/~_+-=|]{8,32}$"
    val REG_EX_EMAIL = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
    val REG_EX_LOGIN = "^(?![0-9])[a-zA-Z0-9_]{3,20}$"
    val REG_EX_PHONE = "^\\+375(29|33|44|25|17|16|15|41|43|52|54)\\d{7}\$"

    val emailPattern = Regex(REG_EX_EMAIL)
    val passPattern = Regex(REG_EX_PASS)
    val loginPattern = Regex(REG_EX_LOGIN)
    val phonePattern = Regex(REG_EX_PHONE)

    public fun hashValue(value: String): String {
        val digest = MessageDigest.getInstance("SHA-256")
        val hashedBytes = digest.digest(value.toByteArray())
        return hashedBytes.joinToString("") { "%02x".format(it) }
    }
}

//goodPass1234!
//Kirill
//Polina
//9900polyMile!