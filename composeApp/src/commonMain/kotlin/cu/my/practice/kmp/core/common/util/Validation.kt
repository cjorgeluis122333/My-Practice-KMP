package cu.my.practice.kmp.core.common.util

private object Regex {
    //Regex for validate email address
    const val REGEX_EMAIL_VALIDATION =
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"

    //Regex for validate identity card of 11 digit
    const val REGEX_IDENTITY_CARD_VALIDATION =
        "^([1-9][0-9]{0,12})?(\\\\.[0-9]?)?\$"

}
fun String.isValidEmail(): Boolean =
    Regex.REGEX_EMAIL_VALIDATION.toRegex().matches(this)

fun String.isValidIdentityCard(): Boolean =
    Regex.REGEX_IDENTITY_CARD_VALIDATION.toRegex().matches(this)

