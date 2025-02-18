package cu.my.practice.kmp.core.model.wallet

import cu.my.practice.kmp.core.model.main.PaymentMethodKey


data class PayCreate(
    val paymentMethod: PaymentMethodKey,
    val transactionUUID: String,
    val statusCode: Int,
    val statusName: String,
    val links: List<Link>,
    val commission: String? = null,
    val returnUrl: String,
    val cancelUrl: String,
    val qr: String? = null,
)
